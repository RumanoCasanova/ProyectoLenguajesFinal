package com.sergiojavierre.LecturaXML.dao;

import com.sergiojavierre.LecturaXML.dao.vehiculos.DAOVehiculos;
import com.sergiojavierre.LecturaXML.dao.vehiculos.DAOVehiculosXML;


public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOVehiculos daoVehiculos;


    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public DAOVehiculos getDaoVehiculos(){
        if (daoVehiculos == null){
            daoVehiculos = new DAOVehiculosXML();
        }
        return daoVehiculos;
    }

}

