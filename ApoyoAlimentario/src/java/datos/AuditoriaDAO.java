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
import negocio.Auditoria;
import negocio.Solicitud;
import util.ServiceLocator;

/**
 *
 * @author Jorge_Andres
 */
public class AuditoriaDAO {
   String mensaje = null;
   
public String incluirAuditoria(Auditoria auditoria, String user, String contra){
    
    //ya esta loggeado como supervisor
      ServiceLocator myConn = ServiceLocator.getInstance();
      String strSQL2 = "INSERT INTO auditoria (k_codigoAuditoria, f_fecha, n_valor_anterior, n_valor_modificado) VALUES(?,?,?,?)";
      String strSQL = "SELECT ADMIN.AUDITA.NEXTVAL FROM DUAL";
    
       try {
        //insercion de una nueva convocatoria.
        Connection conexion = myConn.tomarConexion();
        PreparedStatement ps = conexion.prepareStatement(strSQL);
        ResultSet rs = ps.executeQuery();
        
  
        rs.next();
        int llave = Integer.parseInt(rs.getString(1));
        //para la tabla convocatoria
        PreparedStatement prepStmt = conexion.prepareStatement(strSQL2);
        prepStmt.setInt(1, llave); 
        prepStmt.setDate(2, auditoria.getF_fecha());
        prepStmt.setString(3, auditoria.getValor_ant());
        prepStmt.setString(4, auditoria.getValor_mod());
        
       
        prepStmt.close();
        myConn.commit();
       
        mensaje += "Convocatoria creada satisfactoriamente";
      } catch (SQLException e) {
           mensaje += "No se pudo crear la convocatoria: "+ e.getMessage();
           e.getCause();
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
        return mensaje;
      
}


      
  


}

