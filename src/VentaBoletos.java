import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VentaBoletos implements Servicio{
    Scanner scan = new Scanner(System.in);

    //    @Override
    public void realizarOperacion(ExhibicionPelicula exhibicionPelicula) {
        int butacasDisponibles = exhibicionPelicula.verificarButacasDisponibles();

        if(butacasDisponibles <= 0){
            System.out.println("Ya no hay butacas disponibles para esta función");
            return;
        }

        System.out.println("Hay " + butacasDisponibles + " butacas disponibles");
        System.out.println("Cuántos boletos quiere?");

        int boletosDeseados = pedirValorInt(1, butacasDisponibles);

        StringBuilder boletos = new StringBuilder("\nBOLETOS: ");


        for(int i = 0; i < boletosDeseados; i++){
            System.out.println("Introduzca el asiento");
            String asiento = scan.next().toUpperCase();

            while (!exhibicionPelicula.retornarButacasDisponibles().contains(asiento)){
                System.out.println("Introduzca un asiento disponible");
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
        ArrayList<Cliente> clientes = new ArrayList<>();
        StringBuilder razonesDescuentos = new StringBuilder();

        for(int i = 0; i < boletosDeseados; i++){
            Cliente cliente = Cine.manejoClientes();
            clientes.add(cliente);

            ArrayList<String> descuentosYRazones  = obtenerDescuento(cliente, exhibicionPelicula, diaSemana);
            int valorDescuento = Integer.parseInt(descuentosYRazones.get(0));
            String razonDescuento = descuentosYRazones.get(1);
            descuentos.add(valorDescuento);
            razonesDescuentos.append(razonDescuento);
            precioTotal = precioTotal + obtenerPrecioBoleto(valorDescuento, exhibicionPelicula);
        }

        System.out.println("Hoy es " + diaSemana);
        System.out.println(razonesDescuentos);

        Pagar pagar = new Pagar();
        pagar.realizarOperacion(precioTotal);

        for(int i = 0; i < clientes.size(); i++){
            generarPuntos(clientes.get(i), descuentos.get(i));
        }

//      OCUPAR BUTACAS

        System.out.println(boletos);

    }

    public void generarPuntos(Cliente cliente, int descuento) {
        int puntosGanados = 50;

        if(descuento != 0)  puntosGanados = puntosGanados - ((descuento * puntosGanados) / 100);

        cliente.sumarPuntos(puntosGanados);
        System.out.println(cliente.getNombre() + ", sus puntos ahora son: " + cliente.getPuntos());
    }

    public int obtenerPrecioBoleto(int descuento, ExhibicionPelicula exhibicionPelicula){
        int precio = exhibicionPelicula.isExhibicionEn3D() ? 60 : 40;
        if(descuento != 0) precio = precio - ((descuento * precio) / 100);

        return precio;
    }

    String diaSemana() {
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

    ArrayList<String> obtenerDescuento(
            Cliente cliente, ExhibicionPelicula exhibicionPelicula, String diaSemana
    ){
        if(diaSemana.equals("Miércoles")){
            return new ArrayList<>(List.of(
                    "50", "\nObtuvo un descuento en un boleto del 50% por ser miércoles"
            ));
        }
        else if(cliente.getAniosDeEdad() > 60){
            return new ArrayList<>(List.of(
                    "50", "\nObtuvo un descuento en un boleto del 50% por ser adulto mayor"
            ));
        }
        else if(cliente.getAniosDeEdad() < 10 && exhibicionPelicula.esPeliculaAnimada){
            return new ArrayList<>(List.of(
                    "15",
                    "\nObtuvo un descuento en un boleto del 15% por ser niño y " +
                            "entrar a película de animación"
            ));
        }
        return new ArrayList<>(List.of("0", ""));
    }

    @Override
    public int pedirValorInt(int rangoMenor, int rangoMayor) {
        while (!scan.hasNextInt()) {
            System.out.println("Introduce un valor correcto: ");
            scan = new Scanner(System.in);
            scan.hasNextInt();
        }

        int boletosDeseados = scan.nextInt();
        while (boletosDeseados < rangoMenor || boletosDeseados > rangoMayor){
            System.out.println("Introduzca una cantidad adecuada de asientos ");
            boletosDeseados = scan.nextInt();
        }

        return boletosDeseados;
    }
}