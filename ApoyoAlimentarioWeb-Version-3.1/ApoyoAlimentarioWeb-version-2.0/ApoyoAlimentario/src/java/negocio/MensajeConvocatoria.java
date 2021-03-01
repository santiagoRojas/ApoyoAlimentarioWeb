/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Jorge_Andres
 */

import java.util.ArrayList;
import negocio.Convocatoria;

public class MensajeConvocatoria {
   public ArrayList<Convocatoria> convoca = new ArrayList();
   public String mensaje = null;  

    public ArrayList<Convocatoria> getConvoca() {
        return convoca;
    }

    public void setConvoca(ArrayList<Convocatoria> convoca) {
        this.convoca = convoca;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
   
   
    
}
