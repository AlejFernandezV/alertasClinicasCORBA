package Servidor.respositorios;

import java.util.HashMap;
import sop_corba.GestionPacientesPackage.pacienteDTO;

public class PacienteRepositoryImpl implements PacienteRepositoryInt{
    
    private HashMap<Integer, pacienteDTO> pacientes;
    
    public PacienteRepositoryImpl() {
        this.pacientes = new HashMap();
    }
    
    @Override
    public boolean registrarPaciente(pacienteDTO objPaciente) {
        if(objPaciente!=null){
            this.pacientes.put(objPaciente.noHabitacion, objPaciente);
            return true;
        }
        return false;
    }

    @Override
    public pacienteDTO consultarPaciente(int noHabitacion) {
        return pacientes.get(noHabitacion);
    }    
}
