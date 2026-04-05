public class PagoTarjeta extends Pago {

    public PagoTarjeta(String numero, String fechaVencimiento, String cvv) {
        super(numero, fechaVencimiento, cvv);
    }

    @Override
    public boolean procesarPago(double total) {
        if (total <= 0) throw new IllegalArgumentException("El total debe ser mayor a cero.");
        return true;
    }
}
