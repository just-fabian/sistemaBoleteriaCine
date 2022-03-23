package Servicios.Pagos;
import java.util.Arrays;

public class Tarjeta extends TipoPagos{
    @Override
    public String realizarPago(int precioTotal) {
        System.out.println("Nombre del propietario de la tarjeta");
        pedirValorString();
        System.out.println("Número de la tarjeta");
        String numeroTarjeta = scan.next();

        while (!isValidCreditCardNumber(numeroTarjeta)){
            System.out.println("Número de tarjeta no válido");
            numeroTarjeta = scan.next();
        }

        System.out.println("Fecha de vencimiento");
        pedirValorString();
        System.out.println("CCV");
        pedirValorInt(100, 999);

        return EXITO_PAGO;
    }

    public static boolean isValidCreditCardNumber(String cardNumber)
    {
        int[] cardIntArray=new int[cardNumber.length()];

        for(int i=0;i<cardNumber.length();i++)
        {
            char c= cardNumber.charAt(i);
            cardIntArray[i]=  Integer.parseInt(""+c);
        }

        for(int i=cardIntArray.length-2;i>=0;i=i-2)
        {
            int num = cardIntArray[i];
            num = num * 2;  // step 1
            if(num>9)
            {
                num = num%10 + num/10;  // step 2
            }
            cardIntArray[i]=num;
        }

        int sum = sumDigits(cardIntArray);

        if(sum%10==0)
        {
            return true;
        }

        return false;

    }

    public static int sumDigits(int[] arr)
    {
        return Arrays.stream(arr).sum();
    }
}
