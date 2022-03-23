package Servicios.Pagos;
import Servicios.Servicio;
import utils.Verificacion;

import java.util.Scanner;

public abstract class TipoPagos implements Servicio {
    Scanner scan = new Scanner(System.in);
    public abstract String realizarPago(int precioTotal);
    final String EXITO_PAGO = "Pago realizado con éxito. Disfrute de la película.";

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

    public String pedirValorString(){
        Verificacion.strVerificar(scan);
        return scan.nextLine();
    }
}
