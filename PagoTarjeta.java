public class PagoTarjeta extends Pago {

    public PagoTarjeta(String numeroTarjeta, String fechaVencimiento, String cvv) {
        super(numeroTarjeta, fechaVencimiento, cvv);
    }

    @Override
    public boolean procesarPago(double total) {
        // Lógica para procesar el pago con tarjeta
        System.out.println("Procesando pago con tarjeta por un total de: " + total);
        return true;
    }
}