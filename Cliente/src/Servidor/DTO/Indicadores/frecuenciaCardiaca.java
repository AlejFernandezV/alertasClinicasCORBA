package servidor.DTO.Indicadores;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 */
public class frecuenciaCardiaca implements Serializable{
    private int latidosPM;

    public frecuenciaCardiaca() {
    }

    public int getLatidosPM() {
        return latidosPM;
    }

    public void setLatidosPM(int latidosPM) {
        this.latidosPM = latidosPM;
    } 
}
