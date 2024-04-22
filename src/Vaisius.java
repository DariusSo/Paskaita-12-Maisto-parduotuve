import java.time.LocalDate;

public class Vaisius extends Produktas{
    private boolean arEkologiskas;
    public Vaisius(int kodas, String pavadinimas, double kaina, LocalDate galiojimoData, boolean arEkologiskas) {
        super(kodas, pavadinimas, kaina, galiojimoData);
        this.arEkologiskas = isArEkologiskas();
    }

    public boolean isArEkologiskas() {
        return arEkologiskas;
    }

    public void setArEkologiskas(boolean arEkologiskas) {
        this.arEkologiskas = arEkologiskas;
    }

    @Override
    public String toString(Vaisius vaisius) {
        return vaisius.getKodas() + "," + vaisius.getPavadinimas() + "," + vaisius.getKaina() + "," + vaisius.getGaliojimoData() +
                "," + vaisius.arEkologiskas;
    }

    @Override
    public String toString(Mesa mesa) {
        return null;
    }
}
