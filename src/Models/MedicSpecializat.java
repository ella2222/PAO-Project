package Models;

import Models.Medic.Medic;

public class MedicSpecializat extends Medic {

    private String specializare;
    public MedicSpecializat(int cabinetid, String nume, String prenume, String nrtel, String email, int pret, int id, String specializare) {
        super(cabinetid, nume, prenume, nrtel, email, pret, id);
        this.specializare = specializare;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

}
