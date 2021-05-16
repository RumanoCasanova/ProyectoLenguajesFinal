package com.sergiojavierre.LecturaXML.controllers;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Piloto;
import com.sergiojavierre.LecturaXML.entities.Vehiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class VehiculosController {

  @GetMapping("/vehiculos")
    public String readVehiculos(Model model){
      model.addAttribute("vehiculos", DAOFactory.getInstance().getDaoVehiculos().getAll());
      return "vehiculos";
  }
  @GetMapping("/DosVehiculos")
  public String DosVehiculos(Model model) {
    List<Vehiculo> vehiculos = new ArrayList<>();
    vehiculos.add(DAOFactory.getInstance().getDaoVehiculos().getAll().get(0));
    vehiculos.add(DAOFactory.getInstance().getDaoVehiculos().getAll().get(1));
    model.addAttribute("vehiculos", vehiculos);
    return "vehiculos";
  }

  @GetMapping("/DosPilotos")
  public String DosPilotos(Model model) {
    List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
    List<Piloto> VehiculoPasar = new ArrayList<>();
    for (int i = 0; i < vehiculos.size(); i++) {
      List<Piloto> pilotos = (List<Piloto>) vehiculos.get(i).getPiloto();
      if (pilotos.size() >= 2) {
        VehiculoPasar.add(pilotos.get(i));
      }
    }
    model.addAttribute("Vehiculos", VehiculoPasar);
    return "Vehiculos";
  }
  @GetMapping("/VehiculoVelocidad")
  public String VehiculoVelocidad(Model model) {
    List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
    List<Vehiculo> vehiculoPasar = new ArrayList<>();
    for (int i = 0; i < vehiculos.size(); i++) {
      float pilotos = vehiculos.get(i).getVelocidad();
      for (int j = 0; j < vehiculos.size(); j++) {
        if (vehiculos.get(j).getNombre().contains("360")) {
          vehiculoPasar.add(vehiculos.get(i));
        }
      }
    }
    model.addAttribute("Vehiculos", vehiculoPasar);
    return "Vehiculos";
  }
  @GetMapping("/VehiculoPotenci")
  public String VehiculoPotencia(Model model) {
    List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
    List<Vehiculo> VehiculoPasar = new ArrayList<>();
    for (int i = 0; i < vehiculos.size(); i++) {
      float vehiculos1 = vehiculos.get(i).getPotencia();
      for (int j = 0; j < vehiculos.size(); j++) {
        if (vehiculos.get(j).getNombre().equals("2000")) {
          VehiculoPasar.add(vehiculos.get(i));
        }
      }
    }
    model.addAttribute("vehiculos", VehiculoPasar);
    return "vehiculos";
  }
  @GetMapping("/DeleteUnElementoCaballos")
  public String DeleteUnElementoCaballos(Model model){
    List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
    for (int i = 0; i < vehiculos.size(); i++) {
      String vehiculos1 = vehiculos.get(i).getNombre();
      for (int j = 0; j < vehiculos.size(); j++) {
        if (vehiculos.get(j).getNombre().contains("2000")) {
          vehiculos.remove(i);
        }
      }
    }
    DAOFactory.getInstance().getDaoVehiculos().save(vehiculos);
    return "vehiculos";
  }
  //Los elementos cuyos atributos contengan un dato
  @GetMapping("/DeleteElementoIgualA")
  public String DeleteElementoIgualA(Model model){
    List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
    for (int i = 0; i < vehiculos.size(); i++) {
      List<Piloto> pilotos = vehiculos.get(i).getPiloto();
      for (int j = 0; j < pilotos.size(); j++) {
        if (pilotos.get(j).getNombre().equals("Charles Leclerc")) {
          pilotos.remove(i);
        }
      }
    }
    DAOFactory.getInstance().getDaoVehiculos().save(vehiculos);
    return "Vehiculos";
  }
  //Un elemento a un elemento padre
  @GetMapping("/CrearPiloto")
  public String CrearPiloto(Model model, @RequestParam Piloto piloto, @RequestParam Integer nombre){
    Piloto piloto1 = new Piloto(piloto,nombre,null,null);
    DAOFactory.getInstance().getDaoVehiculos().getAll();
    return "piolotos";
  }
  //Añade un atributo a los elementos que cumplan una condición

  @GetMapping("/CrearVehiculo")
  public String CrearVehiculo(Model model, @RequestParam String vehiculonombre, String vehiculo){
    List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
    Vehiculo vehiculo1 = new Vehiculo(vehiculo);
    int Vehiculo = Integer.parseInt(vehiculonombre);
    DAOFactory.getInstance().getDaoVehiculos().crearVehiculo(vehiculonombre,vehiculo);
    return "articulos";
  }
  //El valor de un atributo realizando un filtro sobre cualquier atributo
  @GetMapping("/ActualizarVehiculo")
  public String ActualizarVehiculo(Model model){
    List<Vehiculo> vehiculos = DAOFactory.getInstance().getDaoVehiculos().getAll();
    for (int i = 0; i < vehiculos.size(); i++) {
      String vehiculos1 = vehiculos.get(i).getNombre();
      for (int j = 0; j < vehiculos.size(); j++) {
        if (vehiculos.get(j).getNombre().contains("Coche")) {
          vehiculos.get(j).setNombre("488 Pista");
        }
      }
    }
    DAOFactory.getInstance().getDaoVehiculos().save(vehiculos);
    return "Vehiculos";
  }
}
