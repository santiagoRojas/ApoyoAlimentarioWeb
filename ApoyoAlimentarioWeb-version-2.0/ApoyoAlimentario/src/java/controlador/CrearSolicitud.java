/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Mensajes;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Controlador;
import negocio.Socioeconomico;
import negocio.Solicitud;

/**
 *
 * @author TOSHIBA
 */
@WebServlet(name = "CrearSolicitud", urlPatterns = {"/CrearSolicitud"})
public class CrearSolicitud extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Socioeconomico eco = new Socioeconomico();
        String user = request.getParameter("usuario");
	String pass = request.getParameter("contraseña");
        String codigo = request.getParameter("codigo");
        int convocatoria = Integer.parseInt(request.getParameter("numconvocatoria"));
        int sostienemismo = Integer.parseInt(request.getParameter("sostienemismo"));
        /*String FormularioSolicitudApoyoAlimentario = (request.getParameter("lformSolicitudapoyo"));
        String CartaDirectorBienestar = request.getParameter("lcartadirector");
        String CertificadoEstratificacion = request.getParameter("lcertificadoestratificacion");
        String ReciboPublico = request.getParameter("lrecibopublico");
        String ReciboPagoUniversidad = request.getParameter("lrecibouniversidad");
        String CertificadoDesplazamientoForzoso = request.getParameter("ldesplazamientoforzoso");
        String CertificadoCivilNacimientoHijos = request.getParameter("lnacimientohijos");
        String CertificadoDiscapacidadMedica = (request.getParameter("ldiscapacidadmedica"));
        String CertificadoIngresos = request.getParameter("lingresos");
        String ExamenDiagnosticoMedico = request.getParameter("lediagnosticomedico");*/
        int condicion = Integer.parseInt(request.getParameter("condicion"));
        int discapacidad = Integer.parseInt(request.getParameter("discapacidad"));
        int ifamiliar = Integer.parseInt(request.getParameter("IFamiliar"));
        int vnucleofamiliar = Integer.parseInt(request.getParameter("vfnucleofamiliar"));
        int problemaalimentacion = Integer.parseInt(request.getParameter("problemaalimentacion"));
        int personasAcargo = Integer.parseInt(request.getParameter("personasAcargo"));
        int reside = Integer.parseInt(request.getParameter("reside"));
        int sostienehogar = Integer.parseInt(request.getParameter("sostienehogar"));
        int vmatricula = Integer.parseInt(request.getParameter("Vmatricula"));
        int casaempleador = Integer.parseInt(request.getParameter("casaempleador"));
      
        Solicitud solicitud = new Solicitud(); 
        String error = null;
        Controlador contro = new Controlador();
        java.util.Date date = new java.util.Date();
        
        solicitud.setEstado("PENDIENTE");
        solicitud.setPuntaje(0);
        solicitud.setExplicacion_estado("");
        solicitud.setCodEstudianteSt(codigo);
        solicitud.setFecha(date);
        solicitud.setNumConvocatoria(convocatoria);
        
        ArrayList <Integer> llaves = new ArrayList<Integer>();
        
        if( sostienemismo != 0 ){
            llaves.add(sostienemismo);
        }
        if( condicion != 0 ){
            llaves.add(condicion);
        }
        if( discapacidad != 0 ){
            llaves.add(discapacidad);
        }
        if( ifamiliar != 0 ){
            llaves.add(ifamiliar);
        }
        if( vnucleofamiliar != 0 ){
            llaves.add(vnucleofamiliar);
        }
        if( problemaalimentacion != 0 ){
            llaves.add(problemaalimentacion);
        }
        if( personasAcargo != 0 ){
            llaves.add(personasAcargo);
        }
        if( reside != 0 ){
            llaves.add(reside);
        }
        if( sostienehogar != 0 ){
            llaves.add(sostienehogar);
        }
        if( vmatricula != 0 ){
            llaves.add(vmatricula);
        }
        if( casaempleador != 0 ){
            llaves.add(casaempleador);
        }
            
            error = contro.crearSocilicitud(user, pass, solicitud, llaves);
            
            if(error == null){
                error = "Transaccion exitosa";
                request.getSession().setAttribute("error", error);
                request.getSession().setAttribute("usuario", user);
                request.getSession().setAttribute("contraseña", pass);
                response.sendRedirect("Menu.jsp");
            }else{
                request.getSession().setAttribute("error", error);
                request.getSession().setAttribute("usuario", user);
                request.getSession().setAttribute("contraseña", pass);
                response.sendRedirect("Menu.jsp");
            }
            
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
