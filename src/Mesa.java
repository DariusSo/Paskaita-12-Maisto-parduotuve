import java.time.LocalDate;

public class Mesa extends Produktas{
    private String rusis;
    public Mesa(int kodas, String pavadinimas, double kaina, LocalDate galiojimoData, String rusis) {
        super(kodas, pavadinimas, kaina, galiojimoData);
        this.rusis = rusis;
    }

    public String getRusis() {
        return rusis;
    }

    public void setRusis(String rusis) {
        this.rusis = rusis;
    }


    @Override
    public String toString() {
        return getKodas() + "," + getPavadinimas() + "," + getKaina() + "," + getGaliojimoData() +
                "," + this.getRusis();
    }
    @Override
    public String prekesInfo(){
        return "Prekes kodas: " + getKodas() + " | Pavadinimas: " + getPavadinimas() + " | Kaina: " + getKaina() +
                " | Galiojimo data: " + getGaliojimoData() + " | Rusis: " + getRusis();
    }
}
