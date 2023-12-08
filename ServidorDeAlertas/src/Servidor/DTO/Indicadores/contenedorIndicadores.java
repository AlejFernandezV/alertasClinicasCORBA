package servidor.DTO.Indicadores;

import java.io.Serializable;


public class contenedorIndicadores implements Serializable{
    
    private frecuenciaCardiaca objFC;
    private frecuenciaRespiratoria objFR;
    private temperatura objTemp;
    private tensionArterial objTA;
    private saturacionOxigeno objSO;

    public contenedorIndicadores() {
        this.objFC = new frecuenciaCardiaca();
        this.objFR = new frecuenciaRespiratoria();
        this.objTemp = new temperatura();
        this.objTA = new tensionArterial();
        this.objSO = new saturacionOxigeno();
    }

    public frecuenciaCardiaca getObjFC() {
        return objFC;
    }

    public void setObjFC(frecuenciaCardiaca objFC) {
        this.objFC = objFC;
    }

    public frecuenciaRespiratoria getObjFR() {
        return objFR;
    }

    public void setObjFR(frecuenciaRespiratoria objFR) {
        this.objFR = objFR;
    }

    public temperatura getObjTemp() {
        return objTemp;
    }

    public void setObjTemp(temperatura objTemp) {
        this.objTemp = objTemp;
    }

    public void setPbjTA(tensionArterial objTA) {
        this.objTA = objTA;
    } 

    public tensionArterial getObjTA() {
        return objTA;
    }

    public void setObjTA(tensionArterial objTA) {
        this.objTA = objTA;
    }

    public saturacionOxigeno getObjSO() {
        return objSO;
    }

    public void setObjSO(saturacionOxigeno objSO) {
        this.objSO = objSO;
    }
    
}
