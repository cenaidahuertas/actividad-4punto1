public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadDisponible;

    public Producto(String codigo, String nombre, String descripcion, double precio, int cantidadDisponible) {
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCantidadDisponible(cantidadDisponible);
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) throw new IllegalArgumentException("El codigo no puede estar vacio.");
        this.codigo = valor;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacio.");
        this.nombre = valor;
    }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) throw new IllegalArgumentException("La descripcion no puede estar vacia.");
        this.descripcion = valor;
    }

    public double getPrecio() { return precio; }
    public void setPrecio(double valor) {
        if (valor <= 0) throw new IllegalArgumentException("El precio debe ser positivo.");
        this.precio = valor;
    }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int valor) {
        if (valor < 0) throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        this.cantidadDisponible = valor;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - $%.2f (Stock: %d)", codigo, nombre, precio, cantidadDisponible);
    }
}
