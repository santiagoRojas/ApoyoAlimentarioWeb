/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;
import java.math.BigInteger;

/**
 *
 * @author Jorge_Andres
 */
public class Solicitud {
    
    private int numSolicitud;
    private int puntaje;
    private Date Fecha;
    private String estado;
    private String explicacion_estado;
    private int numSupervisor;
    private int numConvocatoria;
    private String codEstudianteSt;
    
    //solicitud_socioecono
    private int codSocioeco;
   
    
    //solicitud_doc
    private int codigoDoc;
    private String rutaDoc;
  
    public int getNumSolicitud() {
        return numSolicitud;
    }

    //métodos accesores
    public void setNumSolicitud(int numSolicitud) {  
        this.numSolicitud = numSolicitud;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getExplicacion_estado() {
        return explicacion_estado;
    }

    public void setExplicacion_estado(String explicacion_estado) {
        this.explicacion_estado = explicacion_estado;
    }

    public int getNumSupervisor() {
        return numSupervisor;
    }

    public void setNumSupervisor(int numSupervisor) {
        this.numSupervisor = numSupervisor;
    }

    public int getNumConvocatoria() {
        return numConvocatoria;
    }

    public void setNumConvocatoria(int numConvocatoria) {
        this.numConvocatoria = numConvocatoria;
    }

    public String getCodEstudianteSt() {
        return codEstudianteSt;
    }

    public void setCodEstudianteSt(String codEstudiante) {
        this.codEstudianteSt = codEstudiante;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getCodSocioeco() {
        return codSocioeco;
    }

    public void setCodSocioeco(int codSocioeco) {
        this.codSocioeco = codSocioeco;
    }

    public int getCodigoDoc() {
        return codigoDoc;
    }

    public void setCodigoDoc(int codigoDoc) {
        this.codigoDoc = codigoDoc;
    }

    public String getRutaDoc() {
        return rutaDoc;
    }

    public void setRutaDoc(String rutaDoc) {
        this.rutaDoc = rutaDoc;
    }
    
    
    
    
 
       
}



