import java.time.LocalDateTime;
import java.util.Date;

public class Medic {
    private int cabinetid;
    private String nume;
    private String prenume;
    private String nrtel;
    private String email;
    private int pret;
    private int id;

    public Medic(int cabinetid, String nume, String prenume, String nrtel, String email, int pret, int id) {
        this.cabinetid = cabinetid;
        this.nume = nume;
        this.prenume = prenume;
        this.nrtel = nrtel;
        this.email = email;
        this.pret = pret;
        this.id = id;
    }

    public int getCabinetid() {
        return cabinetid;
    }

    public void setCabinetid(int cabinetid) {
        this.cabinetid = cabinetid;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNrtel() {
        return nrtel;
    }

    public void setNrtel(String nrtel) {
        this.nrtel = nrtel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int idMedicDupaNrTel(String nrtel) {
        int id = 0;
        for (Medic medic : MainServicii.getMedici()) {
            if (medic.getNrtel().equals(nrtel)) {
                id = medic.getId();
            }
        }
        return id;
    }

    public static boolean verificDisponibilitate(Date data, String ora, int idMedic) {
        for (Programare programare : MainServicii.getProgramari()) {
            if (programare.getData().equals(data) && programare.getOra().equals(ora) && programare.getMedicid() == idMedic) {
                return false;
            }
        }
        return true;
    }

}
