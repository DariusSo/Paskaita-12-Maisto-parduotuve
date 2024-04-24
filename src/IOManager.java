import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class IOManager {

        String filePath = "C:\\Users\\Darius\\IdeaProjects\\Paskaita-12-Maisto-parduotuve\\src\\produktai.csv";
        Scanner scanner = new Scanner(System.in);
        ImportExport importExport = new ImportExport();
        Krepselis krepselis = new Krepselis();

        public void menu(){
            importExport.importuotiIsCSV(filePath);
            System.out.println("Esamu prekiu sarasas - 1, Prideti preke i CSV - 2, Pasalinti is CSV - 3, " +
                    "Prideti preke i krepseli pagal koda - 4, Suzinoti krepselio turini - 5, Suzinoti krepselio prekiu kaina - 6, Baigti - 7: ");
            int pasirinko = 0;
            try {
                pasirinko = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Bloga ivestis. Bandykite dar kart");
            }
            scanner.nextLine();
            switch (pasirinko) {
                case 1:
                    importExport.prekiuSarasas();
                    break;
                case 2:
                    importExport.userPridetiICSV();
                    break;

                case 3:
                    importExport.userPasalintiCSV();
                    break;
                case 4:
                    userPridetiIKrepseli();
                    break;
                case 5:
                    krepselis.krepselioInfo();
                    break;
                case 6:
                    krepselis.krepselioKaina();
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Netinkamas pasirinkimas.");



            }
        }
        public void userPridetiIKrepseli(){
            try{
                System.out.println("Iveskite produkto koda: ");
                int kodas2 = scanner.nextInt();
                scanner.nextLine();
                int tikrinam1 = 0;
                for (Produktas p : importExport.produktai) {
                    if (p.getKodas() == kodas2) {
                        krepselis.pridetiKrepselis(p);
                        System.out.println("Produktas " + p.prekesInfo() + " sekmingai pridetas i krepseli.");
                        tikrinam1 = 1;
                        break;
                    }
                }
                if(tikrinam1 == 0){
                    System.out.println("Produktas nerastas.");
                }
            }catch (InputMismatchException e){
                scanner.next();
                System.out.println("Blogai ivestas produkto kodas. Bandykite dar karta.");
                userPridetiIKrepseli();
            }
        }

}
