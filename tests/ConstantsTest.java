import org.junit.Test;
import utils.Constantes;
import utils.Path;


public class ConstantsTest {
    @Test
    public void importarImgs() {
        Constantes.init();
    }

    @Test
    public void loopArchivos() {
        Path.cargarImagen("/assets/chair_white.png");
        //assertEquals(null,image);
    }
}
