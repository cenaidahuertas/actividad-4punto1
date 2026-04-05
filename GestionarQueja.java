public class GestionarQueja extends Queja {

    public GestionarQueja(String id, String cliente, String descripcion) {
        super(id, cliente, descripcion);
    }

    public void recibirQueja(Queja queja) {
        System.out.println("Queja recibida del cliente: " + queja.getCliente());
        System.out.println("Descripcion: " + queja.getDescripcion());
    }

    public void notificarGerente(Queja queja) {
        System.out.println("Notificando al gerente sobre queja ID: " + queja.getId());
        System.out.println("Descripcion: " + queja.getDescripcion());
    }
}
