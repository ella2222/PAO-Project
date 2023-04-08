import java.util.ArrayList;
import java.util.List;

public class Trimitere {
    private int id;
    private int medicid;
    private int pacientid;
    private String specializare;

    public Trimitere(int id, int medicid, int pacientid, String specializare) {
        this.id = id;
        this.medicid = medicid;
        this.pacientid = pacientid;
        this.specializare = specializare;
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

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public List<MedicSpecializat> cautMediciiSpecializati(String specializare){
        List<MedicSpecializat> medicisp = new ArrayList<>();
        for(Medic medic : MainServicii.getMedici())
            if(medic instanceof MedicSpecializat)
                if(((MedicSpecializat) medic).getSpecializare().equals(specializare))
                    medicisp.add((MedicSpecializat) medic);
        return medicisp;
    }
}
