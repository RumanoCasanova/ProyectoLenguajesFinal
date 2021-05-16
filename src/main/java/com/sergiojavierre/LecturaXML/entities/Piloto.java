package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Piloto {

    @JacksonXmlProperty(isAttribute = true)
    private String nombre;
    public Piloto(Piloto piloto, Integer nombre, Object o, Object o1){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Piloto(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return nombre;
    }

}
