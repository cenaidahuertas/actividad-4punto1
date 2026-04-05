public class Envio {
    private Pedido pedido;
    private Transportadora empresaTransportadora;
    private EstadoPedido estado;

    public Envio(Pedido pedido, Transportadora empresaTransportadora, EstadoPedido estado) {
        setPedido(pedido);
        setEmpresaTransportadora(empresaTransportadora);
        setEstado(estado);
    }

    public Pedido getPedido() { return pedido; }
    public void setPedido(Pedido valor) {
        if (valor == null) throw new IllegalArgumentException("El pedido no puede ser null.");
        this.pedido = valor;
    }

    public Transportadora getEmpresaTransportadora() { return empresaTransportadora; }
    public void setEmpresaTransportadora(Transportadora valor) {
        if (valor == null) throw new IllegalArgumentException("La transportadora no puede ser null.");
        this.empresaTransportadora = valor;
    }

    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido valor) {
        if (valor == null) throw new IllegalArgumentException("El estado no puede ser null.");
        this.estado = valor;
    }

    public boolean despachar() {
        if (estado == EstadoPedido.PENDIENTE) {
            estado = EstadoPedido.DESPACHADO;
            return true;
        }
        return false;
    }

    public boolean entregar() {
        if (estado == EstadoPedido.DESPACHADO) {
            estado = EstadoPedido.ENTREGADO;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Envio del Pedido ID: " + pedido.getIdPedido() +
               "\nEmpresa: " + empresaTransportadora.getNombre() +
               "\nEstado: " + estado;
    }
}
