package org.example;

import java.rmi.Remote;
import java.sql.SQLException;

public interface ClinicaInterface extends Remote {
    public String getNombreM(String nombre) throws java.rmi.RemoteException;

    public String getEspecialidad(String especialidad) throws java.rmi.RemoteException;

    public String getExperiencia(int experiencia) throws java.rmi.RemoteException;

    public String getNombreP(String nombre) throws java.rmi.RemoteException, SQLException;

    public String getMotivo(String motivo) throws java.rmi.RemoteException, SQLException;

    public String getFecha(String fecha) throws java.rmi.RemoteException, SQLException;
}


