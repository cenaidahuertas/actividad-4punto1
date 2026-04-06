/**
 * Clase especializada para gestionar las quejas de clientes.
 * Extiende Queja y proporciona funcionalidades adicionales de gestión.
 */
public class GestionarQueja extends Queja {

    public GestionarQueja(String id, String cliente, String descripcion) {
        super(id, cliente, descripcion);
    }

    /**
     * Recibe una queja del cliente y la registra en el sistema.
     *
     * @param queja la queja a recibir
     */
    public void recibirQueja(Queja queja) {
        System.out.println("Queja recibida del cliente: " + queja.getCliente());
        System.out.println("Descripcion: " + queja.getDescripcion());
    }

    /**
     * Notifica al gerente sobre una queja registrada.
     *
     * @param queja la queja a notificar
     */
    public void notificarGerente(Queja queja) {
        System.out.println("Notificando al gerente sobre queja ID: " + queja.getId());
        System.out.println("Descripcion: " + queja.getDescripcion());
    }
}
