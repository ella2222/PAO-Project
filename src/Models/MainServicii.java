package Models;

import Database.JDBCdatabase;
import Models.Cabinet.Cabinet;
import Models.Cabinet.CabinetSingleton;
import Models.Cabinet.CabinetTable;
import Models.Medic.Medic;
import Models.Medic.MedicSingleton;
import Models.Medic.MedicTable;
import Models.Pacient.Pacient;
import Models.Pacient.PacientSingleton;
import Models.Pacient.PacientiTable;
import Models.Programare.Programare;
import Models.Programare.ProgramareSingleton;
import Models.Programare.ProgramariTable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class MainServicii {
    static JDBCdatabase connection = new JDBCdatabase();
    static MedicTable medicTable = new MedicTable(connection);
    static CabinetTable cabinetTable = new CabinetTable(connection);
    static PacientiTable pacientiTable = new PacientiTable(connection);
    static ProgramariTable programariTable = new ProgramariTable(connection);


    static Medic m1 = new MedicSpecializat(1, "Chiriac", "Ella", "0770673115", "ellachiriac@medi.ro", 1000, 1, "dermatologie");
    static Medic m2 = new MedicSpecializat(1, "Popescu", "Ion", "0745123456", "popion@medi.ro", 700, 2, "oftalmologie");
    static Medic m3 = new MedicSpecializat(2, "Ionescu", "Maria", "0745123457", "ionescumaria@medi.ro", 800, 3, "cardiologie");
    static Medic m4 = new MedicSpecializat(2, "Chiriac", "Ana", "0770896371", "anachiriac@medi.ro", 1000, 4, "dermatologie");
    static Medic m5 = new MedicSpecializat(3, "Popescu", "Maria", "0745123458", "popescumaria@medi.ro", 700, 5, "oftalmologie");
    static Medic m7 = new MedicFamilie(3, "Stoica", "Andrei", "0745123459", "standrei@medi.ro", 500, 6);
    static Medic m8 = new MedicFamilie(3, "Stoica", "Maria", "0745123460", "stmaria@medi.ro", 500, 7);
    static Medic m9 = new MedicFamilie(3, "Ion", "Andrei", "0745123461", "ionandrei@medi.ro", 500, 8);
    static Medic m10 = new MedicFamilie(3, "Ion", "Maria", "0745123462", "ionmaria@medi.ro", 600, 9);
    static Medic m11 = new MedicSpecializat(3, "Popescu", "Andrei", "0745123463", "popand@medi.ro", 700, 10, "oftalmologie");
    static Medic m12 = new MedicSpecializat(3, "Popescu", "Maria", "0745123464", "popmar@medi.ro", 700, 11, "cardiologie");

    static Pacient p1 = new Pacient( "Stoica", "Elias", "0712345678", "5030130170018", 1);
    static Pacient p2 = new Pacient("Popa", "Andrei", "0712345679", "5030329170001", 2);
    static Pacient p3 = new Pacient("Zarnescu", "Cristiana", "0712345680", "6021223170002", 3);
    static Pacient p4 = new Pacient("Pop", "Maria", "0712345681", "6030130170003", 4);

    static Cabinet c1 = new Cabinet("Cabinetul 1",1,  "Strada 1", "0745123456", "cab1@mail.ro", "9-18");
    static Cabinet c2 = new Cabinet("Cabinetul 2",2, "Strada 2", "0745123457", "cab2@mail.ro", "9-18");
    static Cabinet c3 = new Cabinet("Cabinetul 3",3, "Strada 3", "0745123458", "cab3@mail.ro", "9-18");

    static Date date1 = new Date(2021, 4, 10);
    static Date date2 = new Date(2023, 4, 8);
    static Date date3 = new Date(2023, 4, 5);
    static Date date4 = new Date(2023, 4, 20);
    static Programare pr1 = new Programare(1, 1, 1, date1, "12:00");
    static Programare pr2 = new Programare(2, 2, 2, date2, "12:00");
    static Programare pr3 = new Programare(3, 3, 3, date3, "12:00");
    static Programare pr4 = new Programare(4, 4, 4, date4, "12:00");


    static Medicamente med1 = new Medicamente("Paracetamol", "X", 10, 10, 1, "raceala");
    static Medicamente med2 = new Medicamente("Aspirin", "X", 20, 10, 2, "dureri");
    static Medicamente med3 = new Medicamente("Nurofen", "X", 40, 10, 3, "dureri");
    static Medicamente med4 = new Medicamente("Nurofen", "Y", 15, 10, 4, "dureri");
    static Medicamente med5 = new Medicamente("Nurofen", "Z", 20, 10, 5, "raceala");

    static Prescriptie presc1 = new Prescriptie(1, 1, 1, 1);
    static Prescriptie presc2 = new Prescriptie(2, 2, 2, 2);
    static Prescriptie presc3 = new Prescriptie(3, 3, 3, 3);
    static Prescriptie presc4 = new Prescriptie(4, 4, 4, 4);

    private static List<Medic> medici = new ArrayList<>(Arrays.asList(m1, m2, m3, m4, m5, m7, m8, m9, m10, m11, m12));
    private static List<Pacient> pacienti = new ArrayList<>(Arrays.asList(p1, p2, p3, p4));
    private static List<Cabinet> cabinete = new ArrayList<>(Arrays.asList(c1, c2, c3));
    private static List<Programare> programari = new ArrayList<>(Arrays.asList(pr1, pr2, pr3, pr4));
    private static List<Medicamente> medicamente = new ArrayList<>(Arrays.asList(med1, med2, med3, med4, med5));
    private static List<Prescriptie> prescriptii = new ArrayList<>(Arrays.asList(presc1, presc2, presc3, presc4));
    private static int idtrimitere = 0;
    private static int idfactura = 0;

    static {
        pacientiTable.createPacientiTable();
        cabinetTable.createCabinetTable();
        medicTable.createMedicTable();
        programariTable.createProgramariTable();
    }
    static {
        for (Medic m : medici) {
            medicTable.addMedic(m);
        }
    }

    static {
        for (Pacient p : pacienti) {
            pacientiTable.addPacient(p);
        }
    }
    static {
        for (Cabinet c : cabinete) {
            cabinetTable.addCabinet(c);
        }
    }
    static {
        for (Programare pr : programari) {
            programariTable.addProgramare(pr);
        }
    }

    public MainServicii() throws ParseException {
    }

    public static List<Medic> getMedici() {
        return medici;
    }

    public static List<Pacient> getPacienti() {

        return pacienti;
    }

    public static List<Cabinet> getCabinete() {

        return cabinete;
    }

    public static List<Programare> getProgramari() {

        return programari;
    }

    public static List<Medicamente> getMedicamente() {

        return medicamente;
    }

    public static void addClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele pacientului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele pacientului: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti CNP-ul pacientului: ");
        String cnp = scanner.nextLine();
        for (Pacient p : pacienti)
            if (p.getCNP().equals(cnp)) {
                System.out.println("Pacientul cu acest CNP exista deja in sistem.");
                return;
            }
        System.out.println("Introduceti numarul de telefon al pacientului: ");
        String nrtel = scanner.nextLine();
        int id = pacienti.size() + 1;
        Pacient pacient = new Pacient(nume, prenume, cnp, nrtel, id);
        pacienti.add(pacient);
        pacientiTable.addPacient(pacient);
    }

    public static void addProgramare() throws ParseException {
        System.out.println("Alege un pacient: ");
        for (Pacient p : pacienti) {
            System.out.println(p.getId() + ". " + p.getNume() + " " + p.getPrenume());
        }
        Scanner scanner = new Scanner(System.in);
        int idPacient = scanner.nextInt();
        System.out.println("Alege un medic: ");
        for (Medic m : medici) {
            System.out.println(m.getId() + ". " + m.getNume() + " " + m.getPrenume());
        }
        int idMedic = scanner.nextInt();

        System.out.println("Introduceti data programarii: ");
        Scanner scanner1 = new Scanner(System.in);
        String date = scanner1.nextLine();
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = sdf.parse(date);

        System.out.println("Introduceti ora programarii: ");
        String ora = scanner1.nextLine();

        if (Medic.verificDisponibilitate(data, ora, idMedic) == false) {
            System.out.println("Medicul nu are disponibilitate in acea zi la ora respectiva.");
            return;

        }
        else {
            int id = programari.size() + 1;
            Programare programare = new Programare(id, idMedic, idPacient, data, ora);
            programari.add(programare);
            programariTable.addProgramare(programare);
            System.out.println("Programarea a fost adaugata cu succes.");
        }
    }

    public static void findMedicIeftin() {
        List<Medic> copieMedici = new ArrayList<>(medici);
        copieMedici.sort((o1, o2) -> {
            if (o1.getPret() > o2.getPret()) {
                return 1;
            } else if (o1.getPret() < o2.getPret()) {
                return -1;
            } else {
                return 0;
            }
        });
        System.out.println("Medicul cel mai ieftin este: " + copieMedici.get(0).getNume() + " " + copieMedici.get(0).getPrenume() + " cu pretul de " + copieMedici.get(0).getPret() + " lei" + " si numarul de telefon " + copieMedici.get(0).getNrtel());

        medicTable.getMedicieftin();
    }

    public static void afisareMedicamente() {
        for (Medicamente medicamente : medicamente) {
            System.out.println("Nume medicament: " + medicamente.getNume() + "\nPret: " + medicamente.getPret() + "\nProducator: " + medicamente.getProducator() + "\nCantitate: " + medicamente.getCantitate() + "\nDescriere: " + medicamente.getDescriere() + "\n");
        }
    }

    public static void afisareProgramari() {
        for (Programare programare : programari) {
            System.out.println("Data programarii: " + programare.getData() + "\nOra programarii: " + programare.getOra()  + "\nNume pacient: " + programare.numePacient()  + "\nNume medic: " + programare.numeMedic() + "\n");
        }
        programariTable.getProgramari();
    }

    public static void trimitereProgramare() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Alege pacient: ");
        for (Pacient p : pacienti) {
            System.out.println(p.getId() + ". " + p.getNume() + " " + p.getPrenume());
        }
        int idPacient = scanner.nextInt();

        System.out.println("Alege medic: ");
        for (Medic m : medici) {
            System.out.println(m.getId() + ". " + m.getNume() + " " + m.getPrenume());
        }

        int idMedic = scanner.nextInt();

        System.out.println("Introduceti specializarea: ");
        String specializare = scanner.nextLine();

        idtrimitere++;
        Trimitere trimitere = new Trimitere(idtrimitere, idPacient, idMedic, specializare);

        List<MedicSpecializat> mediciSpecializati = new ArrayList<>();
        mediciSpecializati = trimitere.cautMediciiSpecializati(specializare);
        if(mediciSpecializati.isEmpty()){
            System.out.println("Nu exista medici specializati in " + specializare);
        }else{
            System.out.println("Introduceti data programarii: ");
            Scanner scanner1 = new Scanner(System.in);
            String date = scanner1.nextLine();
            DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data = sdf.parse(date);
            System.out.println("Introduceti ora programarii: ");
            String ora = scanner.nextLine();

            for(MedicSpecializat medicSpecializat : mediciSpecializati){
                if(Medic.verificDisponibilitate(data, ora, medicSpecializat.getId())){
                    int id = programari.size() + 1;
                    Programare programare = new Programare(id, medicSpecializat.getId(), idPacient, data, ora);
                    System.out.println("Programarea a fost facuta cu succes!");
                    return;
                }
                else {
                    System.out.println("Medicul nu are disponibilitate in acea zi la ora respectiva.");
                }
            }
        }
    }

    public static void stergeProgramare() {
        for (Programare programare : programari) {
            if (programare.getData().before(new Date())) {
                programari.remove(programare);
            }
        }
        programariTable.deleteProgramareinaintededata(java.sql.Date.valueOf(LocalDate.now()));
    }

    public static int crearePrescriptieIeftina() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele pacientului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele pacientului: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti CNP-ul pacientului: ");
        String cnp = scanner.nextLine();

        System.out.println("Introduceti numele medicului: ");
        String numeMedic = scanner.nextLine();
        System.out.println("Introduceti prenumele medicului: ");
        String prenumeMedic = scanner.nextLine();
        System.out.println("Introduceti nr de telefon al medicului: ");
        String nrtelMedic = scanner.nextLine();

        System.out.println("Introduceti data programarii: ");
        Date data = new Date(scanner.nextLine());
        System.out.println("Introduceti ora programarii: ");
        String ora = scanner.nextLine();

        int idpacient = Pacient.idPacientDupaCNP(cnp);
        int idmedic = Medic.idMedicDupaNrTel(nrtelMedic);
        int idprogramare = Programare.idProgramareDupaDataSiIdMedicsiIdPacient(data, ora, idpacient, idmedic);
        int id = prescriptii.size() + 1;


        Prescriptie prescriptie = new Prescriptie(id, idmedic, idpacient, idprogramare);
        prescriptii.add(prescriptie);

        System.out.println("Introduceti descrierea medicamentelor: (dupa ultimul medicament introduceti 0)");
        while(true){
            String descriere = scanner.nextLine();
            if(descriere.equals("0")){
                break;
            }
            else{
                List<Medicamente> copieMedicamente = new ArrayList<>();
                copieMedicamente = medicamente;
                copieMedicamente.sort((o1, o2) -> {
                    if(o1.getPret() > o2.getPret()){
                        return 1;
                    }
                    else if(o1.getPret() < o2.getPret()){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                });

                for(Medicamente medicament : copieMedicamente){
                    if(medicament.getDescriere().equals(descriere)){
                        prescriptie.adaugaMedicament(medicament);
                        break;
                    }
                }

            }
        }

        return prescriptie.calculeazaPretPrescriptie();

    }

    public static int calculezFactura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele pacientului: ");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele pacientului: ");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti CNP-ul pacientului: ");
        String cnp = scanner.nextLine();

        System.out.println("Introduceti numele cabinetului: ");
        String numeCabinet = scanner.nextLine();

        System.out.println("Introduceti numele medicului: ");
        String numeMedic = scanner.nextLine();
        System.out.println("Introduceti prenumele medicului: ");
        String prenumeMedic = scanner.nextLine();
        System.out.println("Introduceti nr de telefon al medicului: ");
        String nrtelMedic = scanner.nextLine();

        System.out.println("Introduceti data programarii: ");
        Date data = new Date(scanner.nextLine());
        System.out.println("Introduceti ora programarii: ");
        String ora = scanner.nextLine();

        int idpacient = Pacient.idPacientDupaCNP(cnp);
        int idmedic = Medic.idMedicDupaNrTel(nrtelMedic);
        int idprogramare = Programare.idProgramareDupaDataSiIdMedicsiIdPacient(data, ora, idpacient, idmedic);
        int idcab = Cabinet.idCabinetDupaNumecabinet(numeCabinet);
        idfactura++;

        Factura factura = new Factura(idfactura, idmedic, idpacient, idprogramare, idcab);

        int pretPrescriptie = 0;
        for(Prescriptie prescriptie : prescriptii){
            if(prescriptie.getProgramareid() == idprogramare){
                pretPrescriptie = prescriptie.calculeazaPretPrescriptie();
                break;
            }
        }

        return factura.calculeazaPretFactura() + pretPrescriptie;

    }

    public static void stergereCabinet() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele cabinetului: ");
        String numeCabinet = scanner.nextLine();

        int idCabinet = Cabinet.idCabinetDupaNumecabinet(numeCabinet);

        for(Medic medic : medici){
            if(medic.getCabinetid() == idCabinet){
                medici.remove(medic);
            }
        }

        for(Cabinet cabinet : cabinete){
            if(cabinet.getId() == idCabinet){
                cabinete.remove(cabinet);
            }
        }
        cabinetTable.deleteCabinet(idCabinet);
    }

    public static void afisareClienti() {
        for(Pacient pacient : pacienti){
            System.out.println(pacient.getId() + ". " + pacient.getNume() + " " + pacient.getPrenume());
        }
        pacientiTable.getPacienti();
    }

    public static void afisareMedici() {
        System.out.println("Introduceti numele cabinetului: ");
        Scanner scanner = new Scanner(System.in);
        String numeCabinet = scanner.nextLine();

        int idCabinet = Cabinet.idCabinetDupaNumecabinet(numeCabinet);

        for(Medic medic : medici){
            if(medic.getCabinetid() == idCabinet){
                System.out.println(medic.getId() + ". " + medic.getNume() + " " + medic.getPrenume() + " - " + medic.getNrtel());
            }
        }
        medicTable.getMedicibycabinet(idCabinet);
    }

    public static void finish(){
        System.exit(0);
    }
}
