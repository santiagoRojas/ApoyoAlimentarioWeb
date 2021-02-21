/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;


import datos.*;
import java.text.ParseException;
import negocio.*;
import java.util.List;
import util.RHException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge_Andres
 */
public class test {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, RHException {
        
    //PRUEBA LOGIN
      /* 
        Login login = new Login();
        LoginDAO loginDAO = new LoginDAO();
        login.setUserBD("apoyo");
        login.setPasswordBD("123");
        loginDAO.setLogin(login);
        System.out.println("mensaje: "+loginDAO.loginBD());
    */    
     Controlador control = new Controlador();
     
     //PRUEBA CREAR ESTUDIANTES
     /*Estudiante e = new Estudiante();
     e.setNombres("Julian Stiven");
     e.setApellido("Higuera Hurtado");
     e.setCodigo(201520200);
     e.setEmail("julian@correo.com");
     e.setMatricula(10);
     e.setModalidad("Diurna");
     e.setPuntaje(100);
     e.setTelefono(5896541);
     e.setCodigoProyecto(101);
     System.out.println(control.crearEstudiante("CREADOR", "CREADOR", e));
     */
  
     
    // JOptionPane.showMessageDialog(null, control.logearse("CREADOR","CREADOR"));
    

   
    //Socioeconomico socio = new Socioeconomico();
    /*
    socio.setCodigo(25);
    socio.setNombreCondicion("Vive en casa del empleador");
    socio.setPuntaje(0);
  */
    Controlador con = new Controlador();
   // System.out.println(con.eliminarSolicitud(2));
    
   
   /*
   Proceso proc = new Proceso ();
   proc.setId(50);
   proc.setFechaInicio(new java.sql.Date(2020,05,17));
   proc.setFechaFin(new java.sql.Date(2018,04,14));
   proc.setNombre("Proceso");
   */
  
   Solicitud so = new Solicitud();
   //tabla solicitud
   so.setPuntaje(45);
   so.setFecha("20-10-2020");
   so.setEstado("PENDIENTE");
   so.setExplicacion_estado("lool");
   so.setNumSupervisor(3);
   so.setCodEstudianteSt("20192050052");
   so.setNumConvocatoria(25);
   //so.setFecha(new java.sql.Date(2015,8,23));
   
   //tabla solicitud_socioecono
   //se insertan por defecto por debajo
   //tabla socioecono_doc
   so.setCodigoDoc(7);
   so.setRutaDoc("c:Documentos");
   int keys[] = {21,22,25};
   
   Convocatoria conv = new Convocatoria();
   //conv.setCodigo(0);
   //conv.setFechaFin(new java.sql.Date(2015,10,23));
   //conv.setFechaInicio(new java.sql.Date(2015,8,23));
   //conv.setSemestre(3);
   //conv.setTipoProceso(3);
   //conv.setAnio(2015);
   //System.out.println(control.crearSocilicitud(so,keys));//ver estado solicitud, correcto 
   //System.out.println(control.actualizarConvocatoria("cr1030681971", "123", 500,new java.sql.Date(2015,8,23) , new java.sql.Date(2015,7,23)));
   System.out.println(control.verSolicitudes("cr1030681971", "123").getSolicitudes().get(0).getNumSolicitud());
    }
      
}