public class Medicamente {
    private String nume;
    private String producator;
    private int pret;
    private int cantitate;
    private int id;
    private String descriere;

    public Medicamente(String nume, String producator, int pret, int cantitate, int id, String descriere) {
        this.nume = nume;
        this.producator = producator;
        this.pret = pret;
        this.cantitate = cantitate;
        this.id = id;
        this.descriere = descriere;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

}
