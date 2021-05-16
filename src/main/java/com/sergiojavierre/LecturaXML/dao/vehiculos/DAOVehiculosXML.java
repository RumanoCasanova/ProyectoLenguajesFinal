package com.sergiojavierre.LecturaXML.dao.vehiculos;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sergiojavierre.LecturaXML.entities.Data;
import com.sergiojavierre.LecturaXML.entities.Piloto;
import com.sergiojavierre.LecturaXML.entities.Vehiculo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DAOVehiculosXML  implements DAOVehiculos {
    private final String file = "vehiculos.xml";
    private List<Vehiculo> pilotos;


    @Override
    public List<Vehiculo> getAll() {

        Data data = new Data(null);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(Path.of(file)));
            data = xmlMapper.readValue(xml, Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getVehiculos();
    }

    @Override
    public void eliminar(String nombre, Vehiculo vehiculo) {
        List<Vehiculo> vehiculos = getAll();
        for (int i = 0; i < vehiculos.size(); i++){
            if (vehiculos.get(i).getNombre() == nombre){
                vehiculos.remove(vehiculo);
                save(vehiculos);
            }
        }
    }

    @Override
    public Vehiculo exists(String nombre) {
        List<Vehiculo> vehiculos = getAll();
        for(int i = 0; i < vehiculos.size(); i++){
            if (vehiculos.get(i).getNombre() != nombre) {
                Vehiculo posibleVehiculo = vehiculos.get(i);
                return posibleVehiculo;
            } else {
                Vehiculo posibleVehiculo = vehiculos.get(i);
                return posibleVehiculo;
            }
        }
        return null;
    }

    @Override
    public String crear(Vehiculo vehiculo) {
        List<Vehiculo> vehiculos = getAll();
        vehiculos.add(vehiculo);
        save(vehiculos);
        return vehiculo.getNombre();
    }

    @Override
    public void save(List<Vehiculo> vehiculos) {
        Data dataContainer = new Data(vehiculos);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(file), dataContainer);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void crearPiloto(String Piloto, Piloto piloto) {
        List<Vehiculo> vehiculos = getAll();
        for (int i = 0; i < vehiculos.size(); i++){
            if (vehiculos.get(i).getPiloto().equals(Piloto)){
                vehiculos.get(i).crearPiloto(piloto);
            }
            save(pilotos);
        }

    }

    @Override
    public void crearVehiculo(String vehiculonombre, String vehiculo) {
        List<Vehiculo> vehiculos = getAll();
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getNombre().equals(vehiculo)) {
                vehiculos.get(i).añadirVehiculo(vehiculos);
            }
            save(vehiculos);
        }

    }


}
