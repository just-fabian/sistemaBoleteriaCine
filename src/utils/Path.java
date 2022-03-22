package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Path {
    public static BufferedImage cargarImagen(String path) {
        try {
            return ImageIO.read(Path.class.getResource(path));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
