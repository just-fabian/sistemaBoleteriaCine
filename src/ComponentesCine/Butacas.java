package ComponentesCine;

import java.util.ArrayList;

public class Butacas {
    static ArrayList<Butaca> butacas;
    public static ArrayList<Butaca> getButacas() {
        butacas = new ArrayList<>();
        String [] filas = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (String fila : filas) {
            for (int columna = 1; columna <= 10; columna++) {
                Butaca butaca = new Butaca(fila, columna, true);
                butacas.add(butaca);
            }
        }

        return butacas;
    }
}
