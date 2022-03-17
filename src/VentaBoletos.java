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
                System.out.println("Introduzca un asinto disponible");
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
        ArrayList<Integer> descuentos = new ArrayList<>();
        StringBuilder razonesDescuentos = new StringBuilder();

        for(Cliente cliente:clientes){
            int descuento = obtenerDescuento(cliente, exhibicionPelicula, diaSemana);
            descuentos.add(descuento);
            generarPuntos(cliente, descuento);
            precioTotal = precioTotal + obtenerPrecioBoleto(descuento, exhibicionPelicula);
        }

        Pagar.realizarOperacion(precioTotal, diaSemana, descuentos);

//      OCUPAR BUTACAS

        System.out.println(boletos);

    }

    public void generarPuntos(Cliente cliente, int descuento) {
        int puntosGanados = 50;

        if(descuento != 0)  puntosGanados = puntosGanados - ((descuento * puntosGanados) / 100);

        cliente.sumarPuntos(puntosGanados);
        System.out.println("Sus puntos ahora son: " + cliente.getPuntos());
    }

    public int obtenerPrecioBoleto(int descuento, ExhibicionPelicula exhibicionPelicula){
        int precio = exhibicionPelicula.isExhibicionEn3D() ? 60 : 40;
        if(descuento != 0) precio = precio - ((descuento * precio) / 100);

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

    int obtenerDescuento(Cliente cliente, ExhibicionPelicula exhibicionPelicula, String diaSemana){
        if(cliente.getAniosDeEdad() > 60 || diaSemana.equals("Miércoles")) return 50;
        else if(cliente.getAniosDeEdad() < 10 && exhibicionPelicula.esPeliculaAnimada) return 15;
        return 0;
    }

}