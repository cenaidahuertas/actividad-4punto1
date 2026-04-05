public class Envio {

    private Pedido pedido;
    private Transportadora empresaTransportadora;
    private EstadoPedido estado;

    public Envio(Pedido pedido, Transportadora empresaTransportadora, EstadoPedido estado) {
        setPedido(pedido);
        setEmpresaTransportadora(empresaTransportadora);
        setEstado(estado);
    }

    public Envio(Pedido pedido, Transportadora empresaTransportadora, EstadoPedido estado) {
        this(pedido, empresaTransportadora, EstadoPedido.PENDIENTE);
    }

    // - Getters y Setters --------------

    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        this.pedido = valor;
    }

    public Transportadora getEmpresaTransportadora() {
        return empresaTransportadora;
    }
    public void setEmpresaTransportadora(Transportadora valor) {
        if (valor == null) {
            throw new IllegalArgumentException("La empresa transportadora no puede ser nula.");
        }
        this.empresaTransportadora = valor;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El estado del envío no puede ser nulo.");
        }
        this.estado = valor;
    }

    # - metodos -----------------

    public boolean despachar() {
        if (estado == EstadoPedido.PENDIENTE) {
            estado = EstadoPedido.EN_TRANSITO;
            return true;
        }
        return false;
    }

    public boolean entregar() {
        if (estado == EstadoPedido.EN_TRANSITO) {
            estado = EstadoPedido.ENTREGADO;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Envio del pedido ID " + pedido.getIdpedido() + "\n"
                + "Transportadora: " + empresaTransportadora.getNombre() + "\n"
                + "Estado del envío: " + estado;
    }
}

