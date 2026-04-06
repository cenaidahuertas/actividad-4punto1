/**
 * Representa una queja registrada por un cliente.
 * Gestiona la información y el estado de la queja.
 */
public class Queja {
    private String id;
    private String cliente;
    private String descripcion;
    private String estado;

    public Queja(String id, String cliente, String descripcion) {
        this.id = id;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.estado = "REGISTRADA";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Registra la queja en el sistema.
     */
    public void registrarQueja() {
        System.out.println("Queja registrada por " + cliente + ": " + descripcion);
    }

    /**
     * Actualiza el estado de la queja.
     *
     * @param nuevoEstado el nuevo estado
     */
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    @Override
    public String toString() {
        return "Queja ID    : " + id + "\nCliente     : " + cliente
            + "\nDescripcion : " + descripcion + "\nEstado      : " + estado;
    }
}
