package ComponentesCine;

import ComponentesCine.Butaca;

import java.util.ArrayList;

public class Sala {

    String letraSala, horaDeApertura, tiempoDescanso;
    int numeroButacas;
    ArrayList<Butaca> listaDeButacas;

    public Sala (String letraSala, int numeroDeButacas) {
        this.letraSala = letraSala;
        listaDeButacas = new ArrayList<>(numeroDeButacas);
        this.numeroButacas = numeroDeButacas;
    }

    public ArrayList<Butaca> getListaDeButacas() {
        return listaDeButacas;
    }

    public String getLetraSala() {
        return letraSala;
    }

    public int getNumeroButacas() {
        return numeroButacas;
    }

    public void aniadirButaca(Butaca butaca){
        listaDeButacas.add(butaca);
    }

    public String mostrarButacas(){
        StringBuilder butacas = new StringBuilder();
        for(Butaca butaca:listaDeButacas){
            butacas.append(butaca.mostrarInfoButaca());
        }

        return "\nButacas: " + butacas;
    }
}
