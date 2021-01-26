package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=iso-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    ");

String usuario = (String)session.getAttribute("usuario");
String contra = (String)session.getAttribute("contraseña");

      out.write("\n");
      out.write("    <!-- Required meta tags-->\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"Colorlib Templates\">\n");
      out.write("    <meta name=\"author\" content=\"Colorlib\">\n");
      out.write("    <meta name=\"keywords\" content=\"Colorlib Templates\">\n");
      out.write("\n");
      out.write("    <!-- Title Page-->\n");
      out.write("    <title>Registrarse</title>\n");
      out.write("\n");
      out.write("    <!-- Icons font CSS-->\n");
      out.write("    <link href=\"vendor/mdi-font/css/material-design-iconic-font.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/font-awesome-4.7/css/font-awesome.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <!-- Font special for pages-->\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("    <!-- Vendor CSS-->\n");
      out.write("    <link href=\"vendor/select2/select2.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/datepicker/daterangepicker.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("\n");
      out.write("    <!-- Main CSS-->\n");
      out.write("    <link href=\"css/Registermain.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("   \n");
      out.write("    <div class=\"page-wrapper bg-gra-03 p-t-45 p-b-50\">\n");
      out.write("        <div class=\"wrapper wrapper--w790\">\n");
      out.write("            <div class=\"card card-5\">\n");
      out.write("                <div class=\"card-heading\">\n");
      out.write("                    <h2 class=\"title\">Registrarse</h2>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form method=\"POST\" action=\"RegistroServlet\">\n");
      out.write("                        <div class=\"form-row m-b-55\">\n");
      out.write("                             <h1>");
      out.print(usuario+contra);
      out.write("</h1>\n");
      out.write("                            <div class=\"name\">Nombre</div>\n");
      out.write("                            <div class=\"value\">\n");
      out.write("                                <div class=\"row row-space\">\n");
      out.write("                                    <div class=\"col-2\">\n");
      out.write("                                        <div class=\"input-group-desc\">\n");
      out.write("                                            <input class=\"input--style-5\" type=\"text\" name=\"first_name\" id=\"first_name\">\n");
      out.write("                                            <label class=\"label--desc\">Nombre</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-2\">\n");
      out.write("                                        <div class=\"input-group-desc\">\n");
      out.write("                                            <input class=\"input--style-5\" type=\"text\" name=\"last_name\" id=\"last_name\">\n");
      out.write("                                            <label class=\"label--desc\">Apellido</label>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"name\">CÃ³digo</div>\n");
      out.write("                            <div class=\"value\">\n");
      out.write("                                <div class=\"input-group\">\n");
      out.write("                                    <input class=\"input--style-5\" type=\"text\" name=\"codigo\" id=\"codigo\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"name\">ContraseÃ±a</div>\n");
      out.write("                            <div class=\"value\">\n");
      out.write("                                <div class=\"input-group\">\n");
      out.write("                                    <input class=\"input--style-5\" type=\"password\" name=\"password\" id=\"password\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"name\">Email</div>\n");
      out.write("                            <div class=\"value\">\n");
      out.write("                                <div class=\"input-group\">\n");
      out.write("                                    <input class=\"input--style-5\" type=\"email\" name=\"email\" id=\"email\">\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row m-b-55\">\n");
      out.write("                          <div class=\"name\">TelÃ©fono</div>\n");
      out.write("                          <div class=\"value\">\n");
      out.write("                              <div class=\"input-group\">\n");
      out.write("                                  <input class=\"input--style-5\" type=\"number\" name=\"phone\" id=\"phone\">\n");
      out.write("                              </div>\n");
      out.write("                          </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row p-t-20\">\n");
      out.write("                            <label class=\"label label--block\">Modalidad de estudio</label>\n");
      out.write("                            <div class=\"p-t-15\">\n");
      out.write("                                <label class=\"radio-container m-r-55\">Pregrado\n");
      out.write("                                    <input type=\"radio\" checked=\"checked\" name=\"modalidad\" value=\"Pregrado\">\n");
      out.write("                                    <span class=\"checkmark\"></span>\n");
      out.write("                                </label>\n");
      out.write("                                <label class=\"radio-container\">Postgrado\n");
      out.write("                                    <input type=\"radio\" name=\"modalidad\" value=\"Postgrado\">\n");
      out.write("                                    <span class=\"checkmark\"></span>\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row m-b-55\">\n");
      out.write("                          <div class=\"name\">Semestre</div>\n");
      out.write("                          <div class=\"value\">\n");
      out.write("                              <div class=\"input-group\">\n");
      out.write("                                  <input class=\"input--style-5\" type=\"text\" name=\"semestre\" id=\"semestre\">\n");
      out.write("                              </div>\n");
      out.write("                          </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row m-b-55\">\n");
      out.write("                          <div class=\"name\">Proyecto curricular</div>\n");
      out.write("                          <div class=\"value\">\n");
      out.write("                              <div class=\"input-group\">\n");
      out.write("                                  <input class=\"input--style-5\" type=\"text\" name=\"pcurricular\" id=\"pcurricular\">\n");
      out.write("                              </div>\n");
      out.write("                          </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-row\">\n");
      out.write("                            <div class=\"name\">Facultad</div>\n");
      out.write("                            <div class=\"value\">\n");
      out.write("                                <div class=\"input-group\">\n");
      out.write("                                    <div class=\"rs-select2 js-select-simple select--no-search\">\n");
      out.write("                                        <select name=\"facultad\">\n");
      out.write("                                            <option disabled=\"disabled\" selected=\"selected\">Elegir opciÃ³n</option>\n");
      out.write("                                            <option>Macarena A</option>\n");
      out.write("                                            <option>Macarena B</option>\n");
      out.write("                                            <option>Facultad de IngenierÃ­a</option>\n");
      out.write("                                            <option>Vivero</option>\n");
      out.write("                                            <option>ASAB</option>\n");
      out.write("                                            <option>TecnolÃ³gica</option>\n");
      out.write("                                        </select>\n");
      out.write("                                        <div class=\"select-dropdown\"></div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"registrar\">\n");
      out.write("                            <button class=\"btn btn--radius-2 btn--red\" type=\"submit\">Registrarse</button>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"text-center p-t-136\">\n");
      out.write("                            <a class=\"txt2\" href=\"Login.html\">\n");
      out.write("                            Regresar a login\n");
      out.write("                            <i class=\"fa fa-long-arrow-right m-l-5\" aria-hidden=\"true\"></i>\n");
      out.write("                            </a>\n");
      out.write("              \t\t</div>\n");
      out.write("                    </form>\n");
      out.write("                    <div id=\"back1\">\n");
      out.write("                        <button class=\"btn btn--radius-2 btn--red\" onclick=\"window.location.href='index.html'\" >Regresar</button>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Jquery JS-->\n");
      out.write("    <script src=\"vendor/jquery/jquery.min.js\"></script>\n");
      out.write("    <!-- Vendor JS-->\n");
      out.write("    <script src=\"vendor/select2/select2.min.js\"></script>\n");
      out.write("    <script src=\"vendor/datepicker/moment.min.js\"></script>\n");
      out.write("    <script src=\"vendor/datepicker/daterangepicker.js\"></script>\n");
      out.write("\n");
      out.write("    <!-- Main JS-->\n");
      out.write("    <script src=\"js/Register.js\"></script>\n");
      out.write("\n");
      out.write("</body><!-- This templates was made by Colorlib (https://colorlib.com) -->\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("<!-- end document-->\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
