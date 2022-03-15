public class Persona {

    private String nombre;
    private int carnet;
    private String fechaNacimiento;
    protected int telefono;
    protected String ubicacion;

    public Persona(String nombre, Integer carnet, String fechaNacimiento, int telefono, String ubicacion) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCarnet() {
        return carnet;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
}
