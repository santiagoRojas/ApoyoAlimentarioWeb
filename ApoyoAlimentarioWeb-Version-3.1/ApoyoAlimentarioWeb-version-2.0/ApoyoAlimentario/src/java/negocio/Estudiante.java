package negocio;
/**
 * Clase que encapsula los datos del Estudiante
 */
import java.math.BigInteger;
public class Estudiante {
    private int codigo;
    private int identificacion;
    private String tipoIdentificacion;
    private String  nombres;
    private String  apellidos;
    private String modalidad;
    private int matricula;
    private int telefono;
    private String  email;
    private int puntaje;
    private int codigoProyecto;

    public Estudiante() {
    }

    public Estudiante(int codigo, int identificacion, String tipoIdentificacion, String nombres, String apellidos, String modalidad, int matricula, int telefono, String email, int puntaje, int codigoProyecto) {
        this.codigo = codigo;
        this.identificacion = identificacion;
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.modalidad = modalidad;
        this.matricula = matricula;
        this.telefono = telefono;
        this.email = email;
        this.puntaje = puntaje;
        this.codigoProyecto = codigoProyecto;
    }
    
    
    
    //metodos accesores

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getCodigoProyecto() {
        return codigoProyecto;
    }

    public void setCodigoProyecto(int codigoProyecto) {
        this.codigoProyecto = codigoProyecto;
    }


    

  

 

    
}


