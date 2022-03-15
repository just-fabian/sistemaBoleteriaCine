public class ExhibicionPelicula {
    String horario;
    Sala sala;
    boolean exhibicionEn3D;

    public ExhibicionPelicula(String horario, boolean exhibicionEn3D){
        this.horario = horario;
        this.exhibicionEn3D = exhibicionEn3D;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public boolean comprarBoleto(String idButaca){
        for(Butaca butaca : sala.getListaDeButacas()){
            if(butaca.getIdentificador().equals(idButaca)){
                if(butaca.isDisponible()){
                    butaca.ocuparButaca();
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public String mostrarButacas(){
        return sala.mostrarButacas();
    }

    public String mostrarExhibicion(){
        String exhibicion = exhibicionEn3D ? "3D" : "2D";
        return "\n------\nHORARIO: " + horario + "\nSala: Sala-" + sala.getLetraSala() +
                "\nEN: " + exhibicion + mostrarButacas();
    }
}
