import java.time.LocalDate;

public class Pedido {
    private String idPedido;
    private Cliente cliente;
    private double total;
    private EstadoPedido estado;
    private LocalDate fecha;

    public Pedido(String idPedido, Cliente cliente, double total, EstadoPedido estado) {
        setIdPedido(idPedido);
        setCliente(cliente);
        setTotal(total);
        setEstado(estado);
        this.fecha = LocalDate.now();
    }

    public String getIdPedido() { return idPedido; }
    public void setIdPedido(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) throw new IllegalArgumentException("El ID no puede estar vacio.");
        this.idPedido = valor;
    }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente valor) {
        if (valor == null) throw new IllegalArgumentException("El cliente no puede ser null.");
        this.cliente = valor;
    }

    public double getTotal() { return total; }
    public void setTotal(double valor) {
        if (valor < 0) throw new IllegalArgumentException("El total no puede ser negativo.");
        this.total = valor;
    }

    public EstadoPedido getEstado() { return estado; }
    public void setEstado(EstadoPedido valor) {
        if (valor == null) throw new IllegalArgumentException("El estado no puede ser null.");
        this.estado = valor;
    }

    public LocalDate getFecha() { return fecha; }

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        if (nuevoEstado == null) throw new IllegalArgumentException("Estado null.");
        this.estado = nuevoEstado;
    }

    public boolean cancelar() {
        if (estado == EstadoPedido.PENDIENTE || estado == EstadoPedido.CONFIRMADO) {
            this.estado = EstadoPedido.CANCELADO;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pedido ID : " + idPedido +
            "\nCliente   : " + cliente.getNombre() +
            "\nTotal     : $" + String.format("%.2f", total) +
            "\nEstado    : " + estado +
            "\nFecha     : " + fecha;
    }
}
