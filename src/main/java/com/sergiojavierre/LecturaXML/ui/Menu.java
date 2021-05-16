package com.sergiojavierre.LecturaXML.ui;

import com.sergiojavierre.LecturaXML.controllers.VehiculosRestController;
import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Vehiculo;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        while (true) {
            System.out.println("ELEGIR OPCION");
            System.out.println("1) Mostrar \n2) Actualizar \n3) Salir");
            System.out.println("OPCION");
            String Opcion = scanner.nextLine();
            if (Opcion.equals("1")) {
                ;
            } else if (Opcion.equals("2")) {

            }else if (Opcion.equals("3")){
                System.out.println("SALIR");
                return;
            }
        }
    }


}
