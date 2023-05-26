package Models.Medic;

import java.util.ArrayList;

public class MedicSingleton {
    private static MedicSingleton instance = null;
    private ArrayList<Medic> medici = new ArrayList<Medic>();

    public static MedicSingleton getInstance()
    {
        if (instance == null)
            instance = new MedicSingleton();
        return instance;
    }

    public static void setInstance(MedicSingleton instance) {
        MedicSingleton.instance = instance;
    }

    public ArrayList<Medic> getMedici() {
        return medici;
    }

    public void addMedic(Medic m) {
        this.medici.add(m);
    }
}
