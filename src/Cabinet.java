import java.util.ArrayList;
import java.util.List;

public class Cabinet {
    private String nume;
    private int id;
    private String adresa;
    private String nrtel;
    private String email;
    private String orar;

    public Cabinet(String nume, int id, String adresa, String nrtel, String email, String orar) {
        this.nume = nume;
        this.id = id;
        this.adresa = adresa;
        this.nrtel = nrtel;
        this.email = email;
        this.orar = orar;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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

    public String getOrar() {
        return orar;
    }

    public void setOrar(String orar) {
        this.orar = orar;
    }

    public List<Medic> afisareMedicidelaCabinet(int id) {
        //caut in lista de medici pe cei care au cabinetid = id
        List<Medic> listaMedici = new ArrayList<>();
        for (Medic medic : MainServicii.getMedici()) {
            if (medic.getCabinetid() == id) {
                listaMedici.add(medic);
            }
        }
        return listaMedici;
    }

    public static int idCabinetDupaNumecabinet(String nume) {
        int id = 0;
        for (Cabinet cabinet : MainServicii.getCabinete()) {
            if (cabinet.getNume().equals(nume)) {
                id = cabinet.getId();
            }
        }
        return id;
    }
}
