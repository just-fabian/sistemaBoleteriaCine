public interface Servicio {
    public void generarFactura();

    public String comprarBoletos(ExhibicionPelicula exhibicionPelicula, Cliente cliente);

    public void generarPuntos(Cliente cliente, int boletosComprados);

    public void generarTicket();
}
