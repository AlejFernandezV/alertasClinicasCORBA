package Servidor.repositorios;

import servidor.DTO.alertaDTO;

public interface AlertasRepositoryInt {
    public boolean agregarAlerta(alertaDTO _alerta);
    public alertaDTO buscarAlerta(int noHabitacion);
}
