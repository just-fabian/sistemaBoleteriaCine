package utils;

import java.awt.image.BufferedImage;

public class Constantes {
    public static BufferedImage butaca_white;
    public static BufferedImage background;
    public static BufferedImage icon1;
    public static BufferedImage batt_img;
    public static BufferedImage Adamimg;
    public static BufferedImage Chernobilimg;
    public static BufferedImage proyectimg;
    public static BufferedImage nervyimg;

    public static void init() {

        butaca_white = Path.cargarImagen("/assets/chair_white.png");
        background = Path.cargarImagen("/assets/fondospace.png");
        icon1 = Path.cargarImagen("/assets/icono1.png");
        batt_img = Path.cargarImagen("/assets/batt.png");
        Adamimg = Path.cargarImagen("/assets/adamImg.png");
        Chernobilimg = Path.cargarImagen("/assets/chernobilImg.png");
        proyectimg = Path.cargarImagen("/assets/privilegioImg.png");
        nervyimg = Path.cargarImagen("/assets/nureyev.png");
    }
}
