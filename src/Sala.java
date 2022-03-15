import java.util.ArrayList;

public class Sala {

    String horaDeApertura, tiempoDescanso;
    int numeroDeSala, numeroDeButacas;
    Cine cine;
    ArrayList<Butaca> listaDeButacas;

    public Sala (int numeroDeSala, int numeroDeButacas) {
        this.numeroDeSala = numeroDeSala;
        listaDeButacas = new ArrayList<>(numeroDeButacas);

    }
}
