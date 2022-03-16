import java.util.ArrayList;
import java.util.Scanner;

public class Cine {
    String nombre;
    ArrayList<Sala> salas;
    ArrayList<Cliente> clientes;
    ArrayList<Empleado> empleados;
    ArrayList<Pelicula> peliculas;
    VentaBoletos ventaBoletos;

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

    public Cliente registrarCliente(int carnetCliente){
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduzca su nombre: ");
        String nombreCliente = scan.next();
        System.out.println("Introduzca su fecha de nacimiento: ");
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
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Desea introducir su carnet para generar puntos por compra de boletos y " +
                        "generar la factura (S/N): "
        );
        String deseaIntroducirCarnet = scan.next().toLowerCase();
        while (!deseaIntroducirCarnet.equals("s") && !deseaIntroducirCarnet.equals("n")){
            System.out.println("Introduzca un valor valido: ");
            deseaIntroducirCarnet = scan.next().toLowerCase();
        }

        Cliente cliente = null;

        if(deseaIntroducirCarnet.equals("s")){
            System.out.println("Introduzca su carnet");
            int carnetCliente = scan.nextInt();

            if(comprobarCliente(carnetCliente) != null) cliente = comprobarCliente(carnetCliente);
            else cliente = registrarCliente(carnetCliente);
        }

        if(exhibicionPelicula.verificarButacasDisponibles() > 0){
            System.out.println(ventaBoletos.comprarBoletos(exhibicionPelicula, cliente));;
        } else System.out.println("Ya no hay asientos disponibles");
    }

    public Cliente comprobarCliente(int carnet){
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

        System.out.println(cinePOOI.getPeliculas().get(0).mostrarExhibiciones());
    }
}
