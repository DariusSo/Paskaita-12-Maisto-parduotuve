import java.time.LocalDate;

public class Vaisius extends Produktas{
    private boolean arEkologiskas;
    public Vaisius(int kodas, String pavadinimas, double kaina, LocalDate galiojimoData, boolean arEkologiskas) {
        super(kodas, pavadinimas, kaina, galiojimoData);
        this.arEkologiskas = arEkologiskas;
    }

    public boolean isArEkologiskas() {
        return arEkologiskas;
    }

    public void setArEkologiskas(boolean arEkologiskas) {
        this.arEkologiskas = arEkologiskas;
    }

    @Override
    public String toString() {
        return getKodas() + "," + getPavadinimas() + "," + getKaina() + "," + getGaliojimoData() +
                "," + arEkologiskas;
    }
    @Override
    public String prekesInfo(){
        return "Prekes kodas: " + getKodas() + " | Pavadinimas: " + getPavadinimas() + " | Kaina: " + getKaina() +
                " | Galiojimo data: " + getGaliojimoData() + " | Ekologiska: " + arEkologiskas;
    }


}
