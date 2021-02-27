/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Controlador;
import negocio.Solicitud;

/**
 *
 * @author TOSHIBA
 */
@WebServlet(name = "GuardarSolicitudes", urlPatterns = {"/GuardarSolicitudes"})
public class GuardarSolicitudes extends HttpServlet {

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
        ArrayList<Solicitud> solicitudes = new ArrayList<>();
        String user = request.getParameter("usuario");
        String pass = request.getParameter("contraseña");
        String estado = request.getParameter("estado0");
        for(int i = 0; i < Integer.parseInt(request.getParameter("numSolicitudes"));i++){
            if(request.getParameter("estado"+i).equals("RECHAZADO") || request.getParameter("estado"+i).equals("APROBADO") ){
                
                Solicitud solicitud = new Solicitud();
                
                solicitud.setEstado(request.getParameter("estado"+i));
                solicitud.setNumSolicitud(Integer.parseInt(request.getParameter("idSolicitud"+i)));
                
                solicitudes.add(solicitud);
            }
            
        }
        
        Controlador contro = new Controlador();
        
        
        String error = "";
        if(error == ""){
            request.getSession().setAttribute("usuario", user);
            request.getSession().setAttribute("contraseña", pass);
            response.sendRedirect("Menu.jsp");
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
