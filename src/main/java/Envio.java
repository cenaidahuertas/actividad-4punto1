/**
 * Representa el envío de un pedido.
 * Gestiona la relación entre un pedido y una transportadora,
 * así como el estado del envío.
 */
public class Envio {
    private Pedido pedido;
    private Transportadora empresaTransportadora;
    private EstadoPedido estado;

    public Envio(Pedido pedido, Transportadora empresaTransportadora, EstadoPedido estado) {
        setPedido(pedido);
        setEmpresaTransportadora(empresaTransportadora);
        setEstado(estado);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El pedido no puede ser null.");
        }
        this.pedido = valor;
    }

    public Transportadora getEmpresaTransportadora() {
        return empresaTransportadora;
    }

    public void setEmpresaTransportadora(Transportadora valor) {
        if (valor == null) {
            throw new IllegalArgumentException("La transportadora no puede ser null.");
        }
        this.empresaTransportadora = valor;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El estado no puede ser null.");
        }
        this.estado = valor;
    }

    /**
     * Despacha el pedido si está en estado pendiente.
     *
     * @return true si se despachó exitosamente, false en caso contrario
     */
    public boolean despachar() {
        if (estado == EstadoPedido.PENDIENTE) {
            estado = EstadoPedido.DESPACHADO;
            return true;
        }
        return false;
    }

    /**
     * Marca el pedido como entregado si está despachado.
     *
     * @return true si se entregó exitosamente, false en caso contrario
     */
    public boolean entregar() {
        if (estado == EstadoPedido.DESPACHADO) {
            estado = EstadoPedido.ENTREGADO;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Envio del Pedido ID: " + pedido.getIdPedido() + "\nEmpresa: "
            + empresaTransportadora.getNombre() + "\nEstado: " + estado;
    }
}
