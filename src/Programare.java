import java.time.LocalDateTime;
import java.util.Date;

public class Programare {
    private int id;
    private int medicid;
    private int pacientid;
    private Date data;
    private String ora;

    public Programare(int id, int medicid, int pacientid, Date data, String ora) {
        this.id = id;
        this.medicid = medicid;
        this.pacientid = pacientid;
        this.data = data;
        this.ora = ora;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String numeMedic(){
           for(Medic m: MainServicii.getMedici())
                if(m.getId() == this.medicid)
                    return m.getNume();
            return null;
    }

   public String numePacient(){
        for(Pacient p: MainServicii.getPacienti())
            if(p.getId() == this.pacientid)
                return p.getNume();
        return null;
    }

    public static int idProgramareDupaDataSiIdMedicsiIdPacient(Date data, String ora, int medicid, int pacientid){
        for(Programare p: MainServicii.getProgramari())
            if(p.getData().equals(data) && p.getOra().equals(ora) && p.getMedicid() == medicid && p.getPacientid() == pacientid)
                return p.getId();
        return -1;
    }

}
