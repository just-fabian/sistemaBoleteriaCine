public class Butaca {
    String fila;
    int columna;
    String identificador;
    boolean disponible;

    public Butaca(String fila, int columna){
        this.fila = fila;
        this.columna = columna;
        identificador = fila + columna;
        disponible = true;
    }

    public void ocuparButaca(){
        disponible = false;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public String getIdentificador() {
        return identificador;
    }
}
