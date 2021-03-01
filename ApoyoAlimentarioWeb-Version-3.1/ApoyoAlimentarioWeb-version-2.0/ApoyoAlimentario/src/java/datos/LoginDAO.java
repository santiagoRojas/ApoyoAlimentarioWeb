/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import util.ServiceLocator;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.Login;


/**
 *
 * @author Jorge_Andres
 */
public class LoginDAO {
    public Login login;
    private String mensaje="";
    private boolean conectado=false;
    
    public String LoginDAO(Login log) {
        login = log;
        return mensaje;
    }
    
    public String loginBD (){
        mensaje = ServiceLocator.login(login.getUser(),login.getPassword());//ejecuta el loggeo y devuelve el mensaje a la vez
        conectado = ServiceLocator.isConectado(); 
        return mensaje;
    }
    
    public String insertarLogin(){
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO REGION VALUES (?,?)");
        ServiceLocator myConn = ServiceLocator.getInstance();
            mensaje += "Transacción realizada";
        try {
            Connection conn = myConn.tomarConexion();
            PreparedStatement ps = conn.prepareCall(sql.toString());
            ps.setString(1, login.getUser());
            ps.setString(2, login.getPassword());         

            ps.executeUpdate();
            ps.close();
            myConn.commit();
            mensaje += "Transacción realizada";
        } catch (SQLException ex) {
            mensaje += ex.getMessage();
            ex.printStackTrace();
        }
        finally{
            myConn.liberarConexion();
        }
        return mensaje;
    
    
    }

    
    public Login getLogin() {
        return login;
    }

    public String setLogin(Login login) {
        this.login = login;
        return mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isConectado() {
        return conectado;
    }
    
}
