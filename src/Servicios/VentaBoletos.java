package Servicios;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Personas.*;
import Cine.Cine;

public class VentaBoletos implements Servicio {
    Scanner scan = new Scanner(System.in);

    //    @Override
    public void realizarOperacion(ExhibicionPelicula exhibicionPelicula) {
        int butacasDisponibles = exhibicionPelicula.verificarButacasDisponibles();

        System.out.println("Hay " + butacasDisponibles + " butacas disponibles\nCuántos boletos quiere?");
        int boletosDeseados = pedirValorInt(1, butacasDisponibles);

        StringBuilder boletos = new StringBuilder("\nBOLETOS: ");
        ArrayList<String> asientos = new ArrayList<>();
        ArrayList<Integer> tipoBoletos = new ArrayList<>();


        for(int i = 0; i < boletosDeseados; i++){
            System.out.println("Introduzca el tipo de boleto");
            System.out.println("1. Adulto");
            System.out.println("2. Adulto mayor (mayor a 60 años)");
            System.out.println("3. Niño (menor a 10 años)");

            int tipoBoleto = pedirValorInt(1, 3);
            tipoBoletos.add(tipoBoleto);

            String asiento = introducirAsiento(exhibicionPelicula);
            asientos.add(asiento);

            exhibicionPelicula.comprarBoleto(asiento, false);

            boletos.append("\n\nPELICULA: ").append(exhibicionPelicula.getNombrePelicula())
                    .append("\nHORA: ").append(exhibicionPelicula.getHorario())
                    .append("\nSALA: " ).append(exhibicionPelicula.getSala().getLetraSala())
                    .append("\nBUTACA: ").append(asiento);
        }

        int precioTotal = 0;
        ArrayList<Integer> descuentos = new ArrayList<>();
        ArrayList<Integer> precioBoletos = new ArrayList<>();
        StringBuilder razonesDescuentos = new StringBuilder();
        Cliente cliente = Cine.manejoClientes();

        for(int i = 0; i < boletosDeseados; i++){
            ArrayList<String> descuentosYRazones  = obtenerDescuento(tipoBoletos.get(i), exhibicionPelicula);

            int valorDescuento = Integer.parseInt(descuentosYRazones.get(0));
            String razonDescuento = descuentosYRazones.get(1);
            descuentos.add(valorDescuento);
            razonesDescuentos.append(razonDescuento);

            int precioBoleto = obtenerPrecioBoleto(valorDescuento, exhibicionPelicula);
            precioBoletos.add(precioBoleto);
            precioTotal = precioTotal + precioBoleto;
        }

        System.out.println(razonesDescuentos);

        Pagar pagar = new Pagar();
        pagar.realizarOperacion(precioTotal);

        for(String asiento : asientos){
            exhibicionPelicula.comprarBoleto(asiento, true);
        }

        generarPuntos(cliente, descuentos);
        System.out.println(boletos);
        System.out.println(Factura.generarFactura(tipoBoletos, precioBoletos, precioTotal));
    }

    public String introducirAsiento(ExhibicionPelicula exhibicionPelicula){
        System.out.println("Introduzca un asiento");
        String asiento = scan.next().toUpperCase();

        while (!exhibicionPelicula.retornarButacasDisponibles().contains(asiento)){
            System.out.println("Introduzca un asiento disponible");
            asiento = scan.next().toUpperCase();
        }

        return asiento;
    }

    public void generarPuntos(Cliente cliente, ArrayList<Integer> descuentos) {
        int puntosGanados = 50;
        int puntosGanadosTotales = 0;

        for (Integer descuento:descuentos){
            if(descuento != 0)  puntosGanados = puntosGanados - ((descuento * puntosGanados) / 100);
            cliente.sumarPuntos(puntosGanados);
            puntosGanadosTotales = puntosGanadosTotales + puntosGanados;
        }

        System.out.println(cliente.getNombre() + ", obtuvo " + puntosGanadosTotales + " puntos, " +
                "sus puntos ahora son: " + cliente.getPuntos());
    }

    public int obtenerPrecioBoleto(int descuento, ExhibicionPelicula exhibicionPelicula){
        int precio = exhibicionPelicula.isExhibicionEn3D() ? 60 : 40;
        if(descuento != 0) precio = precio - ((descuento * precio) / 100);

        return precio;
    }

    ArrayList<String> obtenerDescuento(
            int tipoBoleto, ExhibicionPelicula exhibicionPelicula
    ){
        if(LocalDate.now().getDayOfWeek() == DayOfWeek.WEDNESDAY){
            return new ArrayList<>(List.of(
                    "50", "\nObtuvo un descuento en un boleto del 50% por ser miércoles"
            ));
        }
        else if(tipoBoleto == 2){
            return new ArrayList<>(List.of(
                    "50", "\nObtuvo un descuento en un boleto del 50% por ser adulto mayor"
            ));
        }
        else if(tipoBoleto == 3 && exhibicionPelicula.esPeliculaAnimada){
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