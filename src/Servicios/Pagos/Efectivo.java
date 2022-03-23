package Servicios.Pagos;
public class Efectivo extends TipoPagos{
    @Override
    public String realizarPago(int precioTotal) {
        System.out.println("Cantidad brindada en efectivo: ");
        int cantidadPago = pedirValorInt(precioTotal, 999999999);
        if(cantidadPago > precioTotal){
            int cambio = cantidadPago - precioTotal;
            System.out.println("Su cambio es de Bs. " + cambio);
        }

        return EXITO_PAGO;
    }
}
