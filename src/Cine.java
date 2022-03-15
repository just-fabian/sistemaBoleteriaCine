import java.util.ArrayList;

public class Cine {
    String nombre;
    ArrayList<Sala> salas;
    ArrayList<Cliente> clientes;
    ArrayList<Empleado> empleados;

    public Cine(String nombre, int numeroDeSalas){
        this.nombre = nombre;
        salas = new ArrayList<>(numeroDeSalas);
        clientes = new ArrayList<>();
        empleados = new ArrayList<>();
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
}
