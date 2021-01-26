/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.Date;


/**
 *
 * @author Jorge_Andres
 */
public class Solicitud {
    private int num;
    private Integer puntaje;
    private Integer semestre;
    private Integer anio;
    private Date fecha;
    private String fechaActual;
    private String estado;
    private int numSupervisor;
    private int numSocioEconomico;
    private Long codEstudiante;

    public Long getCodEstudiante() {
        return codEstudiante;
    }

    public void setCodEstudiante(Long codEstudiante) {
        this.codEstudiante = codEstudiante;
    }

    public String getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(String fechaActual) {
        this.fechaActual = fechaActual;
    }
    
    
 
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

   
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getNumSupervisor() {
        return numSupervisor;
    }

    public void setNumSupervisor(Integer numSupervisor) {
        this.numSupervisor = numSupervisor;
    }

    public Integer getNumSocioEconomico() {
        return numSocioEconomico;
    }

    public void setNumSocioEconomico(Integer numSocioEconomico) {
        this.numSocioEconomico = numSocioEconomico;
    }


 
       
}


