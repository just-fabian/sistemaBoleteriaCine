public class Cliente extends Persona{

    private String correo;
    private int puntos;

    public Cliente(String nombre, int id, String fechaNacimiento, int telefono, String ubicacion) {
        super(nombre, id, fechaNacimiento, telefono, ubicacion);
        puntos = 0;
    }

//    public Cliente(String nombre, int id, String fechaNacimiento, int telefono, String ubicacion, String correo) {
//        super(nombre, id, fechaNacimiento, telefono, ubicacion);
//        this.setCorreo(correo);
//    }

    public void sumarPuntos(int boletosComprados){
        puntos = puntos + (boletosComprados * 50);
    }

    public int getPuntos() {
        return puntos;
    }

    public void setCorreo(String correo) {
        if(!correo.equals("")) {
            this.correo = correo;
        }
    }
}
