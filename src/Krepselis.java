import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Krepselis {
    List<Produktas> produktaiList = new ArrayList<>();


    public void pridetiKrepselis(Produktas produktas){
        produktaiList.add(produktas);
    }
    public void krepselioInfo(){
        for(Produktas p : produktaiList){
            System.out.println(p.prekesInfo());
        }
    }
    public void krepselioKaina(){
        double kaina = 0;
        for (Produktas p : produktaiList){
            kaina += p.getKaina();
        }
        System.out.println("Krepselio kaina yra: " + String.valueOf(kaina));

    }
}
