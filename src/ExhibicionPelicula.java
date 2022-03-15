public class ExhibicionPelicula {
    String horario;
    Sala sala;
    boolean exhibicionEn3D;

    public ExhibicionPelicula(String horario, Sala sala, boolean exhibicionEn3D){
        this.horario = horario;
        this.sala = sala;
        this.exhibicionEn3D = exhibicionEn3D;
    }
}
