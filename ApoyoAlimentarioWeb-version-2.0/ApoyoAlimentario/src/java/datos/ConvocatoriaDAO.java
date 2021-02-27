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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import negocio.Controlador;
import negocio.Convocatoria;
import negocio.MensajeConvocatoria;
import util.ServiceLocator;

public class ConvocatoriaDAO {
    String mensaje = "";
   Controlador control = new Controlador();
    
 public String incluirConvocatoria(Convocatoria convocatoria){

      //ya esta loggeado como supervisor
      ServiceLocator myConn = ServiceLocator.getInstance();
      String strSQL = "INSERT INTO convocatoria (k_codigoConvocatoria, q_semestre, q_anio) VALUES(?,?,?)";
      String strsql3 = "INSERT INTO convocatoria_proceso (k_codigoConvocatoria , k_tipoProceso,f_fechaInicioProceso, f_fechaFinProceso) VALUES(?,?,?,?)";
      StringBuilder sql2 = new StringBuilder();
      sql2.append("SELECT ADMIN.CONVOCA.NEXTVAL FROM DUAL");
      try {
        //insercion de una nueva convocatoria.
        Connection conexion = myConn.tomarConexion();
        PreparedStatement ps2 = conexion.prepareStatement(sql2.toString());
        PreparedStatement ps = conexion.prepareStatement(strsql3);
        ResultSet rs = ps2.executeQuery();
        rs.next();

        int llave = Integer.parseInt(rs.getString(1));
        //para la tabla convocatoria
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1, llave); 
        prepStmt.setInt(2, convocatoria.getSemestre());
        prepStmt.setInt(3, convocatoria.getAnio());
        
        prepStmt.executeUpdate();
        prepStmt.close();
        myConn.commit();
        //para la tabla convocatoria_proceso
        ps.setInt(1, llave);
        ps.setInt(2, convocatoria.getTipoProceso());
        ps.setDate(3, convocatoria.getFechaInicio());
        ps.setDate(4, convocatoria.getFechaFin());
        ps.executeUpdate();
        ps.close();
        myConn.commit();
        
        mensaje = null;
      } catch (SQLException e) {
          System.out.println(e.getMessage());
           mensaje += "No se pudo crear la convocatoria: "+ e.getMessage();
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
        return mensaje;
      
    }
        
