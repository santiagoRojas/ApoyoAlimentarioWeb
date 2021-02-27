 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Controlador;
import negocio.Convocatoria;

/**
 *
 * @author TOSHIBA
 */
@WebServlet(name = "CrearConvocatoriaServlet", urlPatterns = {"/CrearConvocatoriaServlet"})
public class CrearConvocatoriaServlet extends HttpServlet {

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
        String user = request.getParameter("usuario");
	String pass = request.getParameter("contraseña");
        //String user = "admin";
	//String pass = "admin";
        System.out.println("usuario"+user);
        System.out.println("pass"+pass);
        Convocatoria convocatoria = new Convocatoria();
        convocatoria.setAnio(Integer.parseInt(request.getParameter("anio")));
        try {
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("fecha " +request.getParameter("fechaFin"));
        
        String[] startsplitter= String.valueOf(request.getParameter("fechaInicio")).split("-");
        String[] endsplitter= String.valueOf(request.getParameter("fechaFin")).split("-");
 
        java.sql.Date startdate = new java.sql.Date(0);
        java.sql.Date enddate = new java.sql.Date(0);
        
        startdate.setYear(Integer.parseInt(startsplitter[0])-1900);
        startdate.setMonth(Integer.parseInt(startsplitter[1])-1);
        startdate.setDate(Integer.parseInt(startsplitter[2]));
        
        enddate.setYear(Integer.parseInt(endsplitter[0])-1900);
        enddate.setMonth(Integer.parseInt(endsplitter[1])-1);
        enddate.setDate(Integer.parseInt(endsplitter[2]));
        
        System.out.println("fecha inicio " +startdate);
         System.out.println("fecha fin " +enddate);
       
        convocatoria.setFechaInicio(startdate);
        convocatoria.setFechaFin(enddate);
        //convocatoria.setFechaFin((java.sql.Date) fechaHora.parse(request.getParameter("fechaFin")));
        //convocatoria.setFechaInicio((java.sql.Date) fechaHora.parse(request.getParameter("fechaInicio")));
        } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
        }
        convocatoria.setSemestre(Integer.parseInt(request.getParameter("semestre")));
        convocatoria.setTipoProceso(Integer.parseInt(request.getParameter("tipoProceso")));
        
        Controlador control = new Controlador();
        String error = control.crearConvocatoria(user, pass, convocatoria);
        if(error == null){
            ArrayList <Convocatoria> convocatorias = new ArrayList<Convocatoria> ();
            convocatorias.add(convocatoria);
            error= "se ha creado la convocatoria con exito";
            request.getSession().setAttribute("usuario", user);
            request.getSession().setAttribute("contraseña", pass);
            request.getSession().setAttribute("error", error);
            request.getSession().setAttribute("convocatorias", convocatorias);
            response.sendRedirect("VerConvocatoria.jsp");
        }else{
            request.getSession().setAttribute("error", error);
            request.getSession().setAttribute("usuario", user);
            request.getSession().setAttribute("contraseña", pass);
            response.sendRedirect("CrearConvocatoria.jsp");
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
