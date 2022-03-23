package Servicios.Pagos;
import Servicios.Servicio;
import utils.Verificacion;
import java.util.Scanner;

public class Pagar implements Servicio {
    Scanner scan = new Scanner(System.in);
    Tarjeta tarjeta;
    CodigoQR codigoQR;
    Efectivo efectivo;

    public Pagar(){
        tarjeta = new Tarjeta();
        codigoQR = new CodigoQR();
        efectivo = new Efectivo();
    }

    public void realizarOperacion(int precioTotal) {
        System.out.println("El precio total es de Bs. " + precioTotal);

        System.out.println("Elige el método de pago");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta");
        System.out.println("3. Código QR");

        int valorIntroducido = pedirValorInt(1, 3);
        switch (valorIntroducido){
            case 2:
                System.out.println(tarjeta.realizarPago(precioTotal));
                break;
            case 3:
                System.out.println(codigoQR.realizarPago(precioTotal));
                break;
            default:
                System.out.println(efectivo.realizarPago(precioTotal));
        }
    }

    @Override
    public int pedirValorInt(int rangoMenor, int rangoMayor) {
//        Verificacion.intVerificar(scan);
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
