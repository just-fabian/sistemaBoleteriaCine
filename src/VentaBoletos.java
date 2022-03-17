import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class VentaBoletos{

//    @Override
    public void realizarOperacion(
            ExhibicionPelicula exhibicionPelicula, ArrayList<Cliente> clientes, int boletosDeseados
    ) {
        Scanner scan = new Scanner(System.in);

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

        int precioTotal = 0;
        String diaSemana = diaSemana();

        for(Cliente cliente:clientes){
            String descuento = obtenerDescuento(cliente, exhibicionPelicula, diaSemana);
            generarPuntos(cliente, descuento);
            precioTotal = precioTotal + obtenerPrecioBoleto(descuento, exhibicionPelicula);
        }

        Pagar.realizarOperacion(precioTotal, diaSemana);

        System.out.println(boletos);

    }

    public void generarPuntos(Cliente cliente, String descuento) {
        int puntosGanados = 50;
        switch (descuento) {
            case "50%":
                puntosGanados = puntosGanados / 2;
                break;
            case "15%":
                puntosGanados = puntosGanados - ((puntosGanados * 100) / 15);
                break;
        }
        cliente.sumarPuntos(puntosGanados);
        System.out.println("Sus puntos ahora son: " + cliente.getPuntos());
    }

    public int obtenerPrecioBoleto(String descuento, ExhibicionPelicula exhibicionPelicula){
        int precio = exhibicionPelicula.isExhibicionEn3D() ? 60 : 40;
        switch (descuento) {
            case "50%":
                precio = precio / 2;
                break;
            case "15%":
                precio = precio - ((precio * 100) / 15);
                break;
        }

        return precio;
    }

    String diaSemana () {
        switch (LocalDate.now().getDayOfWeek()) {
            case MONDAY: return "Lunes";
            case TUESDAY: return "Martes";
            case WEDNESDAY: return "Miércoles";
            case THURSDAY: return "Jueves";
            case FRIDAY: return "Viernes";
            case SATURDAY: return "Sábado";
            default: return "Domingo";
        }
    }

    String obtenerDescuento(Cliente cliente, ExhibicionPelicula exhibicionPelicula, String diaSemana){
        if(cliente.getAniosDeEdad() > 60 || diaSemana.equals("Miércoles")) return "50%";
        else if(cliente.getAniosDeEdad() < 10) return "15%";
        return "0%";
    }

}