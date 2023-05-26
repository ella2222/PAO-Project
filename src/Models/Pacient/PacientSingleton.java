package Models.Pacient;

import java.util.ArrayList;

public class PacientSingleton {
    private static PacientSingleton instance = null;
    private ArrayList<Pacient> pacienti = new ArrayList<Pacient>();

    public static PacientSingleton getInstance()
    {
        if (instance == null)
            instance = new PacientSingleton();
        return instance;
    }

    public static void setInstance(PacientSingleton instance) {
        PacientSingleton.instance = instance;
    }

    public ArrayList<Pacient> getPacienti() {
        return pacienti;
    }

    public void addPacient(Pacient p) {
        this.pacienti.add(p);
    }
}
