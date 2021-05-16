package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class Vehiculo {


    @JacksonXmlProperty(isAttribute = true)
    private String nombre;
    @JacksonXmlProperty(isAttribute = true)
    private float velocidad;
    @JacksonXmlProperty(isAttribute = true)
    private float potencia;
    @JacksonXmlProperty(isAttribute = true)
    private Piloto piloto;

    public Vehiculo(String nombre, float velocidad, float potencia, Piloto piloto) {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.potencia = potencia;
        this.piloto = piloto;
    }
    public Vehiculo(String vehiculo){}
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public float getPotencia() {
        return potencia;
    }

    public void setPotencia(float potencia) {
        this.potencia = potencia;
    }

    public List<Piloto> getPiloto() {
        return (List<Piloto>) piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "nombre='" + nombre + '\'' +
                ", velocidad=" + velocidad +
                ", potencia=" + potencia +
                ", piloto='" + piloto + '\'' +
                '}';
    }

    public void crearPiloto(Piloto piloto) {
    }
    public void añadirVehiculo(List<Vehiculo> vehiculos) {
    }
}
