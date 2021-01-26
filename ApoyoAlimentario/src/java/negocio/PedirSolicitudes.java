/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author TOSHIBA
 */
public class PedirSolicitudes {
    private ArrayList<Solicitud> solicitudes;
    private String mensajeError;
    private ArrayList<Socioeconomico> socioEconomico;

    public PedirSolicitudes(ArrayList<Solicitud> solicitudes, String mensajeError, ArrayList<Socioeconomico> socioEconomico) {
        this.solicitudes = solicitudes;
        this.mensajeError = mensajeError;
        this.socioEconomico = socioEconomico;
    }

    public PedirSolicitudes(ArrayList<Solicitud> solicitudes, String mensajeError) {
        this.solicitudes = solicitudes;
        this.mensajeError = mensajeError;
    }
    

    public ArrayList<Socioeconomico> getSocioEconomico() {
        return socioEconomico;
    }

    public void setSocioEconomico(ArrayList<Socioeconomico> socioEconomico) {
        this.socioEconomico = socioEconomico;
    }

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }
    
    
}
