package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Controlador;
import negocio.Estudiante;
import util.RHException;
import util.ServiceLocator;

/**
 * @author Jorge_Andres
 * Esta clase encapsula el acceso a la Base de Datos
 */
public class EstudianteDAO {
    /*
     * Constructor de la clase
     */
    Controlador control = new Controlador();
    String mensaje;
    public EstudianteDAO(){
    mensaje = "";
    }
    /**
     * Incluye una nueva fila en la tabla Estudiante.
     * @throws RHException
     */
    public String incluirEstudiante(Estudiante estudiante, String usuario, String contrasenia){

      control.logearseComoAdmin();
      //se loggea como admin
      ServiceLocator myConn = ServiceLocator.getInstance();
      try {
        //insercion de un nuevo estudiante.
        
        String strSQL = "INSERT INTO ESTUDIANTE (k_codigoEstudiante , k_identificacionEstudiante, n_tipoDeIdentificacion, n_nombreEstudiante ,n_apellidoEstudiante ,n_modalidadEstudio , q_matriculaActual , q_telefonoEstudiante , n_correoEstudiante , q_puntajeBasicoMatricula, k_codigoProyecto) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1, estudiante.getCodigo()); 
        prepStmt.setInt(2, estudiante.getIdentificacion());
        prepStmt.setString(3,estudiante.getTipoIdentificacion());
        prepStmt.setString(4, estudiante.getNombres()); 
        prepStmt.setString(5, estudiante.getApellidos()); 
        prepStmt.setString(6, estudiante.getModalidad());
        prepStmt.setInt(7, estudiante.getMatricula()); 
        prepStmt.setInt(8, estudiante.getTelefono());
        prepStmt.setString(9, estudiante.getEmail());
        prepStmt.setInt(10, estudiante.getPuntaje());
        prepStmt.setInt(11, estudiante.getCodigoProyecto());
      
       
        
        prepStmt.executeUpdate();
        prepStmt.close();
        myConn.commit();
        //conexion.commit();

        mensaje += "Se agregó el estudiante: "+estudiante.getNombres()+" satisfactoriamente...";
        crearUsuarioEstudiante(usuario,contrasenia);
      } catch (SQLException e) {
          
         mensaje += "No se pudo crear el estudiante...  \n"+e.getMessage();
         int code = e.getErrorCode();
          //System.out.println(code);
         
         if(code == 1){
           System.out.println("No se puede crear el usuario "+usuario+", el código o ID:  "+estudiante.getCodigo()+" Ya existe");
           
         }
         e.getStackTrace();
         
      }  
      
      finally {
         myConn.liberarConexion();
         
      }
       
      return mensaje;
    }
      
    public String crearUsuarioEstudiante(String usuario, String contrasenia){
        
        StringBuilder sql = new StringBuilder();
        StringBuilder sql2 = new StringBuilder();
        sql2.append("GRANT R_EST TO "+usuario);
        sql.append("CREATE USER "+usuario+" IDENTIFIED BY "+contrasenia+" DEFAULT TABLESPACE DEFUSU TEMPORARY TABLESPACE TEMUSU QUOTA 10M ON DEFUSU");
        ServiceLocator myConn = ServiceLocator.getInstance();
        
        try {
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql.toString());
            
            ps.executeQuery();
            ps.close();
            PreparedStatement ps2 = conn.prepareCall(sql2.toString());
            
            ps2.executeQuery();
            ps2.close();
            
            myConn.commit();
            mensaje += "Se creó el usuario: "+usuario;
            //otorgarRolDeEstudiante(usuario);//llama el otro metodo de otorgar rol
         
        } catch (SQLException ex) {
           mensaje+= "\n"+ex;
        }finally{
          myConn.liberarConexion();
      }
        
 
        return mensaje;
    }
    //no se pudo ingresaer a la conexion, por loque se unio este emtodo con el de crear estudiantes
    public String otorgarRolDeEstudiante(String usuario){
        StringBuilder sql = new StringBuilder();
        sql.append("GRANT R_EST TO "+usuario);
        ServiceLocator myConn = ServiceLocator.getInstance();
        try {
               Connection conn = myConn.tomarConexion();
                PreparedStatement ps = conn.prepareStatement(sql.toString());
                ps.executeQuery();
                ps.close();
                myConn.commit();
                
                System.out.println("Se otorgó el rol de estudiante a "+usuario);
                
                
        } catch (SQLException ex) {
           System.out.println("No se pudo crear el Rol de estudiante...");
           mensaje+="\n"+ex;
        }finally{
          myConn.liberarConexion();
      }
       // System.out.println(otorgarPermisodeConectarse(usuario,conexion));//esta parte no va porque va se le otorga permiso de coenctarse desde el script
      return mensaje;
        
    }
    
       public String otorgarPermisodeConectarse(String usuario,ServiceLocator conexion){
        System.out.println("entre a otorgar ");
        StringBuilder sql = new StringBuilder();
        sql.append("GRANT CONNECT TO "+usuario);//LE PERMITE CONECTARSE
        
        try {
           
            Connection conn = conexion.tomarConexion();
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            ps.executeQuery();
            conexion.commit();
            ps.close();
            System.out.println("Se otorgó el permiso de CONNECT a :"+usuario);
            
            
        } catch (SQLException ex) {
            mensaje+= "NO SE PUDO OTORGAR EL PERMISO DE CONNECT A "+usuario+" : "+ ex;

        }finally{
          ServiceLocator.getInstance().liberarConexion();
        }
        return mensaje;
    }
    
    
    public void modificarEstudiante(){
    }
    
    public Estudiante buscarEstudiante(Integer estudiante_id){
      Estudiante estud = new Estudiante(); //Instancia el objeto para retornar los datos del empleado
      try{
         String strSQL = "SELECT * FROM estudiante WHERE k_codigoEstudiante = ?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
         PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
         prepStmt.setInt(1,estudiante_id);
         ResultSet rs = prepStmt.executeQuery();
          
           while (rs.next()){
            estud.setCodigo(rs.getInt(1));
            estud.setNombres(rs.getString(2));
            estud.setApellidos(rs.getString(3));                
            estud.setModalidad(rs.getString(4)); 
            estud.setMatricula(rs.getInt(5));
            estud.setTelefono(rs.getInt(6));
            estud.setEmail(rs.getString(7));
            estud.setPuntaje(rs.getInt(8));                
            estud.setCodigoProyecto(rs.getInt(9));                
           }
            mensaje += "Transacción realizada exitosamente";
      }catch(SQLException ex){
        mensaje += "No se pudo buscar el estudiante"+ex.getMessage();
     
      } finally{
          ServiceLocator.getInstance().liberarConexion();
      }
      
    return estud;
    }
    
    public void actualizarEstudiante(Estudiante estudiante) {
   
    //Implementar
    }
    
    public String verificarCodigoExiste(long codigo){
        Estudiante estud = new Estudiante();
         try{
            
         String strSQL = "SELECT k_codigoEstudiante FROM estudiante WHERE k_codigoEstudiante = ?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
         PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
         prepStmt.setLong(1, codigo);
         
         ResultSet rs = prepStmt.executeQuery();
        
         mensaje="no existe ningun estudiante con este codigo";
           while (rs.next()){
             mensaje =null;
             estud.setCodigo(rs.getInt(1));              
           }
             System.out.println(estud.getCodigo());
            
      }catch(SQLException ex){
        mensaje += "No se pudo buscar al estudiante"+ex.getMessage();
     
      } finally{
          ServiceLocator.getInstance().liberarConexion();
      }
        return mensaje;
        
    }

}


