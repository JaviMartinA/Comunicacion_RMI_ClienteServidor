package org.example;

public class Medico {
    private int id;
    private String nombre;
    private String especialidad;
    private int experiencia;

    public Medico(int id, String nombre, String especialidad, int experiencia) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.experiencia = experiencia;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }



    @Override
    public String toString() {
        return "\nNombre del médico: "+getNombre()+" Especialidad: "+getEspecialidad()+" Años de experiencia: "+getExperiencia();
    }
}
