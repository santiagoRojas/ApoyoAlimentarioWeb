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
    

   /*
    Socioeconomico socio = new Socioeconomico();
    socio.setCodigo(52154);
    socio.setAutoSostiene("SI");
    socio.setCartaIndependiente("direccion en disco");
    socio.setCartaLaboral("direccion en disco");
    socio.setCartaRector("direccion en disco");
    socio.setCertificadoDesplazamiento("direccion en disco");
    socio.setCertificadoDiscapacidad("direccion en disco");
    socio.setCertificadoIngresosReten("direccion en disco");
    socio.setCondicionEsp("NO");
    socio.setDiscapacidad("NO");
    socio.setEstratificacion("Direccion");
    socio.setExamenMedico("Direccion en disco");
    socio.setFactura("Direccion en disco");
    socio.setFormulario("direccion en disco");
    socio.setIngresos(20);
    socio.setNucleo("NO");
    socio.setPatologia("NO");
    socio.setPersonasCargo("NO");
    socio.setReciboPago("direccion recibo");
    socio.setRegistroCivil("direccion registro");
    socio.setResideZona("NO");
    socio.setSostieneHogar("NO");
    socio.setValormatricula(10500000);
    socio.setViveConEmpleador("NO");
    */
   
   /*
   Proceso proc = new Proceso ();
   proc.setId(50);
   proc.setFechaInicio(new java.sql.Date(2020,05,17));
   proc.setFechaFin(new java.sql.Date(2018,04,14));
   proc.setNombre("Proceso");
   */
  /*
   Solicitud so = new Solicitud();
   so.setNum(15617);
   so.setAnio(2020);
   so.setCodEstudiante(201520200);
   so.setEstado("PENDIENTE");
   so.setFecha(new java.sql.Date(2015,8,23));
   so.setNumSocioEconomico(52154);
   so.setNumSupervisor(17);//crear supervisor
   so.setPuntaje(215);
   so.setSemestre(1);
   System.out.println(control.crearSocilicitud("CREADOR", "CREADOR",so));//ver estado solicitud, correcto 
   */

   //System.out.println(control.verEstadoSocilitud("CREADOR", "CREADOR",15616));//ver estado solicitud, correcto 
  // ArrayList<Solicitud> s = new ArrayList();
  //System.out.println(control.verSolicitudes("CREADOR", "CREADOR").get(0).getEstado());//Devuelve un arraylist con todas las solicitudes, coorecto
 /*
    ArrayList<Solicitud> soli = new ArrayList();
    soli = control.verSolicitudes("CREADOR", "CREADOR");
    System.out.println(control.validarSolicitudes(soli,"CREADOR", "CREADOR"));//Valida todas las solicitudes, correcto.
    */
    }
      
}