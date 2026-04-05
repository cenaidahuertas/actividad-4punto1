public class Cliente {

    private String nombre;
    private String email;
    private String direccion;

    public Cliente(String nombre, String email, String direccion) {
        setNombre(nombre);
        setEmail(email);
        setDireccion(direccion);
    }

    // - Getters y Setters -------------
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        nombre = valor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String valor) {
        valor = valor.trim().toLowerCase();
        String[] partes = valor.split("@");
        if (partes.length != 2 || partes[1].contains(" . ")) 
            throw new IllegalArgumentException("El email no es válido" + valor + " '");
            this.email = valor;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede estar vacía");
        }
        this.direccion = valor;
    }

 // - metodos --------------

    public void verCatalogo(Catalogo catalogo) {
        System.out.println("Catálogo de productos:");
        for (Producto p : catalogo.getProductos()) {
            System.out.printf("codigo: %s | Nombre: %s | Precio: %.2f | Stock: %d%n",
                    p.getCodigo(), p.getNombre(), p.getPrecio(), p.getCantidadDisponible());
        System.out.println("Descripción: " + p.getDescripcion());
        }
    }

    public Carrito crearCarrito() {
        return new Carrito();
    }

    public void verPedido (Carrito carrito) {
        System.out.println("Pedido del cliente:");
        if (carrito.getProductosSeleccionados().isEmpty()) {
            System.out.println("El carrito está vacío");
            return;
        }
        for (Producto p : carrito.getProductosSeleccionados()) {
            System.out.printf("Codigo: %s | Nombre: %s | Precio: %.2f%n",
                    p.getCodigo(), p.getNombre(), p.getPrecio());
        }
    }

    public String presentarQueja(String mensaje) {
        mensaje = mensaje.trim();
        if (mensaje.isEmpty()) {
            throw new IllegalArgumentException("El mensaje de queja no puede estar vacío");
        }
        return "Queja presentada: " + 
                "Cliente: " + nombre + "\n" 
                + "Email: " + email + "\n"
                + "Mensaje: " + mensaje;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}



