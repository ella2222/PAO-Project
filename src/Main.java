import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> descrierecomenzi = Arrays.asList("Adauga un client", "Adauga o programare", "Cauta medicul de familie cel mai ieftin", "Afiseaza medicamentele", "Afiseaza programarile", "Creeaza o programare de la trimiterea primita", "Sterge programarile care au avut loc deja", "Creaza o prescriptie ieftina", "Calculeaza factura unei anumite programari", "Sterge un cabinet", "Afisare clienti", "Afisare medici dintr-un anumit cabinet", "Iesire program");

    public static void printeazacomenzi() {
        for (int i = 0; i < descrierecomenzi.size(); i++) {
            System.out.println((i+1) + ". " + descrierecomenzi.get(i));
        }
    }

    public static void main(String[] args) throws ParseException {
        printeazacomenzi();
        Scanner scanner = new Scanner(System.in);
        String comanda = scanner.nextLine();
        while (!comanda.equals("exit")) {
            if (comanda.matches("[1-9]") || comanda.matches("10") || comanda.matches("11") || comanda.matches("12") || comanda.matches("13")){
                switch (comanda) {
                    case "1":
                        MainServicii.addClient();
                        break;
                    case "2":
                        MainServicii.addProgramare();
                        break;
                    case "3":
                        MainServicii.findMedicIeftin();
                        break;
                    case "4":
                        MainServicii.afisareMedicamente();
                        break;
                    case "5":
                        MainServicii.afisareProgramari();
                        break;
                    case "6":
                        MainServicii.trimitereProgramare();
                        break;
                    case "7":
                        MainServicii.stergeProgramare();
                        break;
                    case "8":
                        MainServicii.crearePrescriptieIeftina();
                        break;
                    case "9":
                        MainServicii.calculezFactura();
                        break;
                    case "10":
                        MainServicii.stergereCabinet();
                        break;
                    case "11":
                        MainServicii.afisareClienti();
                        break;
                    case "12":
                        MainServicii.afisareMedici();
                        break;
                    case "13":
                        MainServicii.finish();
                        break;
                }
            } else {
                System.out.println("Comanda invalida");
            }
            System.out.println("Mai aveti nevoie de ajutor? (da/nu)");
            String raspuns = scanner.nextLine();
            if (raspuns.equals("da")) {
                printeazacomenzi();
                comanda = scanner.nextLine();
            }
            else {
                System.out.println("Va multumim ca ati ales serviciile noastre!");
                break;
            }
        }
    }
}