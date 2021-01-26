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
    
     public SolicitudDAO(){
       
    }
     
  /**
     * Incluye una nueva fila en la tabla Solicitudes
     * @throws RHException
     */
  public String incluirSolicitud(Solicitud solicitud){
        StringBuilder sql = new StringBuilder();
       StringBuilder sql2 = new StringBuilder();
       sql.append("INSERT INTO SOLICITUD (k_numeroSolicitud,q_puntaje,q_semestre,q_anio,f_fechaSolicitud,n_estadoSolicitud,k_codigoSupervisor,k_codigoSocioEconomico,k_codigoEstudiante) VALUES(?,?,?,?,?,?,?,?,?)");
       sql2.append("SELECT cr1030681971.solicito.NEXTVAL FROM DUAL");
       
       ServiceLocator myConn = ServiceLocator.getInstance();

       try {//inserta los valores de solicitud
        Connection conexion = myConn.tomarConexion();
        PreparedStatement ps = conexion.prepareStatement(sql.toString());
        PreparedStatement ps2 = conexion.prepareStatement(sql2.toString());
        
        
        ResultSet rs = ps2.executeQuery();
        rs.next();

        
        int llave = Integer.parseInt(rs.getString(1));

                ps.setInt(1,llave); 
                ps.setInt(2, solicitud.getPuntaje()); 
                ps.setInt(3, solicitud.getSemestre());
                ps.setInt(4, solicitud.getAnio());
                ps.setString(5,solicitud.getFechaActual());
                ps.setString(6, solicitud.getEstado());
                ps.setInt(7, solicitud.getNumSupervisor());
                ps.setInt(8, solicitud.getNumSocioEconomico());
                ps.setLong(9, solicitud.getCodEstudiante());
                ps.executeUpdate();
                ps.close();
                myConn.commit();
            } catch (SQLException ex) {
                mensaje += ex.getMessage();
                ex.getMessage();
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
    public void modificarSolicitud(){
       /** TODO Implementar el método**/
    }

    public PedirSolicitudes verTodasLasSolicitudes(){//devuelve un arraylist con todas las solicitudes
      ArrayList<Solicitud> solicitudess = new ArrayList();
      StringBuilder sql = new StringBuilder();
      
      sql.append("SELECT * FROM SOLICITUD WHERE n_estadoSolicitud = 'PENDIENTE'");
      ServiceLocator myConn = ServiceLocator.getInstance();
      mensaje += ServiceLocator.getMensaje();
      try {
         Connection conn = myConn.tomarConexion();
         PreparedStatement ps = conn.prepareCall(sql.toString());
         
         ResultSet rs = ps.executeQuery(); 
          while(rs.next()){
            Solicitud s = new Solicitud();
            s.setNum(rs.getInt(1));
            s.setPuntaje(rs.getInt(2));
            s.setSemestre(rs.getInt(3));
            s.setAnio(rs.getInt(4));
            s.setFecha(rs.getDate(5));
            s.setEstado(rs.getString(6));          
            s.setNumSupervisor(rs.getInt(7));
            s.setNumSocioEconomico(rs.getInt(8));
            s.setCodEstudiante(rs.getLong(9));
            solicitudess.add(s);
          }
          
          
          
          mensaje += "Transacción realizada";
          
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
    
    public String validarTodasLasSolicitudes(Solicitud solicitud){//cactualiza el estado de PENDIENTE A APROBADO DE TODAS LAS SOLICITUDES
        
        StringBuilder sql = new StringBuilder();
            sql.append("UPDATE SOLICITUD SET n_estadoSolicitud = '"+solicitud.getEstado()+"' WHERE k_numeroSolicitud = "+solicitud.getNum());
        
        ServiceLocator myConn = ServiceLocator.getInstance();
        try {
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql.toString());
            ps.executeUpdate();
            ps.close();
            myConn.commit();

        } catch (SQLException ex) {
            mensaje += "No se pudo cambiar el estadode la solicitud "+solicitud.getNum()+" por: "+ex.getMessage();
            ex.printStackTrace();
        }
        finally{
            myConn.liberarConexion();
        }    
        
        return mensaje;
        
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
    
     
}
