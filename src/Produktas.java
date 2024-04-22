import java.time.LocalDate;

public abstract class Produktas {
    private int kodas;
    private String pavadinimas;
    private double kaina;
    private LocalDate galiojimoData;

    public Produktas(int kodas, String pavadinimas, double kaina, LocalDate galiojimoData) {
        this.kodas = kodas;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
        this.galiojimoData = galiojimoData;
    }

    public int getKodas() {
        return kodas;
    }

    public void setKodas(int kodas) {
        this.kodas = kodas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public double getKaina() {
        return kaina;
    }

    public void setKaina(double kaina) {
        this.kaina = kaina;
    }

    public LocalDate getGaliojimoData() {
        return galiojimoData;
    }

    public void setGaliojimoData(LocalDate galiojimoData) {
        this.galiojimoData = galiojimoData;
    }

    public abstract String toString(Vaisius vaisius);

    public abstract String toString(Mesa mesa);
}
