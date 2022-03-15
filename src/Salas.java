public class Salas {
    Sala salaA;
    public Salas(){
        salaA = new Sala("A", 100);
        for(int i = 0; i < Butacas.getButacas().size(); i++){
            if(i < salaA.getNumeroButacas()) salaA.aniadirButaca(Butacas.getButacas().get(i));
        }
    }

    public Sala getSalaA() {
        return salaA;
    }
}
