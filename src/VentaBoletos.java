import java.util.Scanner;

public class VentaBoletos implements Servicio{
    @Override
    public void generarFactura() {
        System.out.println("HOLA CLIENTE, nit , info de cliente, costo total");
    }

    @Override
    public String comprarBoletos(ExhibicionPelicula exhibicionPelicula, Cliente cliente) {
        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Hay " + exhibicionPelicula.verificarButacasDisponibles() + " butacas disponibles"
        );
        System.out.println("Cuántos boletos quiere?");

        while (!scan.hasNextInt()) {
            System.out.println("Introduce un valor correcto: ");
            scan = new Scanner(System.in);
            scan.hasNextInt();
        }

        int boletosDeseados = scan.nextInt();
        while (exhibicionPelicula.verificarButacasDisponibles() < boletosDeseados){
            System.out.println("No hay " + boletosDeseados + " disponibles, introduzca otro numero");
            boletosDeseados = scan.nextInt();
        }

        StringBuilder boletos = new StringBuilder("\nBOLETOS: ");
        for(int i = 0; i < boletosDeseados; i++){
            System.out.println("Introduzca el asiento");
            String asiento = scan.next().toUpperCase();
            while (!exhibicionPelicula.retornarButacasDisponibles().contains(asiento)){
                System.out.println("El asiento está ocupado, introduzca otro");
                asiento = scan.next().toUpperCase();
            }
            exhibicionPelicula.comprarBoleto(asiento);
            boletos.append("\n\nPELICULA: ").append(exhibicionPelicula.getNombrePelicula())
                    .append("\nHORA: ").append(exhibicionPelicula.getHorario())
                    .append("\nSALA: " ).append(exhibicionPelicula.getSala().getLetraSala())
                    .append("\nBUTACA: ").append(asiento);
        }

        if(cliente != null) generarPuntos(cliente, boletosDeseados);
        return boletos.toString();
    }

    @Override
    public void generarPuntos(Cliente cliente, int boletosComprados) {
        cliente.sumarPuntos(boletosComprados);
        System.out.println("Sus puntos ahora son: " + cliente.getPuntos());
    }

    @Override
    public void generarTicket() {
        System.out.println("Pelicula, hora/fecha, nrosala, duracion");
    }
}