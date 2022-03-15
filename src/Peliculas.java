import java.util.ArrayList;
import java.util.List;

public class Peliculas {

    static ArrayList<Pelicula> listarPeliculas(){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        Salas salas = new Salas();

        ArrayList<String> actoresTheBatman = new ArrayList<>(List.of(
                "Robert Pattinson", "Zoe Kravitz", "Paul Dano", "Colin Farrel"
        ));
        Pelicula theBatman = new Pelicula(
                "The Batman", GenerosPeliculas.ACCION, "Matt Reeves", actoresTheBatman
        );

        ExhibicionPelicula exhTheBatman2000 = new ExhibicionPelicula("20:00", true);
        exhTheBatman2000.setSala(salas.getSalaA());

        theBatman.aniadirExhibicionPelicula(exhTheBatman2000);
        peliculas.add(theBatman);

        return peliculas;
    }

    public static ArrayList<Pelicula> getPeliculas() {
        return listarPeliculas();
    }
}
