package ComponentesCine;

import ComponentesCine.Butacas;
import ComponentesCine.Sala;

import java.util.ArrayList;
import java.util.List;

public class SalasCine {
    Sala salaA;
    Sala salaB;
    Sala salaC;
    Sala salaD;
    Sala salaE;
    Sala salaF;
    Sala salaG;
    ArrayList<Sala> salasCine;

    public SalasCine(){
        salaA = new Sala("A", 100);
        salaB = new Sala("B", 100);
        salaC = new Sala("C", 100);
        salaD = new Sala("D", 80);
        salaE = new Sala("E", 80);
        salaF = new Sala("F", 50);
        salaG = new Sala("G", 50);

        salasCine = new ArrayList<>(List.of(salaA, salaB, salaC, salaD, salaE, salaF, salaG));

        for(int i = 0; i < Butacas.getButacas().size(); i++){
            for(Sala sala:salasCine){
                if(i < sala.getNumeroButacas()) sala.aniadirButaca(Butacas.getButacas().get(i));
            }
        }
    }
    public Sala getSalaA() {
        return salaA;
    }

    public Sala getSalaB() {
        return salaB;
    }

    public Sala getSalaC() {
        return salaC;
    }

    public Sala getSalaD() {
        return salaD;
    }

    public Sala getSalaE() {
        return salaE;
    }

    public Sala getSalaF() {
        return salaF;
    }

    public Sala getSalaG() {
        return salaG;
    }
}