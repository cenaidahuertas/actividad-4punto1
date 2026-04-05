import java.time.localDate;

public class Pedido {

    private String idPedido;
    private Cliente cliente;
    private double total;
    private EstadoPedido estado;
    private LocalDate fecha;

    public Pedido(String idPedido, Cliente cliente, double total, EstadoPedido estado, LocalDate fecha) {
        setIdPedido(idPedido);
        setCliente(cliente);
        setTotal(total);
        setEstado(estado);
        this.fecha = (fecha != null) ? fecha : LocalDate.now();
    }

    public Pedido (String idPedido, Cliente cliente, double total, EstadoPedido estado) {
        this(idPedido, cliente, total, estado, LocalDate.now());
    }

     // - Getters y Setters -------------

    public String getIdPedido() {
        return idPedido;
    }
    public void setIdPedido(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El ID del pedido no puede estar vacío.");
        }
        this.idPedido = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo.");
        }
        this.cliente = valor;
    }

    public double getTotal() {
        return total;
    }
    public void setTotal(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El total no puede ser negativo.");
        }
        this.total = valor;
    }

    public EstadoPedido getEstado() {
        return estado;
    }
    public void setEstado(EstadoPedido valor) {
        if (valor == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo.");
        }
        this.estado = valor;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate valor) {
        this.fecha = (valor != null) ? valor : LocalDate.now();
    }

     //- Metodos -------------

    public void cambiarEstado(EstadoPedido nuevoEstado) {
        if (nuevoEstado == null) {
            throw new IllegalArgumentException("El nuevo estado no puede ser nulo.");
        }
        setEstado(nuevoEstado);
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
        return "Pedido{" +
                "idPedido='" + idPedido + '\'' +
                ", cliente=" + cliente +
                ", total=" + total +
                ", estado=" + estado +
                ", fecha=" + fecha +
                '}';
    }
}


