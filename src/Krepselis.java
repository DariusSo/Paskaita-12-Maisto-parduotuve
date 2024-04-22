import java.util.ArrayList;
import java.util.List;

public class Krepselis {
    List<Produktas> produktaiList = new ArrayList<>();

    public void krepselioKaina(){
        double kaina = 0;
        for (Produktas p : produktaiList){
            kaina += p.getKaina();
        }
        System.out.println("Krepselio kaina yra: " + String.valueOf(kaina));

    }
}
