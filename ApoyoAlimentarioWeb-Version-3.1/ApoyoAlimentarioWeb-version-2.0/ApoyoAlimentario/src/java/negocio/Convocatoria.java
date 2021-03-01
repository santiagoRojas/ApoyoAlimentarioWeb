/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.sql.Date;

/**
 *
 * @author Jorge_Andres
 */
public class Convocatoria {
    private int codigo;
    private int semestre;
    private int anio;
    
    private int tipoProceso;
    private Date fechaInicio;
    private Date fechaFin;
    
    
    //metodos accesores

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }


    public int getTipoProceso() {
        return tipoProceso;
    }

    public void setTipoProceso(int tipoProceso) {
        this.tipoProceso = tipoProceso;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

  
    
    
    
}
