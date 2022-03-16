public enum TipoEmpleado {

    PORTERO("Portero",1),
    CAJERO("Cajero",2),
    TAQUILLERO("Taquillero",3),
    VENDEDOR_ALIMENTOS("Vendedor de alimentos",4),
    CONTROLADOR("Controlador de la Proyeccion",5);

    private final String cargo;

    private TipoEmpleado(String cargo, int id) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Tipo de Empleado "+
                "cargo: "+cargo;
    }
}
