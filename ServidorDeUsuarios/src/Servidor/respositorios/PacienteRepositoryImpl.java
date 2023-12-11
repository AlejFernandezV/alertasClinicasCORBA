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
            System.out.println("Registro exitoso");
            return true;
        }
        return false;
    }

    @Override
    public pacienteDTO consultarPaciente(int noHabitacion) {
        pacienteDTO objPaciente = pacientes.get(noHabitacion);
        if(objPaciente!=null){
            System.out.println("Paciente encontrado con éxito");
            return objPaciente;
        }
        System.out.println("El paciente no está registrado");
        return null;
    }    
}
