public class VentaBoletos implements Servicio{
    @Override
    public void generarFactura() {
        System.out.println("HOLA CLIENTE, nit , info de cliente, costo total");
    }

    @Override
    public void comprarBoletos() {
        System.out.println("Iniciar Ventas");
    }

    @Override
    public void generarPuntos() {
        System.out.println("puntos por peliculas ");
    }

    @Override
    public void generarTicket() {
        System.out.println("Pelicula, hora/fecha, nrosala, duracion");
    }
}