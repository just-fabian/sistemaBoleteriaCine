import java.util.Scanner;

public class Pagar{

    public static void realizarOperacion(
            int precioTotal, String diaSemana
    ) {
        System.out.println("Hoy es " + diaSemana);
        System.out.println("El precio total es de " + precioTotal);

        Scanner scan = new Scanner(System.in);
        System.out.println("Elige el método de pago");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Código QR");
    }
}
