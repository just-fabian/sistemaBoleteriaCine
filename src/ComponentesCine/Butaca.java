package ComponentesCine;

public class Butaca {
    String fila;
    int columna;
    String identificador, estado;
    boolean disponibleParaUso;

    public Butaca(String fila, int columna, boolean disponibleParaUso){
        this.fila = fila;
        this.columna = columna;
        identificador = fila + columna;
        this.disponibleParaUso = disponibleParaUso;
        estado = disponibleParaUso ? "Disponible" : "No disponible";
    }

    public void reservarButaca(){
        estado = "Reservado";
    }

    public void ocuparButaca(){
        estado = "Ocupado";
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
