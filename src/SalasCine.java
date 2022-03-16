public class SalasCine {
    Sala salaA;
    Sala salaB;
    Sala salaC;
    Sala salaD;
    Sala salaE;
    Sala salaF;
    Sala salaG;

    public SalasCine(){
        salaA = new Sala("A", 100);
        for(int i = 0; i < Butacas.getButacas().size(); i++){
            if(i < salaA.getNumeroButacas()) salaA.aniadirButaca(Butacas.getButacas().get(i));
        }

        salaB = new Sala("B", 100);
        for(int i = 0; i < Butacas.getButacas().size(); i++){
            if(i < salaB.getNumeroButacas()) salaB.aniadirButaca(Butacas.getButacas().get(i));
        }

        salaC = new Sala("C", 100);
        for(int i = 0; i < Butacas.getButacas().size(); i++){
            if(i < salaC.getNumeroButacas()) salaC.aniadirButaca(Butacas.getButacas().get(i));
        }

        salaD = new Sala("D", 80);
        for(int i = 0; i < Butacas.getButacas().size(); i++){
            if(i < salaD.getNumeroButacas()) salaD.aniadirButaca(Butacas.getButacas().get(i));
        }

        salaE = new Sala("E", 80);
        for(int i = 0; i < Butacas.getButacas().size(); i++){
            if(i < salaE.getNumeroButacas()) salaE.aniadirButaca(Butacas.getButacas().get(i));
        }

        salaF = new Sala("F", 50);
        for(int i = 0; i < Butacas.getButacas().size(); i++){
            if(i < salaF.getNumeroButacas()) salaF.aniadirButaca(Butacas.getButacas().get(i));
        }

        salaG = new Sala("G", 50);
        for(int i = 0; i < Butacas.getButacas().size(); i++){
            if(i < salaG.getNumeroButacas()) salaG.aniadirButaca(Butacas.getButacas().get(i));
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