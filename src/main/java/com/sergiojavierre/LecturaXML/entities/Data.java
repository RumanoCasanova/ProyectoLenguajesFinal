package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;
@JacksonXmlRootElement(localName = "data")
public class Data {
    @JacksonXmlElementWrapper(localName = "vehiculos")
    @JacksonXmlProperty(localName = "vehiculo")
    List<Vehiculo> vehiculos;
    List<Piloto> pilotos;

    public Data(){}

    public Data(List<Vehiculo> vehiculos) {
        if(vehiculos != null) {
            this.vehiculos = vehiculos;
        }
        else this.vehiculos = new ArrayList<>();
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
