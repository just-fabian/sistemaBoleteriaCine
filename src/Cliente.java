public class Cliente extends Persona{

    private String correo;

    public Cliente(String nombre, int id, String fechaNacimiento, int telefono, String ubicacion) {
        super(nombre, id, fechaNacimiento, telefono, ubicacion);
    }

    public Cliente(String nombre, int id, String fechaNacimiento, int telefono, String ubicacion, String correo) {
        super(nombre, id, fechaNacimiento, telefono, ubicacion);
        this.setCorreo(correo);
    }

    public void setCorreo(String correo) {
        if(!correo.equals("")) {
            this.correo = correo;
        }
    }
}
