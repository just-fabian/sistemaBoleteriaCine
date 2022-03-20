import java.util.ArrayList;

public class ExhibicionPelicula {
    String nombrePelicula, horario;
    Sala sala;
    boolean exhibicionEn3D, esPeliculaAnimada;

    public ExhibicionPelicula(
            String nombrePelicula, String horario, boolean exhibicionEn3D, boolean esPeliculaAnimada
    ){
        this.nombrePelicula = nombrePelicula;
        this.horario = horario;
        this.exhibicionEn3D = exhibicionEn3D;
        this.esPeliculaAnimada = esPeliculaAnimada;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public int verificarButacasDisponibles(){
        int butacasDisponibles = 0;
        for (Butaca butaca:sala.getListaDeButacas()){
            if(butaca.isDisponible()) butacasDisponibles++;
        }
        return butacasDisponibles;
    }

    public ArrayList<String> retornarButacasDisponibles(){
        ArrayList<String> butacasDisponibles = new ArrayList<>();

        for (Butaca butaca:sala.getListaDeButacas()){
            if(butaca.isDisponible()) butacasDisponibles.add(butaca.getIdentificador());
        }

        return butacasDisponibles;
    }

    public void comprarBoleto(String idButaca, boolean pagado){
        for(Butaca butaca : sala.getListaDeButacas()){
            if(butaca.getIdentificador().equals(idButaca)){
                if(pagado) butaca.ocuparButaca();
                else butaca.reservarButaca();
            }
        }
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public String getHorario() {
        return horario;
    }

    public String mostrarButacas(){
        return sala.mostrarButacas();
    }

    public boolean isEsPeliculaAnimada() {
        return esPeliculaAnimada;
    }

    public boolean isExhibicionEn3D() {
        return exhibicionEn3D;
    }

    public String mostrarExhibicion(){
        String exhibicion = exhibicionEn3D ? "3D" : "2D";
        return "\n------\nHORARIO: " + horario + "\nSala: Sala-" + sala.getLetraSala() +
                "\nEN: " + exhibicion;
    }
}
