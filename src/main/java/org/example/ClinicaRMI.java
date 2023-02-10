package org.example;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ClinicaRMI extends java.rmi.server.UnicastRemoteObject implements ClinicaInterface {

    private static final long serialVersionUID = -6018159308361504569L;
    private ArrayList<Medico> medicos = new ArrayList<Medico>();
    private ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica","root","curso");

    public ClinicaRMI() throws SQLException, RemoteException {
        super();
        Statement st= con.createStatement();
        st.executeQuery("SELECT * FROM medico");
        while (st.getResultSet().next()){
            medicos.add(new Medico(st.getResultSet().getInt(1),st.getResultSet().getString(2),st.getResultSet().getString(3),st.getResultSet().getInt(4)));
        }
        st= con.createStatement();
        st.executeQuery("SELECT * FROM paciente");
        while (st.getResultSet().next()){
            pacientes.add(new Paciente(st.getResultSet().getInt(1),st.getResultSet().getString(2),st.getResultSet().getString(3),st.getResultSet().getString(4),st.getResultSet().getInt(5)));
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

    @Override
    public String getNombreP(String nombre) throws RemoteException, SQLException {
        String nmedico;
        String especializacion;
        int experiencia;
        for(Paciente paciente : pacientes){
            if(paciente.getNombre().equals(nombre)){
                Statement st= con.createStatement();
                st.executeQuery(("SELECT * from medico where id_medico ="+paciente.getIdMedico()));
                while(st.getResultSet().next()){
                    nmedico=st.getResultSet().getString(2);
                    especializacion=st.getResultSet().getString(3);
                    experiencia=st.getResultSet().getInt(4);
                    return paciente.toString()+"\nNombre del médico:"+nmedico+" Especialidad:"+especializacion+" Años de experiencia:"+experiencia;
                }

            }
        }
        return "No se ha encontrado paciente";
    }
    @Override
    public String getMotivo(String motivo) throws RemoteException, SQLException {
        String nmedico;
        String especializacion;
        int experiencia;
        for(Paciente paciente : pacientes){
            if(paciente.getMotivo().equals(motivo)){
                Statement st= con.createStatement();
                st.executeQuery(("SELECT * from medico where id_medico ="+paciente.getIdMedico()));
                while(st.getResultSet().next()){
                    nmedico=st.getResultSet().getString(2);
                    especializacion=st.getResultSet().getString(3);
                    experiencia=st.getResultSet().getInt(4);
                    return paciente.toString()+"\nNombre del médico:"+nmedico+" Especialidad:"+especializacion+" Años de experiencia:"+experiencia;
                }
            }
        }
        return "No se ha encontrado paciente";
    }
    @Override
    public String getFecha(String fecha) throws RemoteException, SQLException {
        String nmedico;
        String especializacion;
        int experiencia;
        for(Paciente paciente : pacientes){
            if(paciente.getFecha().equals(fecha)) {
                Statement st = con.createStatement();
                st.executeQuery(("SELECT * from medico where id_medico ="+paciente.getIdMedico()));
                while (st.getResultSet().next()) {
                    nmedico = st.getResultSet().getString(2);
                    especializacion = st.getResultSet().getString(3);
                    experiencia = st.getResultSet().getInt(4);
                    return paciente.toString() + "\nNombre del médico:" + nmedico + " Especialidad:" + especializacion + " Años de experiencia:" + experiencia;
                }
            }
        }
        return "No se ha encontrado paciente";
    }

    }

