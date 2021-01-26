/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Mensajes;
import negocio.Socioeconomico;
import util.ServiceLocator;

/**
 *
 * @author Jorge_Andres
 */
public class InfoSocioEconomicaDAO {
    
      Mensajes men = new Mensajes();
      
      String mensaje = "";
      int primaria;
    
    public Mensajes incluirInfoSocioEconomica(Socioeconomico socio){
      // insertarLlave();
       StringBuilder sql = new StringBuilder();
       StringBuilder sql2 = new StringBuilder();
       sql.append("INSERT INTO SOCIOEC(k_codigoSocioEconomico, i_viveFueraNucleo, i_sostieneHogar, i_sostieneSiMismo, i_tienePersonasACargo, i_condicionEspecial, i_viveCasaEmpleador, i_resideZona, i_discapacidad, i_patologiaSintomatologia, q_valorMatricula, v_ingresosFamiliares, n_formulario, n_cartaAlRector, n_certificadoEstrato, n_facturaServicios, n_reciboPago, n_registroCivilHijos, n_certificadoDiscapacidad, n_certificadoDesplazamiento, n_cartaLaboral, n_examenMedico, n_cartaIndependiente, n_certificadoIngresosReten) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
       sql2.append("SELECT cr1030681971.socio.NEXTVAL FROM DUAL");
       ServiceLocator myConn = ServiceLocator.getInstance();

       try {//inserta los valores de socioeconomico
        Connection conexion = myConn.tomarConexion();
        PreparedStatement ps = conexion.prepareStatement(sql.toString());
        PreparedStatement ps2 = conexion.prepareStatement(sql2.toString());
        
        ResultSet rs = ps2.executeQuery();
        rs.next();

        
        //System.out.println(rs.getString(1));
        int llave = Integer.parseInt(rs.getString(1));

        ps.setInt(1, llave);
        ps.setString(2, socio.getNucleo()); 
        ps.setString(3, socio.getSostieneHogar());
        ps.setString(4, socio.getAutoSostiene());
        ps.setString(5, socio.getPersonasCargo());
        ps.setString(6, socio.getCondicionEsp());
        ps.setString(7, socio.getViveConEmpleador());
        ps.setString(8, socio.getResideZona());
        ps.setString(9, socio.getDiscapacidad());
        ps.setString(10, socio.getPatologia());
        ps.setInt(11, socio.getValormatricula());
        ps.setDouble(12, socio.getIngresos());
        ps.setString(13, socio.getFormulario());
        ps.setString(14, socio.getCartaRector());
        ps.setString(15, socio.getEstratificacion());
        ps.setString(16, socio.getFactura());
        ps.setString(17, socio.getReciboPago());
        ps.setString(18, socio.getRegistroCivil());
        ps.setString(19, socio.getCertificadoDiscapacidad());
        ps.setString(20, socio.getCertificadoDesplazamiento());
        ps.setString(21, socio.getCartaLaboral());
        ps.setString(22, socio.getExamenMedico());
        ps.setString(23, socio.getCartaIndependiente());
        ps.setString(24, socio.getCertificadoIngresosReten());
        ps.executeQuery();
       
        //System.out.println("error del 2 st");
        //ResultSet rs = ps2.executeQuery();

        ps.close();
        myConn.commit();

        mensaje += "Socioeconomico creado exitosamente";
        men.setMensaje(null);
        men.setPrimaria(rs.getInt(1));
      } catch (SQLException e) {
           mensaje += "No se pudo incluir informacion socioeconomica: "+e.getMessage();
           men.setMensaje(mensaje);
           e.printStackTrace();
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
        // men.setPrimaria(obtenerPrimariaActual());//llamo el metodo obtener llave primaria actual
         return men;//retornar el mensaje
      
    }
    
    public Socioeconomico verLinks(int id){//Devuelve un string con el estado de la solicitud
        Socioeconomico so = new Socioeconomico();
        try{

            String strSQL = "SELECT n_formulario FROM SOCIOEC WHERE k_codigoSocioEconomico = ?";
            Connection conexion = ServiceLocator.getInstance().tomarConexion();
            PreparedStatement prepStmt = conexion.prepareStatement(strSQL);

            prepStmt.setInt(1, id);

            ResultSet rs = prepStmt.executeQuery();
            rs.next();
           mensaje += rs.getString(1);
           so.setCodigo(id);
           so.setFormulario(mensaje);
           return so;
         }
         catch(SQLException ex){
            mensaje += "No se puede ver el estado de la solicitud "+ex.getMessage();
            ex.printStackTrace();
            return so;
         }
    }
    public int obtenerPrimariaActual(){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT MAX(k_codigoSocioEconomico) AS id FROM SOCIOECONOMICO");
        ServiceLocator myConn = ServiceLocator.getInstance();
          try { 
              Connection conn = myConn.tomarConexion();
              PreparedStatement ps = conn.prepareStatement(sql.toString());
              ps.executeQuery();
              myConn.commit();
              ps.close();
              
              ResultSet rs = ps.executeQuery();    
              primaria = rs.getInt(1);
              mensaje+="LLAVE OBTENIDA EXITOSAMENTE! ";
              

          } catch (SQLException ex) {
            men.setMensaje(mensaje+=" NO SE PUDO OBTENER LA LLAVE: "+ex);
          }finally {
         ServiceLocator.getInstance().liberarConexion();
            }
          return primaria;
        
    }
    
}
