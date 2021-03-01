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
public class SocioeconomicoDAO {
    
      Mensajes men = new Mensajes();
      
      String mensaje = "";
      int primaria;
    
    public Mensajes incluirInfoSocioEconomica(Socioeconomico socio){
      // insertarLlave();
       StringBuilder sql = new StringBuilder();
       //StringBuilder sql2 = new StringBuilder();
       sql.append("INSERT INTO SOCIOECONOMICO (k_codigoSocioEconomico, n_nombreCondicion, q_puntaje) VALUES(?,?,?)");
      // sql2.append("SELECT ADMIN.SOCIOS.NEXTVAL FROM DUAL");
       ServiceLocator myConn = ServiceLocator.getInstance();

       try {//inserta los valores de socioeconomico
        Connection conexion = myConn.tomarConexion();
        PreparedStatement ps = conexion.prepareStatement(sql.toString());
        //PreparedStatement ps2 = conexion.prepareStatement(sql2.toString());
        
        //ResultSet rs = ps2.executeQuery();
       // rs.next();

       // int llave = Integer.parseInt(rs.getString(1));

        ps.setInt(1, socio.getCodigo());
        ps.setString(2, socio.getNombreCondicion()); 
        ps.setInt(3, socio.getPuntaje());
          
        ps.executeQuery();
        ps.close();
        myConn.commit();

        mensaje += "Socioeconomico creado exitosamente";
        men.setMensaje(mensaje);
        //men.setPrimaria(rs.getInt(1));
        
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
    
    public String actualizarCondicion(int pk,String condicion){
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE SOCIOECONOMICO SET n_nombreCondicion = ? WHERE k_codigoSocioEconomico = ?");
        ServiceLocator myConn = ServiceLocator.getInstance();  
        
        try { 
              Connection conn = myConn.tomarConexion();
              PreparedStatement ps = conn.prepareStatement(sql.toString());
              
              ps.setString(1, condicion);
              ps.setInt(2, pk);
              ps.executeQuery();
              myConn.commit();
              ps.close();       
              mensaje+="Condición Actualizada correctamente";
      
          } catch (SQLException ex) {
            men.setMensaje(mensaje+=" NO SE PUDO ACTUALIZAR EL NOMBRE DE LA CONDICIÓN "+ex);
          }finally {
         ServiceLocator.getInstance().liberarConexion();
           }   
     return mensaje;   
    }
    
    public String eliminarSocioeconomico (int pk){
          ServiceLocator myConn = ServiceLocator.getInstance();
        try {
            
            String sql = "DELETE FROM SOLICITUD_SOCIOECONO WHERE  k_codigoSocioeconomico = ?";
            String sql2 = "DELETE FROM SOLICITUD_SOCIOECONO_DOC WHERE k_codigoSocioeconomico = ?";
            String sql3 = "DELETE FROM SOCIOECONOMICO WHERE k_codigoSocioeconomico = ?";
        
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql);
            PreparedStatement ps2 = conn.prepareCall(sql2);
            PreparedStatement ps3 = conn.prepareCall(sql3);
            ps.setInt(1, pk);
            
            
            ps.executeUpdate();
            ps.close();
            myConn.commit();
            
            ps2.setInt(1, pk);
            ps2.executeUpdate();
            ps2.close();
            
            
            ps3.setInt(1, pk);
            ps3.executeUpdate();
            ps3.close();
            myConn.commit();
            mensaje += "Socioeconomico Eliminado Satisfactoriamente...";
            
        } catch (Exception e) {
            mensaje += "Error al eliminar socioeconomico: "+ e;
        }
        
        return mensaje;
        
    }
    
    
    
}
