import java.time.LocalDate;
import java.util.Scanner;

public class IOManager {
    LocalDate localDate = LocalDate.parse()
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Darius\\IdeaProjects\\Paskaita-12-Maisto-parduotuve\\src\\produktai.csv";
        Scanner scanner = new Scanner(System.in);
        ImportExport importExport = new ImportExport();
        importExport.importuotiIsCSV("C:\\Users\\Darius\\IdeaProjects\\Paskaita-12-Maisto-parduotuve\\src\\produktai.csv");

        System.out.println("Importuoti sarasa is CSV - 1, Prideti preke i CSV - 2, Pasalinti is CSV - 3, Suzinoti krepselio kaina - 4: ");
        int pasirinko = scanner.nextInt();
        scanner.nextLine();
        switch (pasirinko){
            case 1:
                importExport.importuotiIsCSV(filePath);
                break;
            case 2:
                System.out.println("Koki produkta norite prideti? Mesa - 1, Vaisius - 2: ");
                int pasirinkimas = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Prekes kodas: ");
                int kodas = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Prekes pavadinimas: ");
                String pavadinimas = scanner.nextLine();
                System.out.println("Prekes kaina: ");
                double kaina = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Prekes galiojimo data:");
                String galiojimoData = scanner.nextLine();
                switch (pasirinkimas){
                    case 1:
                        System.out.println("Kokia mesos rusis?");
                        String rusis = scanner.nextLine();
                        Mesa mesa = new Mesa(kodas, pavadinimas, kaina, LocalDate.parse(galiojimoData), rusis);
                        importExport.pridetiProduktaICSV(mesa);
                        break;
                    case 2:
                        System.out.println("Ar ekologiska? Taip - true, Ne - false: ");
                        boolean arEko = scanner.nextBoolean();
                        Vaisius vaisius = new Vaisius(kodas, pavadinimas, kaina, LocalDate.parse(galiojimoData), arEko);
                        importExport.pridetiProduktaICSV(vaisius);
                        break;
                }
            case 3:
                System.out.println("Iveskite produkto koda kuri norite pasalinti is CSV: ");
                int kodas1 = scanner.nextInt();
                scanner.nextLine();
                importExport.pašalintiProduktaIsCSV(kodas1);
            case 4:
                importExport.suzinokKaina();
        }
    }
}
