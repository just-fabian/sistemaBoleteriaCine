package Servicios;

import java.util.Scanner;


public class Pagar implements Servicio {
    Scanner scan = new Scanner(System.in);

    public void realizarOperacion(int precioTotal) {

        System.out.println("El precio total es de Bs. " + precioTotal);

        System.out.println("Elige el método de pago");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Código QR");

        int valorIntroducido = pedirValorInt(1, 3);
    }

    @Override
    public int pedirValorInt(int rangoMenor, int rangoMayor) {
        while (!scan.hasNextInt()) {
            System.out.println("Introduce un valor correcto: ");
            scan = new Scanner(System.in);
            scan.hasNextInt();
        }

        int valorIntroducido = scan.nextInt();
        while (valorIntroducido < rangoMenor || valorIntroducido > rangoMayor){
            System.out.println("Introduzca un número correcto");
            valorIntroducido = scan.nextInt();
        }

        return valorIntroducido;
    }
}
