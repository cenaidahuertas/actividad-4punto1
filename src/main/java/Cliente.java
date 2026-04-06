/**
 * Representa un cliente del sistema de e-commerce.
 * Gestiona la información personal del cliente y sus interacciones
 * con el catálogo y carrito de compras.
 */
public class Cliente {
    private String nombre;
    private String correo;
    private String direccion;

    public Cliente(String nombre, String correo, String direccion) {
        setNombre(nombre);
        setCorreo(correo);
        setDireccion(direccion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio.");
        }
        this.nombre = valor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String valor) {
        valor = valor.trim().toLowerCase();
        String[] partes = valor.split("@");
        if (partes.length != 2 || !partes[1].contains(".")) {
            throw new IllegalArgumentException("Correo invalido: " + valor);
        }
        this.correo = valor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("La direccion no puede estar vacia.");
        }
        this.direccion = valor;
    }

    /**
     * Muestra el catálogo de productos disponibles.
     *
     * @param catalogo el catálogo a mostrar
     */
    public void mostrarCatalogo(Catalogo catalogo) {
        System.out.println("CATALOGO DE PRODUCTOS");
        for (Producto p : catalogo.getProductos()) {
            System.out.printf("Codigo: %s | Nombre: %s | Precio: $%.2f | Stock: %d%n",
                p.getCodigo(), p.getNombre(), p.getPrecio(), p.getCantidadDisponible());
            System.out.println("Descripcion: " + p.getDescripcion());
        }
    }

    /**
     * Crea un nuevo carrito de compras para este cliente.
     *
     * @return un nuevo carrito vacío
     */
    public Carrito crearCarrito() {
        return new Carrito();
    }

    /**
     * Presenta una queja del cliente.
     *
     * @param mensaje el contenido de la queja
     * @return un string con la queja formateada
     */
    public String presentarQueja(String mensaje) {
        mensaje = mensaje.trim();
        if (mensaje.isEmpty()) {
            throw new IllegalArgumentException("La queja no puede estar vacia.");
        }
        return "Queja registrada\nCliente : " + nombre + "\nCorreo  : " + correo
            + "\nMensaje : " + mensaje;
    }

    @Override
    public String toString() {
        return "Nombre   : " + nombre + "\nCorreo   : " + correo
            + "\nDireccion: " + direccion;
    }
}
