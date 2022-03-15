import java.util.ArrayList;

public class Pelicula {
    GenerosPeliculas genero;
    String nombre;
    ArrayList<ExhibicionPelicula> exhibicionesPelicula;
    ArrayList<String> nombreActores;
    String nombreDirector;

    public Pelicula(
            String nombre, GenerosPeliculas genero, String nombreDirector, ArrayList<String> nombreActores
    ){
        this.nombre = nombre;
        this.genero = genero;
        this.nombreDirector = nombreDirector;
        this.nombreActores = nombreActores;
        exhibicionesPelicula = new ArrayList<>();
    }

    public void aniadirExhibicionPelicula(ExhibicionPelicula exhibicionPelicula){
        exhibicionesPelicula.add(exhibicionPelicula);
    }
}
