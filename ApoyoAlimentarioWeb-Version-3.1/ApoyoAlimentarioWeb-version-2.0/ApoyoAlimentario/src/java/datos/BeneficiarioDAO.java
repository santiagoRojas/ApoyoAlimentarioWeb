/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author Jorge_Andres
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Beneficiario;
import negocio.Controlador;
import util.RHException;
import util.ServiceLocator;

public class BeneficiarioDAO {
    String mensaje = "";
    Controlador control = new Controlador();
    
    public BeneficiarioDAO(){
        
    }
        public String incluirBeneficiario(Beneficiario beneficiario, String usuario, String contrasenia){
        
        ServiceLocator myConn = ServiceLocator.getInstance();
        String sql2 ="SELECT BENEF.NEXTVAL FROM DUAL";
        String strSQL = "INSERT INTO BEN (k_idBeneficiario, n_nombreBeneficiario, n_apellidoBeneficiario, n_estadoBeneficiario, k_tipoApoyo, k_numeroRetiro, k_codigoConvocatoria) VALUES(?,?,?,?,?,?,?)";
      try {
        //insercion de un nuevo beneficiario.

        Connection conexion = myConn.tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        PreparedStatement ps2 = conexion.prepareStatement(sql2);
        
        ResultSet rs = ps2.executeQuery();
        rs.next();
        
         int llave = Integer.parseInt(rs.getString(1));

        prepStmt.setInt(1, llave);
        prepStmt.setString(2, beneficiario.getNombre());
        prepStmt.setString(3, beneficiario.getApellido());
        prepStmt.setString(4, beneficiario.getEstado());
        prepStmt.setInt(5, beneficiario.getId_tipoApoyo());
        prepStmt.setInt(6, beneficiario.getNum_retiro());
        prepStmt.setInt(7, beneficiario.getCod_convocatoria());
        
        
        prepStmt.executeUpdate();
        prepStmt.close();
        myConn.commit();
        
        mensaje +="Beneficiario agregado correctamente... ";
        crearUsuarioBeneficiario(usuario, contrasenia);
        
      } catch (SQLException e) {
          int code = e.getErrorCode();
          if(code == 1)
              System.out.println("No se puede crear el usuario: "+usuario+", el código: "+beneficiario.getId()+" Ya existe...");
           mensaje+= "\n"+e.getMessage();
      }  finally {
        myConn.liberarConexion();
      }
        return mensaje;
      
    }
        
     public String modificarBeneficiario(Beneficiario beneficiario)throws RHException{
         try {
             String strSQL = "UPDATE beneficiario SET N_ESTADO = ?";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.executeUpdate();
        prepStmt.close();
        ServiceLocator.getInstance().commit();
         } 
         catch(SQLException e) {
             mensaje += "Error al modificar el beneficiario: "+ e;
         } finally {
             ServiceLocator.getInstance().liberarConexion();
         }
        return mensaje;
    }
    
    public Beneficiario buscarBeneficiario(Integer beneficiario_id) throws RHException{
      Beneficiario b = new Beneficiario(); //Instancia el objeto para retornar los datos del beneficiario
      try{
         String strSQL = "SELECT beneficiario_id, estado FROM beneficiario WHERE beneficiario_id = ?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
         PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
         prepStmt.setInt(1,beneficiario_id);
         ResultSet rs = prepStmt.executeQuery();
   
      }
      catch(SQLException ex){
       mensaje += "Error al modificar el beneficiario : "+ ex;
      }
        return null;
      
    }
    
    
      public String crearUsuarioBeneficiario(String usuario, String contrasenia){
        control.logearseComoCreador();//se loggea con creador de usuarios
        StringBuilder sql = new StringBuilder();
        sql.append("CREATE USER "+usuario+" IDENTIFIED BY "+contrasenia+" DEFAULT TABLESPACE DEFUSU TEMPORARY TABLESPACE TEMUSU QUOTA 10M ON DEFUSU");
        ServiceLocator myConn = ServiceLocator.getInstance();
        
        try {
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql.toString());
            
            ps.executeQuery();
            ps.close();
            myConn.commit();
            mensaje += "Se creó el usuario: "+usuario;
         
        } catch (SQLException ex) {
           mensaje+= "\n"+ex;
        }finally{
          ServiceLocator.getInstance().liberarConexion();
      }
        otorgarRolDeBeneficiario(usuario, myConn);//llama el otro metodo de otorgar rol
 
        return mensaje;
    }
      
     public String otorgarRolDeBeneficiario(String usuario, ServiceLocator conexion){
        StringBuilder sql = new StringBuilder();
        sql.append("GRANT R_BENEFICIARIO TO "+usuario);
        
        try {
               Connection conn = conexion.tomarConexion();
                PreparedStatement ps = conn.prepareStatement(sql.toString());
                ps.executeQuery();
                ps.close();
                conexion.commit();
     
        } catch (SQLException ex) {
           System.out.println("No se pudo crear el Rol de beneficiario...");
           mensaje +=ex;
        }finally{
          ServiceLocator.getInstance().liberarConexion();
      }

      return mensaje;
        
    }   
    
}
