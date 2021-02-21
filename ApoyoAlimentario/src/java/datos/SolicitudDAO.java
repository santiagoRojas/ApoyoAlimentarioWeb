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
import java.util.ArrayList;
import negocio.PedirSolicitudes;
import negocio.Solicitud;
import util.RHException;
import util.ServiceLocator;


public class SolicitudDAO {
    String mensaje="";
    int llavesSocio [];
    public SolicitudDAO(){
       
    }
     
  /**
     * Incluye una nueva fila en la tabla Solicitudes
     * @throws RHException
     */
     
  public String incluirSolicitud(Solicitud solicitud, int llavesSocio []){
       StringBuilder sql = new StringBuilder();
       StringBuilder sql2 = new StringBuilder();
       StringBuilder sql3 = new StringBuilder();
       StringBuilder sql4 = new StringBuilder();
       sql.append("INSERT INTO SOL (k_numeroSolicitud,q_puntaje,f_fechaSolicitud,n_estadoSolicitud,n_explicacionEstado,k_codigoSupervisor,k_codigoEstudiante, k_codigoconvocatoria) VALUES(?,?,?,?,?,null,?,?)");
       sql2.append("SELECT ADMIN.SOLICITO.NEXTVAL FROM DUAL");
       sql3.append("INSERT INTO SOLICITUD_SOCIOECONO(K_CODIGOSOCIOECONOMICO, K_NUMEROSOLICITUD, I_ESTADOVERIFICADO, N_OBSERVACION) VALUES(?,?,'PENDIENTE',null)");
       sql4.append("INSERT INTO SOLICITUD_SOCIOECONO_DOC(K_CODIGOSOCIOECONOMICO, K_NUMEROSOLICITUD, K_CODIGODOCUMENTO, N_RUTADOCUMENTO) VALUES(?,?,?,?)");
       
 
       ServiceLocator myConn = ServiceLocator.getInstance();

       try {//inserta los valores de solicitud
        Connection conexion = myConn.tomarConexion();
        PreparedStatement ps = conexion.prepareStatement(sql.toString());
        PreparedStatement ps2 = conexion.prepareStatement(sql2.toString());
        PreparedStatement ps3 = conexion.prepareStatement(sql3.toString());
        PreparedStatement ps4 = conexion.prepareStatement(sql4.toString());
        
        ResultSet rs = ps2.executeQuery();
        rs.next();

        //Se guarda en una variable el valor consultado de la secuencia solicito
        int llaveSolicitud = Integer.parseInt(rs.getString(1));

                ps.setInt(1,llaveSolicitud); 
                ps.setInt(2, solicitud.getPuntaje()); 
                ps.setString(3, solicitud.getFecha());
                ps.setString(4, solicitud.getEstado());               
                ps.setString(5,solicitud.getExplicacion_estado());
                //ps.setInt(6, solicitud.getNumSupervisor());  
                ps.setString(6, solicitud.getCodEstudianteSt());
                ps.setInt(7, solicitud.getNumConvocatoria());

                ps.executeUpdate();
                ps.close();
                myConn.commit();
                //tabla solicitud_socio_econo
               for (int i = 0; i < llavesSocio.length; i++) {
                    ps3.setInt(1,llavesSocio[i]);
                    ps3.setInt(2,llaveSolicitud);
                    //ps3.setString(3, solicitud.getEstado());
                    //ps3.setString(4, solicitud.getExplicacion_estado());
                    ps3.executeUpdate();
                    
                }
                ps3.close();
                myConn.commit();
                
                //tabla solicitud_socio_econo_doc
                for (int i = 0; i < llavesSocio.length; i++) {
                    ps4.setInt(1,llavesSocio[i]);
                    ps4.setInt(2,llaveSolicitud); 
                    ps4.setInt(3, solicitud.getCodigoDoc());
                    ps4.setString(4, solicitud.getRutaDoc());
                    
                    ps4.executeUpdate();
                   
               
                }
                ps4.close();
                myConn.commit();
                
                mensaje+= "Transacción exitosa, solicitud creada correctamente";
            } catch (SQLException ex) {
                mensaje += "No se pudo crear la solicitud "+ex.getMessage();
                ex.getMessage();
                ex.getStackTrace();
            }
            finally{
                myConn.liberarConexion();
            }
        return mensaje; 
    }
    
