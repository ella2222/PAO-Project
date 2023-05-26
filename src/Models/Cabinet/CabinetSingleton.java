package Models.Cabinet;

import Models.Cabinet.Cabinet;
import Models.Cabinet.CabinetSingleton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CabinetSingleton {
    private static CabinetSingleton instance = null;
    private ArrayList<Cabinet> cabinete = new ArrayList<Cabinet>();

    public static CabinetSingleton getInstance()
    {
        if (instance == null)
            instance = new CabinetSingleton();
        return instance;
    }

    public static void setInstance(CabinetSingleton instance) {
        CabinetSingleton.instance = instance;
    }

    public ArrayList<Cabinet> getCabinete() {
        return cabinete;
    }

    public void addCabinet(Cabinet c) {
        this.cabinete.add(c);
    }
}