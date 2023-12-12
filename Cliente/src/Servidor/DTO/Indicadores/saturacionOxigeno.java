package Servidor.DTO.Indicadores;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 */
public class saturacionOxigeno implements Serializable{
    private int perOxigeno;

    public int getPerOxigeno() {
        return perOxigeno;
    }

    public void setPerOxigeno(int perOxigeno) {
        this.perOxigeno = perOxigeno;
    }
}