    public String verEstadoSolicitud(Long id){//Devuelve un string con el estado de la solicitud
        try{
         String strSQL = "SELECT n_estadoSolicitud FROM sol WHERE k_codigoEstudiante = ?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
         PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
         
         prepStmt.setLong(1, id);
         
         ResultSet rs = prepStmt.executeQuery();
         rs.next();
        mensaje += rs.getString(1);
      }
      catch(SQLException ex){
         mensaje += "No se puede ver el estado de la solicitud "+ex.getMessage();
         ex.printStackTrace();
      }
        
        return mensaje;
        
    }
    public String aprobaroRechazarSolicitud(int claveSolicitud, String aprobacion, String comentario, String identificacionSuper){//modicar datos faltaria poner el pk del supervidor en linea
          //ya esta loggeado como supervisor
        ServiceLocator myConn = ServiceLocator.getInstance();
        try {
        String sql3 = "SELECT K_CODIGOSUPERVISOR FROM SUPERVISOR WHERE K_IDENTIFICACIONSUPERVISOR = "+identificacionSuper; 
        Connection conn = myConn.tomarConexion();
        PreparedStatement ps3 = conn.prepareCall(sql3);
        ResultSet rs = ps3.executeQuery();
        rs.next();
        int llave = rs.getInt(1);//obtiene la llave primaria del usuario con el id especificado
        String sql  = "UPDATE SOL SET N_ESTADOSOLICITUD = ?, N_EXPLICACIONESTADO = ?, K_CODIGOSUPERVISOR = "+llave+" WHERE K_NUMEROSOLICITUD = ?";
        String sql2 = "UPDATE SOLICITUD_SOCIOECONO SET I_ESTADOVERIFICADO = ? WHERE K_NUMEROSOLICITUD = ?";
        
        PreparedStatement ps = conn.prepareCall(sql);
        PreparedStatement ps2 = conn.prepareCall(sql2);
        
            ps.setString(1, aprobacion);
            ps.setString(2, comentario);
            ps.setInt(3, claveSolicitud);
                               
            ps.executeUpdate();
            ps.close();
            myConn.commit();
            
            //para la tabla socio_econo
            ps2.setString(1, aprobacion);
            ps2.setInt(2, claveSolicitud);
            System.out.println("hasta aca"); 
            ps2.executeUpdate();
            
            ps.close();
            myConn.commit();
            mensaje += "Solicitud modificada";
         } 
         catch(SQLException e) {
             mensaje += "Error al modificar convocatoria: "+ e;
             e.getStackTrace();
         } finally {
             myConn.liberarConexion();
         }
        return mensaje;
    }
    
    
    public PedirSolicitudes verTodasLasSolicitudes(){//devuelve un arraylist con todas las solicitudes con la ruta del documento
      ArrayList<Solicitud> solicitudess = new ArrayList();
      StringBuilder sql = new StringBuilder();
      
      sql.append("SELECT S.K_NUMEROSOLICITUD,S.Q_PUNTAJE,S.F_FECHASOLICITUD,S.N_ESTADOSOLICITUD,"
              + "S.N_EXPLICACIONESTADO,S.K_CODIGOSUPERVISOR,S.K_CODIGOESTUDIANTE,S.K_CODIGOCONVOCATORIA,SSC.N_RUTADOCUMENTO "
              + "FROM SOL S,SOLICITUD_SOCIOECONO_DOC SSC, SOLICITUD_SOCIOECONO SE " 
              + "WHERE S.K_NUMEROSOLICITUD = SE.k_numerosolicitud AND se.k_numerosolicitud = SSC.k_numerosolicitud ORDER BY 1 ASC ");
      ServiceLocator myConn = ServiceLocator.getInstance();
      mensaje += ServiceLocator.getMensaje();
      try {
         Connection conn = myConn.tomarConexion();
         PreparedStatement ps = conn.prepareCall(sql.toString());
         
          ResultSet rs = ps.executeQuery(); 
          while(rs.next()){
            Solicitud s = new Solicitud();
            s.setNumSolicitud(rs.getInt(1));
             
            s.setPuntaje(rs.getInt(2));
            s.setFecha(rs.getString(3));
            s.setEstado(rs.getString(4));          
            s.setExplicacion_estado(rs.getString(5));
            s.setNumSupervisor(rs.getInt(6));
            s.setCodEstudianteSt(rs.getString(7));//Se guarda en un String para mostrar un codigo extenso
            s.setNumConvocatoria(rs.getInt(8));
            s.setRutaDoc(rs.getString(9));
            solicitudess.add(s);
          }       
          mensaje += " Transacción realizada";  
          PedirSolicitudes solicitudes = new PedirSolicitudes(solicitudess, mensaje);
          return solicitudes;
      } catch (Exception e) {
          solicitudess = null;
         mensaje = "Error: "+e.getMessage();
         e.getStackTrace();
         PedirSolicitudes solicitudes = new PedirSolicitudes(solicitudess, mensaje);
         return solicitudes;
      }finally {
            myConn.liberarConexion();
        }
    }
            
    public Solicitud buscarSolicitud(int solicitud_id){// Devuelve un objeto de tipo solicitud dado su id
      Solicitud s = new Solicitud(); //Instancia el objeto para retornar los datos del empleado
      
      try{
         String strSQL = "SELECT solicitud_id, estado, periodo, semestre, tipo FROM solicitudes WHERE solicitud_id = ?";
         Connection conexion = ServiceLocator.getInstance().tomarConexion();
          PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
          prepStmt.setInt(1,solicitud_id);
          ResultSet rs = prepStmt.executeQuery();
        
            //TODO Leer el ResultSet, settear los atributos del empleado y retornarlo
      }
      catch(SQLException ex){
     
          //TODO Tratar la excepcion**/
      }
        return null;
      
    }
    
    
    public String eliminarSolicitud(int codigo){
         ServiceLocator myConn = ServiceLocator.getInstance();
        try {
            String sql = "DELETE FROM SOLICITUD_SOCIOECONO WHERE  k_numeroSolicitud = ?";
            String sql2 = "DELETE FROM SOLICITUD_SOCIOECONO_DOC WHERE k_numeroSolicitud = ?";
            String sql3 = "DELETE FROM SOLICITUD WHERE k_numeroSolicitud = ?";
        
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql);
            PreparedStatement ps2 = conn.prepareCall(sql2);
            PreparedStatement ps3 = conn.prepareCall(sql3);
            ps.setInt(1, codigo);
            
            
            ps.executeUpdate();
            ps.close();
            myConn.commit();
            
            ps2.setInt(1, codigo);
            ps2.executeUpdate();
            ps2.close();
            
            
            ps3.setInt(1, codigo);
            ps3.executeUpdate();
            ps3.close();
            myConn.commit();
            mensaje += "Solicitud Eliminada Satisfactoriamente...";
            
        } catch (Exception e) {
            mensaje += "Error al eliminar socioeconomico: "+ e;
        }
        
        return mensaje;
        
    }
    
     
}
