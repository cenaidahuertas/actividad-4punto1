/**
 * Representa una empresa transportadora encargada de enviar los pedidos.
 * Gestiona la información de costos y tiempos de entrega.
 */
public class Transportadora {
    private String nombre;
    private double costoEnvio;
    private int tiempoEntrega;
    private EstadoPedido estadoEnvio;

    public Transportadora(String nombre, double costoEnvio, int tiempoEntrega) {
        setNombre(nombre);
        setCostoEnvio(costoEnvio);
        setTiempoEntrega(tiempoEntrega);
        this.estadoEnvio = EstadoPedido.PENDIENTE;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        this.nombre = valor;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El costo no puede ser negativo.");
        }
        this.costoEnvio = valor;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(int valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("El tiempo debe ser positivo.");
        }
        this.tiempoEntrega = valor;
    }

    public EstadoPedido getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(EstadoPedido estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    /**
     * Calcula el costo total del envío incluyendo el costo del pedido.
     *
     * @param pedido el pedido a calcular
     * @return el costo total del pedido más el envío
     */
    public double calcularEnvio(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser null.");
        }
        return pedido.getTotal() + costoEnvio;
    }

    /**
     * Despacha un pedido a través de esta transportadora.
     *
     * @param pedido el pedido a despachar
     * @return un mensaje confirmando el despacho
     */
    public String despacharPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser null.");
        }
        this.estadoEnvio = EstadoPedido.ENVIADO;
        return String.format("Pedido %s despachado por %s. Tiempo: %d dias.",
            pedido.getIdPedido(), nombre, tiempoEntrega);
    }

    @Override
    public String toString() {
        return "Transportadora: " + nombre + "\nCosto de Envio: $"
            + String.format("%.2f", costoEnvio) + "\nTiempo de Entrega: " + tiempoEntrega
            + " dias" + "\nEstado del Envio: " + estadoEnvio;
    }
}
