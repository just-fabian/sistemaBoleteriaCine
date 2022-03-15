import java.util.ArrayList;

public class Butacas {
    static ArrayList<Butaca> butacas;
    public static ArrayList<Butaca> getButacas() {
        butacas = new ArrayList<>();
        String [] filas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int idxFila = 0; idxFila < filas.length; idxFila++){
            for(int columna = 1; columna <= 10; columna++){
                Butaca butaca = new Butaca(filas[idxFila], columna);
                butacas.add(butaca);
            }
        }

        return butacas;
    }
}
