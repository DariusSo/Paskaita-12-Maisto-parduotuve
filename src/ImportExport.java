import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ImportExport implements CSVImportExport{
    Scanner scanner = new Scanner(System.in);
    Krepselis krepselis = new Krepselis();

    Vaisius vaisius;
    String filePath = "C:\\Users\\Darius\\IdeaProjects\\Paskaita-12-Maisto-parduotuve\\src\\produktai.csv";


    @Override
    public void importuotiIsCSV(String path) {

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] lineValues = line.split(",");
                System.out.println(lineValues[0] + lineValues[1] + lineValues[2] + lineValues[3] + lineValues[4]);
                if(lineValues[4].equals("true") || lineValues[4].equals("false")){
                    krepselis.produktaiList.add(new Vaisius(Integer.parseInt(lineValues[0]), lineValues[1], Double.parseDouble(lineValues[2]),
                            LocalDate.parse(lineValues[3]), Boolean.parseBoolean(lineValues[4])));
                }else{
                    krepselis.produktaiList.add(new Mesa(Integer.parseInt(lineValues[0]), lineValues[1], Double.parseDouble(lineValues[2]),
                            LocalDate.parse(lineValues[3]), lineValues[4]));
                }

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void pridetiProduktaICSV(Produktas produktas) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(produktas.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pašalintiProduktaIsCSV(int produktoKodas) {
        importuotiIsCSV(filePath);
        for(Produktas p : krepselis.produktaiList){
            if (p.getKodas() == produktoKodas){
                krepselis.produktaiList.remove(p);
                for(Produktas r : krepselis.produktaiList){
                    pridetiProduktaICSV(r);
                }
            }
        }
    }
    public void suzinokKaina(){
        krepselis.krepselioKaina();
    }
}
