import java.util.ArrayList;
import java.util.Scanner;

public class Cine {
    String nombre;
    ArrayList<Sala> salas;
    static ArrayList<Cliente> clientes;
    ArrayList<Empleado> empleados;
    ArrayList<Pelicula> peliculas;
    VentaBoletos ventaBoletos;
    static Scanner scan = new Scanner(System.in);

    public Cine(String nombre, int numeroDeSalas){
        this.nombre = nombre;
        salas = new ArrayList<>(numeroDeSalas);
        clientes = new ArrayList<>();
        empleados = new ArrayList<>();
        peliculas = new ArrayList<>();
        ventaBoletos = new VentaBoletos();
    }

    public void aniadirSala(Sala sala){
        salas.add(sala);
    }

    public static void aniadirCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void aniadirEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public void aniadirPelicula(Pelicula pelicula){ peliculas.add(pelicula); }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public static Cliente registrarCliente(int carnetCliente){
        System.out.println("Introduzca su nombre: ");
        String nombreCliente = scan.next();
        System.out.println("Introduzca su fecha de nacimiento en formato AAAA-MM-DD: ");
        String fechaNacimiento = scan.next();
        System.out.println("Introduzca su telefono: ");
        int telefono = scan.nextInt();
        System.out.println("Introduzca su ubicacion: ");
        String ubicacion = scan.next();

        Cliente cliente = new Cliente(nombreCliente, carnetCliente, fechaNacimiento, telefono, ubicacion);
        aniadirCliente(cliente);

        return cliente;
    }

    public void venderBoleto(ExhibicionPelicula exhibicionPelicula){
        ventaBoletos.realizarOperacion(exhibicionPelicula);
    }

    public static Cliente manejoClientes(){
        Cliente cliente;

        System.out.println("Introduzca el carnet del cliente ");

        while (!scan.hasNextInt()) {
            System.out.println("Introduce un valor correcto: ");
            scan = new Scanner(System.in);
            scan.hasNextInt();
        }

        int carnetCliente = scan.nextInt();

        if(comprobarCliente(carnetCliente) != null) cliente = comprobarCliente(carnetCliente);
        else cliente = registrarCliente(carnetCliente);

        return cliente;
    }

    public static Cliente comprobarCliente(int carnet){
        for(Cliente cliente:clientes) {
            if (carnet == cliente.getCarnet()) return cliente;
        }

        return null;
    }

    public static void main(String[] args) {
        Cine cinePOOI = new Cine("POOI", 7);

        for(Pelicula pelicula : Peliculas.getPeliculas()){
            cinePOOI.aniadirPelicula(pelicula);
        }

        System.out.println(cinePOOI.getPeliculas().get(0).mostrarExhibiciones());

        ExhibicionPelicula exhibicion = cinePOOI.getPeliculas().get(0).getExhibicionesPelicula().get(0);
        cinePOOI.venderBoleto(exhibicion);
    }
}
