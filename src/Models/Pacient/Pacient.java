package Models.Pacient;

import Models.MainServicii;

public class Pacient {
    private String nume;
    private String prenume;
    private String nrtel;
    private String CNP;
    private int id;

    public Pacient(String nume, String prenume, String nrtel, String CNP, int id) {
        this.nume = nume;
        this.prenume = prenume;
        this.nrtel = nrtel;
        this.CNP = CNP;
        this.id = id;
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

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int idPacientDupaCNP(String CNP){
        int id = 0;
        for(Pacient p : MainServicii.getPacienti()){
            if(p.getCNP().equals(CNP)){
                id = p.getId();
            }
        }
        return id;
    }

}
