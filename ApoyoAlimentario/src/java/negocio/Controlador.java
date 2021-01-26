/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import datos.BeneficiarioDAO;
import datos.ConvocatoriaDAO;
import datos.EstudianteDAO;
import datos.InfoSocioEconomicaDAO;
import datos.SolicitudDAO;
import datos.LoginDAO;
import datos.ProcesoDAO;
import datos.SupervisorDAO;
import java.sql.Date;
import java.util.ArrayList;
/**
 *
 * @author Jorge_Andres
 */
public class Controlador {
    
    
    public String logearse (String usuario, String contrasenia){
       Login login = new Login();
       LoginDAO loginDAO = new LoginDAO();
       login.setUserBD(usuario);
       login.setPasswordBD(contrasenia);
       loginDAO.setLogin(login);

       return loginDAO.loginBD();//ejecuta el loggeo y devuelve el error
    }
    
    public Mensajes crearInfoSocioeconomi(String usuario, String contrasenia,Socioeconomico eco){
        logearse(usuario, contrasenia);//se loggea como estudiante
        InfoSocioEconomicaDAO socioDAO = new InfoSocioEconomicaDAO();
        return socioDAO.incluirInfoSocioEconomica(eco);//Devuelve un mensaje de error o de éxito
    }
    
    public String crearProceso(String usuario, String contrasenia,Proceso p){
       logearse(usuario, contrasenia);//se loggea como estudiante
       ProcesoDAO procDAO = new ProcesoDAO();
       return procDAO.incluirProceso(p);//Devuelve un mensaje de error o de éxito  
    }
    
    public String crearSocilicitud(String usuario,String contrasenia, Solicitud s){
        logearse(usuario, contrasenia);//loggearse como estudiante    
        SolicitudDAO solicitudDAO = new SolicitudDAO(); 
        return solicitudDAO.incluirSolicitud(s);//realiza el proceso de incluir solicitud y devuelve el mensaje
    }
    
    public String verEstadoSocilitud(Long id){//ver estado de solicitud, correcto
        logearseComoCreador();//loggearse con el encargado
        SolicitudDAO solicitudDAO = new SolicitudDAO();
        return solicitudDAO.verEstadoSolicitud(id);//devuelve el estado de la solicitud o un error.
    }
    public PedirSolicitudes verlinksSocioeco(String usuario, String contrasenia,PedirSolicitudes solicitudes){
         InfoSocioEconomicaDAO eco = new InfoSocioEconomicaDAO();
         ArrayList<Socioeconomico> socio = new ArrayList();
         for (int i = 0; i < solicitudes.getSolicitudes().size(); i++) {
             logearse(usuario, contrasenia);
             Socioeconomico so = eco.verLinks(solicitudes.getSolicitudes().get(i).getNumSocioEconomico());
             socio.add(so);
        }
        solicitudes.setSocioEconomico(socio);
        return solicitudes;
    }
    public String crearEstudiante(Estudiante es, String usuario, String contrasenia ){
        logearseComoCreador();// se loggea como creador
        EstudianteDAO estudiante = new EstudianteDAO();
        return estudiante.crearUsuarioEstudiante(usuario, contrasenia);
    }
   
    
    public PedirSolicitudes verSolicitudes(String usuario, String contrasenia){
        logearse(usuario, contrasenia);
        SolicitudDAO solicitudDAO = new SolicitudDAO();
        return verlinksSocioeco(usuario, contrasenia, solicitudDAO.verTodasLasSolicitudes());//devuelve un arraylist con todas las solicitudes pendientes

    }
    
    public String validarSolicitudes(ArrayList<Solicitud> solicitudes, String usuario, String contrasenia){//duda de esta actualizacion
        String mensaje = "";
        for(int i = 0; i < solicitudes.size();i++){
          logearse(usuario, contrasenia);//se loggea como un encargado
          SolicitudDAO solicitudDAO = new SolicitudDAO();  
          mensaje += solicitudDAO.validarTodasLasSolicitudes(solicitudes.get(i));//Devuele un mensaje de error o éxito
        }
        return mensaje;
    }

    
    
