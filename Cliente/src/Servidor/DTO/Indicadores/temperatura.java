package servidor.DTO.Indicadores;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 */
public class temperatura implements Serializable{
    
    private double gradosC;

    public temperatura() {
    }

    public double getGradosC() {
        return gradosC;
    }

    public void setGradosC(double gradosC) {
        this.gradosC = gradosC;
    }    
}
