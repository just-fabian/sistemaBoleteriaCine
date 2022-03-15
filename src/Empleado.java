public class Empleado extends Persona {

    private int numeroEmpleado;
    public TipoEmpleado cargo;

    public Empleado(String nombre, int carnet, String fechaNacimiento, int telefono, String ubicacion, TipoEmpleado cargo) {
        super(nombre, carnet, fechaNacimiento, telefono, ubicacion);
        this.cargo = cargo;
    }
}
