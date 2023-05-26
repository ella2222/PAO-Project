package Models.Programare;

import java.util.ArrayList;

public class ProgramareSingleton {
    private static ProgramareSingleton instance = null;
    private ArrayList<Programare> programari = new ArrayList<Programare>();

    public static ProgramareSingleton getInstance()
    {
        if (instance == null)
            instance = new ProgramareSingleton();
        return instance;
    }

    public static void setInstance(ProgramareSingleton instance) {
        ProgramareSingleton.instance = instance;
    }

    public ArrayList<Programare> getProgramari() {
        return programari;
    }

    public void addProgramare(Programare pr) {
        this.programari.add(pr);
    }
}
