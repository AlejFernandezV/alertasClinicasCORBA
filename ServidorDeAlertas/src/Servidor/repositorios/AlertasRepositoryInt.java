package Servidor.repositorios;

import Servidor.DTO.alertaDTO;

public interface AlertasRepositoryInt {
    public boolean agregarAlerta(alertaDTO _alerta);
    public alertaDTO buscarAlerta(int noHabitacion);
}
