package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Paciente {
    private int id;
    private String nombre;
    private String motivo;
    private String fecha;
    private int idMedico;

    public Paciente(int id, String nombre, String motivo, String fecha, int idMedico) {
        this.id = id;
        this.nombre = nombre;
        this.motivo = motivo;
        this.fecha = fecha;
        this.idMedico = idMedico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    @Override
    public String toString() {
        return "Nombre del paciente "+getNombre()+" motivo de la visita "+getMotivo()+" fecha de la visita "+getFecha()+" Id del médico "+getIdMedico();
    }
}
