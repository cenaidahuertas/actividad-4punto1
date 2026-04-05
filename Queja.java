public class Queja {

    private String idQueja;
    private Cliente cliente;
    private String descripcion;
    private String estado;

    public Queja(String idQueja, Cliente cliente, String descripcion) {
        this.idQueja = idQueja;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.estado = "Registrada";
    }

   //- Getters y Setters -------------

    public String getIdQueja() {
        return idQueja;
    }

    public void setIdQueja(String idQueja) {
        this.idQueja = idQueja;
    }

    public Cliente getCliente() {
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


   // - metodos --------------

    public void resolverQueja() {
        System.out.println("Queja resuelta para el cliente: " + cliente.getNombre() + ": " + descripcion);
    }

    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
        System.out.println("Estado de la queja actualizado a: " + nuevoEstado);
    }

    @Override
    public String toString() {
        return String.format("Queja ID: %s | Cliente: %s | Descripción: %s | Estado: %s",
                idQueja, cliente.getNombre(), descripcion, estado);
    }   
}
