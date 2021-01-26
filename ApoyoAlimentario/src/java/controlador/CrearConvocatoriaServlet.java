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
        Convocatoria convocatoria = new Convocatoria();
        convocatoria.setAnio(Integer.parseInt(request.getParameter("año")));
        try {
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        convocatoria.setFechaFin((java.sql.Date) fechaHora.parse(request.getParameter("fechaFin")));
        convocatoria.setFechaInicio((java.sql.Date) fechaHora.parse(request.getParameter("fechaInicio")));
        } catch (ParseException e) {
                System.out.println("Error: " + e.getMessage());
        }
        convocatoria.setSemestre(Integer.parseInt(request.getParameter("semestre")));
        convocatoria.setTipoProceso(Integer.parseInt(request.getParameter("tipoProceso")));
        
        Controlador control = new Controlador();
        String error = control.crearConvocatoria(user, pass, convocatoria);
        if(error == null){
            error= "se ha creado la convocatoria con exito";
            request.getSession().setAttribute("usuario", user);
            request.getSession().setAttribute("contraseña", pass);
            request.getSession().setAttribute("error", error);
            response.sendRedirect("Convocatorias.jsp");
        }else{
            request.getSession().setAttribute("error", error);
            request.getSession().setAttribute("usuario", user);
            request.getSession().setAttribute("contraseña", pass);
            response.sendRedirect("Convocatorias.jsp");
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
