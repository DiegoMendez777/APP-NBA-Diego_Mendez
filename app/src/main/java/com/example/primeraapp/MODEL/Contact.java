package com.example.primeraapp.MODEL;

public class Contact {

    private String equipo;
    private String fecha;
    private String description;
    private int id;
    public Contact(String equipo,String fecha,String descipcion) {
        this.equipo = equipo;
        this.fecha = fecha;
        this.description = descipcion;
    }
    public Contact(int id,String equipo,String fecha,String descipcion) {
        this.equipo = equipo;
        this.fecha = fecha;
        this.description = descipcion;
        this.id = id;
    }
    public Contact() {

    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescipcion() {
        return description;
    }

    public void setDescipcion(String descipcion) {
        this.description = descipcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}