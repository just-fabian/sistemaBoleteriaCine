import java.util.ArrayList;
import java.util.Scanner;

public class Pagar{

    public static void realizarOperacion(int precioTotal, String diaSemana, ArrayList<Integer> descuentos) {
        System.out.println("Hoy es " + diaSemana);

        System.out.println("El precio total es de " + precioTotal);
        for(Integer descuento:descuentos){
            if(descuento != 0)  System.out.println("Obtuvo un descuento de " + descuento + "%");
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Elige el método de pago");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Código QR");
    }
}
