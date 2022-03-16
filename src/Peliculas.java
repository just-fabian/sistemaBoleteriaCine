import java.util.ArrayList;
import java.util.List;

public class Peliculas {

    static ArrayList<Pelicula> listarPeliculas(){
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        SalasCine salas = new SalasCine();

        //BATMAN
        ArrayList<String> actoresTheBatman = new ArrayList<>(List.of(
                "Robert Pattinson", "Zoe Kravitz", "Paul Dano", "Colin Farrel"
        ));
        Pelicula theBatman = new Pelicula(
                "The Batman", GenerosPeliculas.ACCION, "Matt Reeves", actoresTheBatman
        );

        ExhibicionPelicula exhTheBatman2000 = new ExhibicionPelicula(
                theBatman.getNombre(), "20:00", true
        );
        exhTheBatman2000.setSala(salas.getSalaA());

        theBatman.aniadirExhibicionPelicula(exhTheBatman2000);
        peliculas.add(theBatman);

        //PROYECTO ADAM
        ArrayList<String> actoresElProyectoAdam = new ArrayList<>(List.of(
                "Ryan Reynolds", "Mark Ruffalo", "Jennifer Garner", "Walker Scobell"
        ));
        Pelicula elProyectoAdam = new Pelicula(
                "El proyecto Adam", GenerosPeliculas.COMEDIA, "Shawn Levy", actoresElProyectoAdam
        );

        ExhibicionPelicula exhElProyectoAdam = new ExhibicionPelicula(
                elProyectoAdam.getNombre(), "20:00", false
        );
        exhElProyectoAdam.setSala(salas.getSalaB());

        elProyectoAdam.aniadirExhibicionPelicula(exhElProyectoAdam);
        peliculas.add(elProyectoAdam);

        //CHERNOBIL
        ArrayList<String> actoresChernobil = new ArrayList<>(List.of(
                "Danila Kozlovski", "Okasana Akinshina", "Igor Chernevich", "Filipp Avdeev"
        ));
        Pelicula chernovil = new Pelicula(
                "Chernobil", GenerosPeliculas.DRAMA, "Danila Kozlovski", actoresChernobil
        );

        ExhibicionPelicula exhChernovil = new ExhibicionPelicula(
                chernovil.getNombre(), "20:00", true
        );
        exhChernovil.setSala(salas.getSalaC());

        chernovil.aniadirExhibicionPelicula(exhChernovil);
        peliculas.add(chernovil);

        //EL PRIVILEGIO
        ArrayList<String> actoresElPrivilegio = new ArrayList<>(List.of(
                "Max Schimmelpfennig", "Lee van", "Tijan Marei", "Horst Janson", "Maurice Lattke"
        ));
        Pelicula elPrivilegio = new Pelicula(
                "El Privilegio", GenerosPeliculas.TERROR, "Katharina Schode", actoresElPrivilegio
        );

        ExhibicionPelicula exhElPrivilegio = new ExhibicionPelicula(
                elPrivilegio.getNombre(), "16:30", true
        );
        exhElPrivilegio.setSala(salas.getSalaD());

        elPrivilegio.aniadirExhibicionPelicula(exhElPrivilegio);
        peliculas.add(elPrivilegio);

        //NUREYEV
        ArrayList<String> actoresNureyev = new ArrayList<>(List.of(
                "Rudolf Nureyev"
        ));
        Pelicula nureyev = new Pelicula(
                "Nureyev", GenerosPeliculas.DOCUMENTAL, "David Morris", actoresNureyev
        );

        ExhibicionPelicula exhNureyev = new ExhibicionPelicula(
                nureyev.getNombre(), "15:45", false
        );
        exhNureyev.setSala(salas.getSalaE());

        nureyev.aniadirExhibicionPelicula(exhNureyev);
        peliculas.add(nureyev);

        //A DOS METROS DE TI
        ArrayList<String> actoresAdosMetrosDeTi = new ArrayList<>(List.of(
                "Cole Sprouse", "Haley Lu", "Moises Arias", "Kimberly Herbert", "Gary Weeks"
        ));
        Pelicula aDosMetrosDeTi = new Pelicula(
                "A Dos Metros De Ti", GenerosPeliculas.ROMANCE, "Justin Baldoni",
                actoresAdosMetrosDeTi);

        ExhibicionPelicula exhAdosMetrosDeTi = new ExhibicionPelicula(
                aDosMetrosDeTi.getNombre(), "22:00", false
        );
        exhAdosMetrosDeTi.setSala(salas.getSalaF());

        aDosMetrosDeTi.aniadirExhibicionPelicula(exhAdosMetrosDeTi);
        peliculas.add(aDosMetrosDeTi);

        //DESDE MI CIELO
        ArrayList<String> actoresDesdeMiCielo = new ArrayList<>(List.of(
                "Rachel Weisz", "Susan Sarandon", "Stanley Tucci", "Mark Wahlberg", "Rose Mclver"
        ));
        Pelicula desdeMiCielo = new Pelicula(
                "Desde Mi Cielo", GenerosPeliculas.FANTASIA, "Peter Jackson",
                actoresDesdeMiCielo);

        ExhibicionPelicula exhDesdeMiCielo= new ExhibicionPelicula(
                desdeMiCielo.getNombre(), "22:00", true
        );
        exhDesdeMiCielo.setSala(salas.getSalaG());

        desdeMiCielo.aniadirExhibicionPelicula(exhDesdeMiCielo);
        peliculas.add(desdeMiCielo);


        return peliculas;

    }

    public static ArrayList<Pelicula> getPeliculas() {
        return listarPeliculas();
    }
}
