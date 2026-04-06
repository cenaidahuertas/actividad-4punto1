/**
 * Implementación de pago mediante tarjeta de crédito/débito.
 * Extiende la clase abstracta Pago.
 */
public class PagoTarjeta extends Pago {

    public PagoTarjeta(String numero, String fechaVencimiento, String cvv) {
        super(numero, fechaVencimiento, cvv);
    }

    /**
     * Procesa el pago con la tarjeta.
     *
     * @param total el monto del pago
     * @return true si el pago fue procesado exitosamente
     */
    @Override
    public boolean procesarPago(double total) {
        if (total <= 0) {
            throw new IllegalArgumentException("El total debe ser mayor a cero.");
        }
        return true;
    }
}
