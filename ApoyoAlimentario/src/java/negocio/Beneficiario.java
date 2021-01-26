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
public class Beneficiario {
    private int id;
    private String nombre;
    private String apellido;
    private String estado;
    private int id_tipoApoyo;
    private int num_retiro;
    private int num_solicitud;
    private int cod_convocatoria;

 //métodos accesores

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getId_tipoApoyo() {
        return id_tipoApoyo;
    }

    public void setId_tipoApoyo(int id_tipoApoyo) {
        this.id_tipoApoyo = id_tipoApoyo;
    }

    public int getNum_retiro() {
        return num_retiro;
    }

    public void setNum_retiro(int num_retiro) {
        this.num_retiro = num_retiro;
    }

    public int getNum_solicitud() {
        return num_solicitud;
    }

    public void setNum_solicitud(int num_solicitud) {
        this.num_solicitud = num_solicitud;
    }

    public int getCod_convocatoria() {
        return cod_convocatoria;
    }

    public void setCod_convocatoria(int cod_convocatoria) {
        this.cod_convocatoria = cod_convocatoria;
    }
    
  
    
    
}
