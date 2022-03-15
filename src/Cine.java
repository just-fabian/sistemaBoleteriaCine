import java.util.ArrayList;

public class Cine {
    String nombre;
    ArrayList<Sala> salas;
    ArrayList<Cliente> clientes;
    ArrayList<Empleado> empleados;
    ArrayList<Pelicula> peliculas;

    public Cine(String nombre, int numeroDeSalas){
        this.nombre = nombre;
        salas = new ArrayList<>(numeroDeSalas);
        clientes = new ArrayList<>();
        empleados = new ArrayList<>();
        peliculas = new ArrayList<>();
    }

    public void aniadirSala(Sala sala){
        salas.add(sala);
    }

    public void aniadirCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void aniadirEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public void aniadirPelicula(Pelicula pelicula){ peliculas.add(pelicula); }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public static void main(String[] args) {
        Cine cinePOOI = new Cine("POOI", 7);

        for(Pelicula pelicula : Peliculas.getPeliculas()){
            cinePOOI.aniadirPelicula(pelicula);
        }

        for(Pelicula pelicula : cinePOOI.getPeliculas()){
            System.out.println(pelicula.mostrarExhibiciones());
        }
    }
}
