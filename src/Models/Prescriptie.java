package Models;

import Models.Medic.Medic;

import java.util.ArrayList;
import java.util.List;

public class Prescriptie {
    private int id;
    private int medicid;
    private int pacientid;
    private int programareid;

    private List<Medicamente> medicamente = new ArrayList<>();
    private static int pret;
    public Prescriptie(int id, int medicid, int pacientid, int programareid) {
        this.id = id;
        this.medicid = medicid;
        this.pacientid = pacientid;
        this.programareid = programareid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicid() {
        return medicid;
    }

    public void setMedicid(int medicid) {
        this.medicid = medicid;
    }

    public int getPacientid() {
        return pacientid;
    }

    public void setPacientid(int pacientid) {
        this.pacientid = pacientid;
    }

    public int getProgramareid() {
        return programareid;
    }

    public void setProgramareid(int programareid) {
        this.programareid = programareid;
    }

    public int calculeazaPretPrescriptie(){
        for(Medic m: MainServicii.getMedici())
            if(m.getId() == medicid)
                for(Medicamente med: medicamente)
                    pret += med.getPret();
        return pret;
    }

    public void adaugaMedicament(Medicamente med){
        medicamente.add(med);
    }

}
