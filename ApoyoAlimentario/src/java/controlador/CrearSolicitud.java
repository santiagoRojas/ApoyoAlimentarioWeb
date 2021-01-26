/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import negocio.Mensajes;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
        eco.setAutoSostiene(request.getParameter("sostienemismo"));
        eco.setCartaIndependiente(request.getParameter("link"));
        eco.setCartaLaboral(request.getParameter("link"));
        eco.setCartaRector(request.getParameter("link"));
        eco.setCertificadoDesplazamiento(request.getParameter("link"));
        eco.setCondicionEsp(request.getParameter("condicion"));
        eco.setDiscapacidad(request.getParameter("discapacidad"));
        eco.setEstratificacion(request.getParameter("link"));
        eco.setExamenMedico(request.getParameter("link"));
        eco.setFactura(request.getParameter("link"));
        eco.setFormulario(request.getParameter("link"));
        eco.setIngresos(Integer.parseInt(request.getParameter("IFamiliar")));
        eco.setNucleo(request.getParameter("vfnucleofamiliar"));
        eco.setPatologia(request.getParameter("problemaalimentacion"));
        eco.setPersonasCargo(request.getParameter("personasAcargo"));
        eco.setReciboPago(request.getParameter("link"));
        eco.setRegistroCivil(request.getParameter("link"));
        eco.setResideZona(request.getParameter("reside"));
        eco.setSostieneHogar(request.getParameter("sostienehogar"));
        eco.setValormatricula(Integer.parseInt(request.getParameter("Vmatricula")));
        eco.setViveConEmpleador(request.getParameter("casaempleador"));
        eco.setCertificadoDiscapacidad(request.getParameter("link"));
        eco.setCertificadoIngresosReten(request.getParameter("link"));
        
        String error = null;
        Controlador contro = new Controlador();
        Mensajes msj = contro.crearInfoSocioeconomi(user,pass,eco);
        
        if(msj.getMensaje() == null){
            Solicitud s = new Solicitud();
            s.setSemestre(Integer.parseInt(request.getParameter("semestre")));
            int puntaje = 0;
            if (eco.getIngresos() <= 1 ){
                puntaje += 30;
            }else if( (1 < eco.getIngresos()) && (eco.getIngresos() <= 2 )){
                puntaje += 20;
            }else if( (2 < eco.getIngresos()) && (eco.getIngresos() <= 3 )){
                puntaje += 10;
            }else if( (3 < eco.getIngresos()) && (eco.getIngresos() <= 4 )){
                puntaje += 5;
            }
            
            if(eco.getAutoSostiene().equals("Si")){
                puntaje += 5;
            }
            if(eco.getSostieneHogar().equals("Si")){
                puntaje += 5;
            }
            if(eco.getNucleo().equals("Si")){
                puntaje += 4;
            }
            if(eco.getPersonasCargo().equals("Si")){
                puntaje += 6;
            }
            if(eco.getViveConEmpleador().equals("Si")){
                puntaje += 5;
            }
            if(eco.getCondicionEsp().equals("Si")){
                puntaje += 5;
            }
            if(eco.getResideZona().equals("Si")){
                puntaje += 10;
            }
            if(eco.getDiscapacidad().equals("Si")){
                puntaje += 5;
            }
            if(eco.getPatologia().equals("Si")){
                puntaje += 5;
            }
            if (eco.getValormatricula()<= 100000 ){
                puntaje += 20;
            }else if( (100000 < eco.getValormatricula()) && (eco.getValormatricula() <= 300000 )){
                puntaje += 16;
            }else if( (300000 < eco.getValormatricula()) && (eco.getValormatricula() <= 500000 )){
                puntaje += 12;
            }else if( (500000 < eco.getValormatricula()) && (eco.getValormatricula() <= 700000 )){
                puntaje += 8;
            }else if( (700000 < eco.getValormatricula()) && (eco.getValormatricula() <= 900000 )){
                puntaje += 4;
            }
            

            java.util.Date date = new java.util.Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("dd/MM/YY");
        String a =dt1.format(date); 
            Date fecha = new Date();
            s.setAnio(fecha.getYear()+1900);
            s.setCodEstudiante(Long.parseLong(user.substring(2)));
            s.setEstado("PENDIENTE");
            s.setFechaActual(a);
            s.setNumSocioEconomico(msj.getPrimaria());
            s.setNumSupervisor(1);
            s.setPuntaje(puntaje);
            s.setSemestre(Integer.parseInt(request.getParameter("semestre")));
            
            error = contro.crearSocilicitud(user, pass, s);
            
            if(error == ""){
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
        else{
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
