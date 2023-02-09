package org.example;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MedicoRMI extends java.rmi.server.UnicastRemoteObject implements ClinicaInterface {

    private static final long serialVersionUID = -6018159308361504569L;
    private ArrayList<Medico> medicos = new ArrayList<Medico>();
//Obtener datos de una base de datos
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica","root","curso");

    public MedicoRMI() throws SQLException, RemoteException {
        super();
        Statement st= con.createStatement();
        st.executeQuery("SELECT * FROM medico");
        while (st.getResultSet().next()){
            medicos.add(new Medico(st.getResultSet().getInt(1),st.getResultSet().getString(2),st.getResultSet().getString(3),st.getResultSet().getInt(4)));
        }
    }

    @Override
    public String getNombreM(String nombre) throws java.rmi.RemoteException {
        for (Medico medico : medicos) {
            if (medico.getNombre().equals(nombre)) {
                return medico.toString();
            }
        }
        return "No se ha encontrado el médico";
    }

    @Override
    public String getEspecialidad(String especialidad) throws RemoteException {
        for (Medico medico : medicos) {
            if (medico.getEspecialidad().equals(especialidad)) {
                return medico.toString();
            }
        }
        return "No se ha encontrado el médico";
    }

    @Override
    public String getExperiencia(int experiencia) throws RemoteException {
        for (Medico medico : medicos) {
            if (medico.getExperiencia() == experiencia) {
                return medico.toString();
            }
        }
        return "No se ha encontrado el médico";
    }
}

