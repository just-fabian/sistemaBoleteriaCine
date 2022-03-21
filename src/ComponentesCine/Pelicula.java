package ComponentesCine;

import Servicios.ExhibicionPelicula;

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

    public String getNombre() {
        return nombre;
    }

    public ArrayList<ExhibicionPelicula> getExhibicionesPelicula() {
        return exhibicionesPelicula;
    }

    public boolean esPeliculaAnimada(){
        return genero == GenerosPeliculas.ANIMACION;
    }

    public String mostrarInfoPelicula(){
        StringBuilder nombresActores = new StringBuilder();

        for(String nombreActor:nombreActores){
            if(nombreActores.indexOf(nombreActor) != 0) nombresActores.append(", ");
            nombresActores.append(nombreActor);
        }

        return "\n\nPELICULA: " + nombre +
                "\nDirector: " + nombreDirector +
                "\nActores: " + nombresActores;
    }

    public String mostrarExhibicionesConButacasDisponibles(){
        StringBuilder exhibiciones = new StringBuilder("\nExhibiciones con ComponentesCine.Butacas Disponibles: ");
        StringBuilder nombresActores = new StringBuilder();

        for(ExhibicionPelicula exhibicionPelicula : exhibicionesPelicula){
            int butacasDisponibles = exhibicionPelicula.verificarButacasDisponibles();
            if(butacasDisponibles > 0) exhibiciones.append(exhibicionPelicula.mostrarExhibicion());
        }

        for(String nombreActor:nombreActores){
            if(nombreActores.indexOf(nombreActor) != 0) nombresActores.append(", ");
            nombresActores.append(nombreActor);
        }

        return "\n\nPELICULA: " + nombre +
                "\nDirector: " + nombreDirector +
                "\nActores: " + nombresActores + exhibiciones;
    }
}