    public String logearseComoCreador(){//login de CREADOR = Supervisor 
        Login login = new Login();
        LoginDAO loginDAO = new LoginDAO();
        login.setUserBD("creador");
        login.setPasswordBD("creador");
        loginDAO.setLogin(login);
        return loginDAO.loginBD(); 
    }
    
    
      public String logearseComoAdmin(){//login de CREADOR = Supervisor 
        Login login = new Login();
        LoginDAO loginDAO = new LoginDAO();
        login.setUserBD("admin");
        login.setPasswordBD("admin");
        loginDAO.setLogin(login);
        return loginDAO.loginBD(); 
    }
  
    
    public Mensajes crearInfoSocioeconomica(String usuario, String contrasenia,Socioeconomico eco){
        logearse(usuario, contrasenia);//se loggea como estudiante
        InfoSocioEconomicaDAO socioDAO = new InfoSocioEconomicaDAO();
        return socioDAO.incluirInfoSocioEconomica(eco);//Devuelve un mensaje de error o de éxito
        
    }
    
    public String crearBeneficiario(Beneficiario bene, String usuario, String contrasenia){
        logearseComoAdmin();
        BeneficiarioDAO benefDAO = new BeneficiarioDAO();
        
        return benefDAO.incluirBeneficiario(bene, usuario,contrasenia);   
    }
    
    public String crearSupervisor(Supervisor sup, String usuario, String contrasenia){
        logearseComoAdmin();
        SupervisorDAO superDAO = new SupervisorDAO();
        return superDAO.incluirSupervisor(sup, usuario, contrasenia);
    }

    public String crearConvocatoria(String usuario, String contrasenia,Convocatoria conv){
        logearse(usuario, contrasenia);
        ConvocatoriaDAO convocatoriaDAO = new ConvocatoriaDAO();
        return convocatoriaDAO.incluirConvocatoria(conv);
    }
    
    public String modificarSemestreConvocatoria(String usuario, String contrasenia,Convocatoria conv){
        logearse(usuario, contrasenia);
        ConvocatoriaDAO convocatoriaDAO = new ConvocatoriaDAO();
        return convocatoriaDAO.modificarSemestreConvocatoria(conv.getCodigo(), conv.getSemestre());
    }

    public String modificarAnioConvocatoria(String usuario, String contrasenia,Convocatoria conv){
        logearse(usuario, contrasenia);
        ConvocatoriaDAO convocatoriaDAO = new ConvocatoriaDAO();
        return convocatoriaDAO.modificarAnioConvocatoria(conv.getCodigo(), conv.getAnio());
    }
    
    
     public String verificarCodigoExiste(long codigo){
        logearseComoAdmin();
        EstudianteDAO estudianteDAO = new EstudianteDAO();
        return estudianteDAO.verificarCodigoExiste(codigo);
    }
     
    public MensajeConvocatoria mostrarConvocatorias(String usuario, String contrasenia){
        logearse(usuario, contrasenia);
        ConvocatoriaDAO convocatoriaDAO = new ConvocatoriaDAO();
        return convocatoriaDAO.mostrarTodasLasConvocatorias();
        
    }
    
    public String actualizarConvocatoria(String usuario, String contrasenia,int indice, Date fechaInicial, Date fechaFinal){
        logearse(usuario, contrasenia);
        ConvocatoriaDAO convocatoriaDAO = new ConvocatoriaDAO();
        return convocatoriaDAO.modificarFechasConvocatoria(indice, fechaInicial, fechaFinal);
    }
    
    public String borrarConvocatoria(String usuario, String contrasenia,int indice){
        logearse(usuario, contrasenia);
        ConvocatoriaDAO convocatoriaDAO = new ConvocatoriaDAO();
        return convocatoriaDAO.eliminarConvocatoria(indice);
    }
    
    
}
