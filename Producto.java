public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadDisponible;

    public Producto(string codigo, String nombre, String descripcion, double precio, int cantidadDisponible) {
        setCodigo(codigo);
        setNombre(nombre);
        setDescripcion(descripcion);
        setPrecio(precio);
        setCantidadDisponible(cantidadDisponible);
    }

    || Getters y Setters 

    public String getCodigo() {
        return codigo;
    }
    public void setcodigo(String valor) {
        valor=valor.trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío");
        }
        codigo = valor;
    }

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

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String valor) {
        valor = valor.trim();
        if (valor.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía");
        }
        descripcion = valor;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        precio = valor;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("La cantidad disponible no puede ser negativa");
        }
        cantidadDisponible = valor;
    }

    @Override
    public String toString() {
        return String.format("Producto[codigo=%s, nombre=%s, descripcion=%s, precio=%.2f, cantidadDisponible=%d]", 
            codigo, nombre, descripcion, precio, cantidadDisponible);
    }
}
