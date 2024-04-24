import java.util.List;

public interface CSVImportExport {
    List<Produktas> importuotiIsCSV(String path);
    void pridetiProduktaICSV(Produktas produktas);

    void pašalintiProduktaIsCSV(int produktoKodas);

}
