/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.Controlador;
import negocio.Estudiante;

/**
 *
 * @author TOSHIBA
 */
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

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
        String nombre = request.getParameter("first_name");
	String apellido = request.getParameter("last_name");
        int codigo =  Integer.parseInt(request.getParameter("codigo"));
        
        
        /*estas son las variables nuevas que hay que incluir para el fornt nos pase
        int identificacion =  Integer.parseInt(request.getParameter("identificacion"));
        String tipoIdentificacion = request.getParameter("tipoIdentificacion");
        */
        //borrar esto cuando ya este en  el front
        int identificacion = 1;
        String tipoIdentificacion ="2";
        
        
	String pass = request.getParameter("password");
        String email = request.getParameter("email");
	int telefono = Integer.parseInt(request.getParameter("phone"));
	int matricula = Integer.parseInt(request.getParameter("semestre"));
        int proyectoCurri = Integer.parseInt(request.getParameter("pcurricular"));
        String modalidadEstudio = request.getParameter("modalidad");
	String facultad = request.getParameter("facultad");
        Controlador con = new Controlador();
        String error1 = con.verificarCodigoExiste(codigo);
        
        if(error1 == null){
            Estudiante estudiante = new Estudiante(codigo,identificacion,tipoIdentificacion,nombre,apellido,modalidadEstudio,matricula,telefono,email, (int) (Math.random()*10+1),proyectoCurri);
            String user = ""+nombre.toLowerCase().charAt(0)+apellido.toLowerCase().charAt(0)+codigo;
            
            String error2 = con.crearEstudiante(estudiante,user, pass);

            if(error2 == null){
                response.sendRedirect("Login.jsp");
            }
            else{
                request.getSession().setAttribute("errorr", error2);
                response.sendRedirect("Login.jsp");
            }
        }
        else{
            request.getSession().setAttribute("errorr", error1);
            response.sendRedirect("Login.jsp");
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
