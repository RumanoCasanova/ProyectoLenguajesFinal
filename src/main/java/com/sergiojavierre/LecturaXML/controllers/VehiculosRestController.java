package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Piloto;
import com.sergiojavierre.LecturaXML.entities.Vehiculo;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;



@RestController
public class VehiculosRestController {
    public void DosVehiculos(){
        System.out.println(DAOFactory.getInstance().getDaoVehiculos().getAll().get(0));
        System.out.println(DAOFactory.getInstance().getDaoVehiculos().getAll().get(1));
    }

   public void VehiculoconPiloto(){
        List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
        for (int i = 0; i < vehiculos.size(); i++){
            List<Piloto> pilotos = (List<Piloto>) vehiculos.get(i).getPiloto();
            if (pilotos.size() >= 2){
                System.out.println(vehiculos.get(i));
            }
        }

   }
   public void getPrimerVehiculo(){
        List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
        for (int i = 0; i < vehiculos.size(); i++){
            if (vehiculos.get(i).getNombre().contains("488 Pista")){
                System.out.println(vehiculos.get(i));
            }
        }
   }

   public void añadirVehiculo(){
        List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
        for (int i = 0; i < vehiculos.size(); i++){
            List<Piloto> pilotos = (List<Piloto>) vehiculos.get(i).getPiloto();
            for (int j = 0; j < pilotos.size(); j++){
                if (pilotos.get(j).getNombre().contains("Carrera")){
                    vehiculos.get(i).crearPiloto(new Piloto("Fernando Alonso"));
                }
            }
        }
   }

    public String readVehiculos(){
       List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
        return "vehiculos";
   }
    public void EliminarVehiculoConNombre(){
        List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
        for (int i = 0; i < vehiculos.size();i++){
            List<Piloto> pilotos = (List<Piloto>) vehiculos.get(i).getPiloto();
            for (int j = 0; j < pilotos.size(); j++){
                if (pilotos.get(j).getNombre().contains("Fernado Aloso")){
                    vehiculos.remove(i);
                }
            }
        }
    }
    public void ActualizarVehiculo() {
        List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
        for (int i = 0; i < vehiculos.size(); i++) {
            String vehiculos1 = vehiculos.get(i).getNombre();
            for (int j = 0; j < vehiculos.size(); j++) {
                if (vehiculos.get(j).getNombre().contains("Coche")) {
                    vehiculos.get(j).setNombre("La Ferrari");
                }
            }
        }
        DAOFactory.getInstance().getDaoVehiculos().save(vehiculos);
        System.out.println("guardado");
    }

    public void getVehiculoContienepotencia() {
        List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
        for (int i = 0; i < vehiculos.size(); i++) {
            float vehiculos1 = vehiculos.get(i).getPotencia();
            for (int j = 0; j < vehiculos.size(); j++) {
                if (vehiculos.get(j).getNombre().contains("2000")) {
                    System.out.println(vehiculos1);
                }

            }

        }
    }

    public void getVehiculoContieneVelocidad() {
        List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
        for (int i = 0; i < vehiculos.size(); i++) {
            float vehiculos1 = vehiculos.get(i).getVelocidad();
            for (int j = 0; j < vehiculos.size(); j++) {
                if (vehiculos.get(j).getNombre().equals("360")) {
                    System.out.println(vehiculos1);
                }

            }

        }
    }
}
