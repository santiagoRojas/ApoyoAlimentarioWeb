package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.Proceso;
import util.ServiceLocator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jorge_Andres
 */
public class ProcesoDAO {
    String mensaje = "";
    
    public String incluirProceso(Proceso proc){
      try {
        //inserción de una nuevo proceso.
        
        String strSQL = "INSERT INTO proceso(k_tipoProceso, f_fechaInicioProceso, f_fechaFinProceso, n_nombreProceso) VALUES(?,?,?,?)";
        Connection conexion = ServiceLocator.getInstance().tomarConexion();
        PreparedStatement ps = conexion.prepareStatement(strSQL);
        
        ps.setInt(1, proc.getId()); 
        ps.setDate(2, proc.getFechaInicio()); 
        ps.setDate(3, proc.getFechaFin());
        ps.setString(4, proc.getNombre());
    
     
        ps.executeUpdate();
        ps.close();
        ServiceLocator.getInstance().commit();
        mensaje += "Proceso creado exitosamente! ";
      } catch (SQLException e) {
           mensaje += "No se pudo incluir proceso: "+e.getMessage();
           e.printStackTrace();
      }  finally {
         ServiceLocator.getInstance().liberarConexion();
      }
         return mensaje;
      
    }
    
}
