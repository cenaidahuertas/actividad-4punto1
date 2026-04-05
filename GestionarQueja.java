public class GestionarQueja extends Queja {

    public GestionarQueja(String idQueja, Cliente cliente, String descripcion) {
        super(idQueja, cliente, descripcion);
    }

    # - metodos --------------

    public void recibirQueja(Queja queja) {
        System.out.println("Recibiendo queja del cliente: " + queja.getCliente().getNombre() + ": " + queja.getDescripcion());
    }

    public void notificarGerente(Queja queja) {
        System.out.println("Notificando al gerente sobre la queja del cliente: " + queja.getCliente().getNombre() + ": " + queja.getDescripcion());
    }
}
