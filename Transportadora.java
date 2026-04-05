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

    // - Getters y Setters --------------

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El nombre de la transportadora no puede estar vacío.");
        }
        this.nombre = valor;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }
    public void setCostoEnvio(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El costo de envío no puede ser negativo.");
        }
        this.costoEnvio = valor;
    }

    public int getTiempoEntrega() {
        return tiempoEntrega;
    }
    public void setTiempoEntrega(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El tiempo de entrega no puede ser negativo.");
        }
        this.tiempoEntrega = valor;
    }

    public EstadoPedido getEstadoEnvio() {
        return estadoEnvio;
    }
    public void setEstadoEnvio(EstadoPedido estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    // - metodos -----------------

    public double calcularEnvio(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        return pedido.getTotal() * costoEnvio;
    }

    public String despacharPedido(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        this.estadoEnvio = EstadoPedido.ENVIADO;
        return String.format("Pedido despachado por %s. Costo de envío: %.2f. Tiempo estimado de entrega: %d días.",
                pedido,getIdPedido(),nombre, tiempoEntrega);
    }

    @Override
    public String toString() {
        return "Transportadora{" +
                nombre + '\'' +
                ", costoEnvio=" + String.format("%.2f", costoEnvio) +
                "\n" + "Tiempo de entrega: " + tiempoEntrega + " días\n" +
                "Estado de envío: " + estadoEnvio +
                '}';
                
        }   
    }
}
        
