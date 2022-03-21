package Servicios;

import java.util.ArrayList;

public class Factura {
    public static String generarFactura(
            ArrayList<Integer> tipoBoletos, ArrayList<Integer> precioBoletos, int precioTotal
    ){
        StringBuilder factura = new StringBuilder("\nFACTURA");
        int boletosNormales = 0, boletosAdultoMayor = 0, boletosNinios = 0;
        int precioBoletosNormal = 0, precioBoletosAdultoMayor = 0, precioBoletosNinios = 0;

        for (int i = 0; i < tipoBoletos.size(); i++){
            int precioBoleto = precioBoletos.get(i);
            switch (tipoBoletos.get(i)){
                case 2:
                    boletosAdultoMayor++;
                    precioBoletosAdultoMayor = precioBoletosAdultoMayor + precioBoleto;
                    break;
                case 3:
                    boletosNinios++;
                    precioBoletosNinios = precioBoletosNinios + precioBoleto;
                    break;
                default:
                    boletosNormales++;
                    precioBoletosNormal = precioBoletosNormal + precioBoleto;
            }
        }

        if (boletosNormales > 0){
            factura.append("\n").append(boletosNormales)
                    .append(" Boleto(s) normal - Bs. ").append(precioBoletosNormal);
        }
        if (boletosNinios > 0){
            factura.append("\n").append(boletosNinios)
                    .append(" Boleto(s) niño - Bs. ").append(precioBoletosNinios);
        }
        if (boletosAdultoMayor > 0){
            factura.append("\n").append(boletosAdultoMayor)
                    .append(" Boleto(s) adulto mayor - Bs. ").append(precioBoletosAdultoMayor);
        }

        factura.append("\nTOTAL - Bs. ").append(precioTotal);
        return factura.toString();
    }
}
