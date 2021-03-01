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
import negocio.Supervisor;
import negocio.Controlador;
import util.ServiceLocator;
/**
 *
 * @author Jorge_Andres
 */
public class SupervisorDAO {
    String mensaje = "";
    Controlador control = new Controlador();
    
    public String incluirSupervisor(Supervisor superv, String usuario, String contrasenia){
        
        ServiceLocator myConn = ServiceLocator.getInstance();
        String strSQL = "INSERT INTO SUPERVISOR (k_codigoSupervisor, k_identificacionSupervisor, n_tipoDeIdentificacionSup, n_nombreSupervisor,n_apellidoSupervisor ) VALUES(?,?,?,?,?)";
      try {
        //insercion de un nuevo beneficiario.

        Connection conexion = myConn.tomarConexion();
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL);
        prepStmt.setInt(1, superv.getCodigo()); 
        prepStmt.setInt(2, superv.getIdentificacion());
        prepStmt.setString(3, superv.getTipoId());
        prepStmt.setString(4, superv.getNombre());
        prepStmt.setString(5, superv.getApellido());
        
        prepStmt.executeUpdate();
        prepStmt.close();
        myConn.commit();
        
        mensaje +="Supervisor agregado correctamente... ";
        crearUsuarioSupervisor(usuario, contrasenia);
        
      } catch (SQLException e) {
          int code = e.getErrorCode();
          if(code == 1)
              System.out.println("No se puede crear el usuario: "+usuario+", el código o ID Ya existe...");
           mensaje+= "\n"+e.getMessage();
      }  finally {
        myConn.liberarConexion();
      }
        return mensaje;
      
    }
    
    public String crearUsuarioSupervisor(String usuario, String contrasenia){
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
        otorgarRolDeSupervisor(usuario, myConn);//llama el otro metodo de otorgar rol
 
        return mensaje;
    }
      
     public String otorgarRolDeSupervisor(String usuario, ServiceLocator conexion){
        StringBuilder sql = new StringBuilder();
        sql.append("GRANT R_SUPERVISOR TO "+usuario);
        
        try {
               Connection conn = conexion.tomarConexion();
                PreparedStatement ps = conn.prepareStatement(sql.toString());
                ps.executeQuery();
                ps.close();
                conexion.commit();
     
        } catch (SQLException ex) {
           System.out.println("No se pudo crear el Rol de Supervisor...");
           mensaje +=ex;
        }finally{
          ServiceLocator.getInstance().liberarConexion();
      }

      return mensaje;
        
    }
    
    
    
}
