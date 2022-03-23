package utils;

import java.util.Scanner;

public class Verificacion {
    public static void strVerificar(Scanner scan) {
        while (scan.hasNextInt()) {
            System.out.println("Introduce solo letras: ");
            scan = new Scanner(System.in);
            scan.hasNextInt();
        }
    }

    public static void intVerificar(Scanner scan){
        while (!scan.hasNextInt()) {
            System.out.println("Introduce un valor correcto: ");
            scan = new Scanner(System.in);
            scan.hasNextInt();
        }
    }
}
