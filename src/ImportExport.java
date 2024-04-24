import java.io.*;
import java.lang.reflect.Method;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ImportExport implements CSVImportExport{
    Scanner scanner = new Scanner(System.in);
    List<Produktas> produktai = new ArrayList<>();


    Vaisius vaisius;
    String filePath = "C:\\Users\\Darius\\IdeaProjects\\Paskaita-12-Maisto-parduotuve\\src\\produktai.csv";


    @Override
    public List<Produktas> importuotiIsCSV(String path) {
        produktai.clear();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] lineValues = line.split(",");
                if(lineValues[4].equals("true") || lineValues[4].equals("false")){
                    produktai.add(new Vaisius(Integer.parseInt(lineValues[0]), lineValues[1], Double.parseDouble(lineValues[2]),
                            LocalDate.parse(lineValues[3]), Boolean.parseBoolean(lineValues[4])));
                }else{
                    produktai.add(new Mesa(Integer.parseInt(lineValues[0]), lineValues[1], Double.parseDouble(lineValues[2]),
                            LocalDate.parse(lineValues[3]), lineValues[4]));
                }

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return produktai;

    }

    @Override
    public void pridetiProduktaICSV(Produktas produktas) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(produktas.toString());
            System.out.println("Produktas " + produktas.prekesInfo() + " sekmingai pridetas.");
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pašalintiProduktaIsCSV(int produktoKodas) {
        List<Produktas> tempList = importuotiIsCSV(filePath);
        clearCSV();
        int tikrinam = 0;
        for(Produktas p : tempList){
            if (p.getKodas() == produktoKodas){
                tempList.remove(p);
                System.out.println("Produktas " + p.prekesInfo() + " sekmingai pasalintas.");
                tikrinam = 1;
            }
        }
        if(tikrinam == 0){
            System.out.println("Produktas nerastas.");
        }
        for(Produktas r : tempList){
            pridetiProduktaICSV(r);
        }
    }
    public void clearCSV(){
            File file = new File("C:\\Users\\Darius\\IdeaProjects\\Paskaita-12-Maisto-parduotuve\\src\\produktai.csv");
            file.delete();
    }
    public void prekiuSarasas(){
        for(Produktas p : produktai){
            System.out.println(p.prekesInfo());
        }
    }
    public void userPridetiICSV() {
        int pasirinkimas = 0;
        try {
            System.out.println("Koki produkta norite prideti? Mesa - 1, Vaisius - 2: ");
            pasirinkimas = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.next();
            System.out.println("Kategorijos pasirinkimas turi buti skaicius. Bandykite dar karta.");
            userPridetiICSV();
        }
            scanner.nextLine();
            switch (pasirinkimas) {
                case 1:
                    userSukurtiMesa();
                    break;
                case 2:
                    userSukurtiVaisiu();
                    break;
                default:
                    System.out.println("Tokios produktu kategorijos nera, bandykite dar karta.");

            }
    }
    public void userSukurtiMesa(){
        int kodas = 0;
        try{
            System.out.println("Prekes kodas: ");
            kodas = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.next();
            System.out.println("Blogai ivestas prekes kodas. Bandykite dar karta.");
            userSukurtiMesa();
        }
        scanner.nextLine();
        System.out.println("Prekes pavadinimas: ");
        String pavadinimas = scanner.nextLine();
        double kaina = 0;
        LocalDate galiojimoData = LocalDate.parse("2000-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try{
            System.out.println("Prekes kaina: ");
            kaina = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Prekes galiojimo data:");
            galiojimoData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (DateTimeException e){
            scanner.next();
            System.out.println("Blogai ivedete data. Bandykite is naujo.");
            userSukurtiMesa();
        }catch (InputMismatchException e){
            scanner.next();
            System.out.println("Blogai ivedete kaina. Bandykite is naujo.");
            userSukurtiMesa();
        }
        System.out.println("Kokia mesos rusis?");
        String rusis = scanner.nextLine();
        Mesa mesa = new Mesa(kodas, pavadinimas, kaina, galiojimoData, rusis);
        pridetiProduktaICSV(mesa);
    }
    public void userSukurtiVaisiu(){
        int kodas = 0;
        try{
            System.out.println("Prekes kodas: ");
            kodas = scanner.nextInt();
        }catch (InputMismatchException e){
            scanner.next();
            System.out.println("Blogai ivestas prekes kodas. Bandykite dar karta.");
            userSukurtiVaisiu();
        }
        scanner.nextLine();
        System.out.println("Prekes pavadinimas: ");
        String pavadinimas = scanner.nextLine();
        double kaina = 0;
        LocalDate galiojimoData = LocalDate.parse("2000-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try{
            System.out.println("Prekes kaina: ");
            kaina = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Prekes galiojimo data:");
            galiojimoData = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (DateTimeException e){
            scanner.next();
            System.out.println("Blogai ivedete data. Bandykite is naujo.");
            userSukurtiVaisiu();
        }catch (InputMismatchException e){
            scanner.next();
            System.out.println("Blogai ivedete kaina. Bandykite is naujo.");
            userSukurtiVaisiu();
        }
        boolean arEko = false;
        try{
            System.out.println("Ar ekologiska? Taip - true, Ne - false: ");
            arEko = scanner.nextBoolean();
        }catch (InputMismatchException e){
            scanner.next();
            System.out.println("Bloga ivestis. Bandykite is naujo.");
            userSukurtiVaisiu();
        }
        Vaisius vaisius = new Vaisius(kodas, pavadinimas, kaina, galiojimoData, arEko);
        pridetiProduktaICSV(vaisius);
    }
    public void userPasalintiCSV(){
        try{
            System.out.println("Iveskite produkto koda kuri norite pasalinti is CSV: ");
            int kodas1 = scanner.nextInt();
            scanner.nextLine();
            pašalintiProduktaIsCSV(kodas1);
        }catch (InputMismatchException e){
            scanner.next();
            System.out.println("Blogai ivestas kodas. Bandykite dar karta.");
            userPasalintiCSV();
        }
    }


}
