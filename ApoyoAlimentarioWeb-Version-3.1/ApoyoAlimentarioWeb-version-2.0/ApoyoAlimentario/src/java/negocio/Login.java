/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Jorge_Andres
 */
public class Login {
    private String user="";
    private String password="";
    private int   codigo;
    private String consultaUser;
    private String consultaPass;

    public Login() {
    }
    
    public Login(int codigo, String consultaUser ) {
        this.codigo = codigo;
        this.consultaUser = consultaUser;
      
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int tipo_doc) {
        this.codigo = codigo;
    }

    public String getConsultaUser() {
        return consultaUser;
    }

    public void setConsultaUser(String consultaUser) {
        this.consultaUser = consultaUser;
    }

    public String getConsultaPass() {
        return consultaPass;
    }

    public void setConsultaPass(String consultaPass) {
        this.consultaPass = consultaPass;
    }

    public String getUser() {
        return user;
    }

    public void setUserBD(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswordBD(String password) {
        this.password = password;
    }
}