    public String modificarSemestreConvocatoria(int codigoCon, int semestre){
        
        //ya esta loggeado como supervisor
        ServiceLocator myConn = ServiceLocator.getInstance();
        try {
        String sql = "UPDATE CONVOCATORIA SET Q_SEMESTRE = ? WHERE k_codigoConvocatoria = ?";
        Connection conn = myConn.tomarConexion();
        PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, semestre);
            ps.setInt(2, codigoCon);
                                  
            ps.executeUpdate();
            ps.close();
            myConn.commit();
            mensaje = null ;
         } 
         catch(SQLException e) {
             mensaje += "Error al modificar convocatoria: "+ e;
         } finally {
             myConn.liberarConexion();
         }
        return mensaje;
    }
    
     public String modificarAnioConvocatoria(int codigoCon, int anio){
       
        //ya esta loggeado como supervisor
        
        ServiceLocator myConn = ServiceLocator.getInstance();
        try {
        String sql = "UPDATE CONVOCATORIA SET Q_ANIO = ? WHERE k_codigoConvocatoria = ?";
        
        Connection conn = myConn.tomarConexion();
        PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, anio);
            ps.setInt(2, codigoCon);
                                  
            ps.executeUpdate();
            ps.close();
            myConn.commit();
            mensaje = null;
         } 
         catch(SQLException e) {
             mensaje += "Error al modificar convocatoria: "+ e;
         } finally {
          myConn.liberarConexion();
         }
        return mensaje;
    }
     
    public String modificarFechasConvocatoria(int codigoCon, Date inicial, Date fin, int tipoproceso){
       
        //ya esta loggeado como supervisor
        
        ServiceLocator myConn = ServiceLocator.getInstance();
        try {
        String sql = "UPDATE CONVOCATORIA_PROCESO SET f_fechaInicioProceso = ?, f_fechaFinProceso = ?, k_tipoproceso = ? WHERE k_codigoConvocatoria = ?";
        
        Connection conn = myConn.tomarConexion();
        PreparedStatement ps = conn.prepareCall(sql);
            ps.setDate(1, inicial);
            ps.setDate(2, fin);
            ps.setInt(3, tipoproceso);
            ps.setInt(4, codigoCon);
                                  
            ps.executeUpdate();
            ps.close();
            myConn.commit();
            mensaje = null;
         } 
         catch(SQLException e) {
             mensaje += "Error al modificar convocatoria: "+ e;
         } finally {
          myConn.liberarConexion();
         }
        return mensaje;
    }
      
    public String eliminarConvocatoria(int codigoCon){
        ServiceLocator myConn = ServiceLocator.getInstance();
        try {
            eliminarBeneficiario(codigoCon);
            eliminarSolicitud(codigoCon);
            String sql3 = "DELETE FROM CONVOCATORIA WHERE k_codigoConvocatoria = ?";
            String sql = "DELETE FROM CONVOCATORIA_PROCESO WHERE k_codigoConvocatoria = ?";
            String sql2 = "DELETE FROM TIPOAPOYO_CONVOCATORIA WHERE k_codigoConvocatoria = ?";
            
        
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql);
            PreparedStatement ps2 = conn.prepareCall(sql2);
            PreparedStatement ps3 = conn.prepareCall(sql3);
            ps.setInt(1, codigoCon);
            
            
            ps.executeUpdate();
            ps.close();
            myConn.commit();
            
            ps2.setInt(1, codigoCon);
            ps2.executeUpdate();
            ps2.close();
            myConn.commit();
            
            ps3.setInt(1, codigoCon);
            ps3.executeUpdate();
            ps3.close();
            myConn.commit();
            
            
            
            mensaje = null;
            
        } catch (Exception e) {
            mensaje += "Error al eliminar convocatoria: "+ e;
        }finally {
          myConn.liberarConexion();
         }
        
        return mensaje;
        
    }
    
     public String eliminarBeneficiario(int codigoCon){
        ServiceLocator myConn = ServiceLocator.getInstance();
        try {
            String sql = "SELECT k_idBeneficiario FROM BENEFICIARIO WHERE k_codigoConvocatoria = "+codigoCon;
            String sql4 = "DELETE FROM BENEFICIARIO WHERE k_codigoConvocatoria = ?";
            String sql2 = "DELETE FROM ACTIVIDAD_BENEFICIARIO WHERE k_idBeneficiario = ?";
             String sql3 = "DELETE FROM TIQUETERAMES WHERE k_idBeneficiario = ?";
        
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql);
            PreparedStatement ps2 = conn.prepareCall(sql2);
            PreparedStatement ps3 = conn.prepareCall(sql3);
            PreparedStatement ps4 = conn.prepareCall(sql4);
            
            ResultSet rs1 = ps.executeQuery();
            
            while (rs1.next()) {
               
                int codigoBeneficiario = rs1.getInt(1);
                ps2.setInt(1, codigoBeneficiario);
                ps2.executeUpdate(); 
                ps3.setInt(1, codigoBeneficiario);
                ps3.executeUpdate();
            }
            
            ps2.close();
            ps3.close();
            ps.close();
            myConn.commit();
            
            ps4.setInt(1, codigoCon);
            ps4.executeUpdate();
            ps4.close();
            myConn.commit();

            mensaje = null;
            
        } catch (Exception e) {
            mensaje += "Error al eliminar convocatoria: "+ e;
        }finally {
          myConn.liberarConexion();
         }
        
        return mensaje;
        
    }
     
    public String eliminarSolicitud(int codigoCon){
        ServiceLocator myConn = ServiceLocator.getInstance();
        try {
            String sql = "SELECT k_numeroSolicitud FROM SOLICITUD WHERE k_codigoConvocatoria = "+codigoCon;
            String sql4 = "DELETE FROM SOLICITUD WHERE k_codigoConvocatoria = ?";
            String sql2 = "DELETE FROM SOLICITUD_SOCIOECONO_DOC WHERE k_numeroSolicitud = ?";
             String sql3 = "DELETE FROM SOLICITUD_SOCIOECONO WHERE k_numeroSolicitud = ?";
        
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql);
            PreparedStatement ps2 = conn.prepareCall(sql2);
            PreparedStatement ps3 = conn.prepareCall(sql3);
            PreparedStatement ps4 = conn.prepareCall(sql4);
            
            ResultSet rs1 = ps.executeQuery();
            
            while (rs1.next()) {
               
                int codigoSolicitud = rs1.getInt(1);
                ps2.setInt(1, codigoSolicitud);
                ps2.executeUpdate(); 
                ps3.setInt(1, codigoSolicitud);
                ps3.executeUpdate();
            }
            
            ps2.close();
            ps3.close();
            ps.close();
            myConn.commit();
            
            ps4.setInt(1, codigoCon);
            ps4.executeUpdate();
            ps4.close();
            myConn.commit();

            mensaje = null;
            
        } catch (Exception e) {
            mensaje += "Error al eliminar convocatoria: "+ e;
        }finally {
          myConn.liberarConexion();
         }
        
        return mensaje;
        
    }
    
    public MensajeConvocatoria mostrarTodasLasConvocatorias(){
        ServiceLocator myConn = ServiceLocator.getInstance();
        String sql = "SELECT * FROM CONVOCATORIA ORDER BY K_CODIGOCONVOCATORIA";
        String sql2 = "SELECT * FROM CONVOCATORIA_PROCESO ORDER BY K_CODIGOCONVOCATORIA";
        MensajeConvocatoria ms = new MensajeConvocatoria();
        
        ArrayList<Convocatoria> convocatorias = new ArrayList();
        try {
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql);
            PreparedStatement ps2 = conn.prepareCall(sql2);
            
            ResultSet rs1 = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            
            
            while (rs2.next()) {
                rs1.next();//se invoca al resultset del primer query para que funcione
                Convocatoria conv = new Convocatoria();
                conv.setCodigo(rs1.getInt(1));
                conv.setSemestre(rs1.getInt(2));
                conv.setAnio(rs1.getInt(3));
                conv.setTipoProceso(rs2.getInt(2));
                conv.setFechaInicio(rs2.getDate(3));//conv.setFechaInicio(rs2.getString(3));
                conv.setFechaFin(rs2.getDate(4));//conv.setFechaFin(rs2.getString(4));
                convocatorias.add(conv);
            }

            ms.setConvoca(convocatorias);
            ms.setMensaje(null);
        } catch (SQLException e) {
            mensaje += "Error al obtener las convocatorias... "+e.getMessage();
            ms.mensaje = mensaje;
            System.out.println(mensaje);
        }

        return ms;
        
    } 
    
    
     
}
