package com.sergiojavierre.LecturaXML.dao.vehiculos;



import com.sergiojavierre.LecturaXML.entities.Piloto;
import com.sergiojavierre.LecturaXML.entities.Vehiculo;


import java.util.List;

public interface DAOVehiculos {
    public List<Vehiculo> getAll();
    public void eliminar(String nombre,Vehiculo vehiculo);
    public Vehiculo exists(String nombre);
    public String crear (Vehiculo vehiculo);
    public void save(List<Vehiculo> vehiculos);
    public void crearPiloto(String codigo, Piloto piloto);
    void crearVehiculo(String vehiculonombre, String vehiculo);
}
