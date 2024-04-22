import java.time.LocalDate;

public class Mesa extends Produktas{
    private String rusis;
    public Mesa(int kodas, String pavadinimas, double kaina, LocalDate galiojimoData, String rusis) {
        super(kodas, pavadinimas, kaina, galiojimoData);
        this.rusis = getRusis();
    }

    public String getRusis() {
        return rusis;
    }

    public void setRusis(String rusis) {
        this.rusis = rusis;
    }

    @Override
    public String toString(Vaisius vaisius) {
        return null;
    }

    @Override
    public String toString(Mesa mesa) {
        return mesa.getKodas() + "," + mesa.getPavadinimas() + "," + mesa.getKaina() + "," + mesa.getGaliojimoData() +
                "," + mesa.rusis;
    }
}
