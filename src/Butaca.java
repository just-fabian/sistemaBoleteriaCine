public class Butaca {
    String fila;
    int columna;
    String identificador, estado;

    public Butaca(String fila, int columna){
        this.fila = fila;
        this.columna = columna;
        identificador = fila + columna;
        estado = "Disponible";
    }

    public void reservarButaca(){
        estado = "Reservado";
    }

    public boolean isDisponible() {
        return estado.equalsIgnoreCase("disponible");
    }

    public String getIdentificador() {
        return identificador;
    }

    public String mostrarInfoButaca(){
        return "\nBUTACA: " + identificador + "- ESTADO: " + estado;
    }

    public String getEstado() {
        return estado;
    }
}
