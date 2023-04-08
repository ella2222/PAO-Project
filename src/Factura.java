import java.util.List;

public class Factura {
    private int id;
    private int medicid;
    private int cabinetid;
    private int pacientid;
    private int programareid;

    public Factura(int id, int medicid, int cabinetid, int pacientid, int programareid) {
        this.id = id;
        this.medicid = medicid;
        this.cabinetid = cabinetid;
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

    public int getCabinetid() {
        return cabinetid;
    }

    public void setCabinetid(int cabinetid) {
        this.cabinetid = cabinetid;
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

    public int calculeazaPretFactura(){
        for(Medic m: MainServicii.getMedici())
            if(m.getId() == medicid)
                return m.getPret();
        return 0;
    }

}
