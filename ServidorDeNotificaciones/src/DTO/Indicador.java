package DTO;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 */
public class Indicador implements Serializable{
    private String nombre;
    private String valor;

    public Indicador(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    
}
