package Servicios;
import utils.Verificacion;

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
        switch (valorIntroducido){
            case 1:
                pedirValoresTarjeta();
        }
    }

    @Override
    public int pedirValorInt(int rangoMenor, int rangoMayor) {
        Verificacion.intVerificar(scan);

        int valorIntroducido = scan.nextInt();
        while (valorIntroducido < rangoMenor || valorIntroducido > rangoMayor){
            System.out.println("Introduzca un número correcto");
            valorIntroducido = scan.nextInt();
        }

        return valorIntroducido;
    }

    void pedirValoresTarjeta(){
        int numeroTarjeta = pedirValorInt(0, 999999999);

    }
}
