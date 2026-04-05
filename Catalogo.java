import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Producto> productos;

    public Catalogo(List<Producto> productos) {
        if (productos == null) throw new IllegalArgumentException("La lista no puede ser null.");
        this.productos = new ArrayList<>(productos);
    }

    public Catalogo() {
        this.productos = new ArrayList<>();
    }

    public List<Producto> getProductos() { return productos; }

    public void setProductos(List<Producto> valor) {
        if (valor == null) throw new IllegalArgumentException("La lista no puede ser null.");
        this.productos = new ArrayList<>(valor);
    }

    public Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) return p;
        }
        return null;
    }

    @Override
    public String toString() {
        if (productos.isEmpty()) return "El catalogo esta vacio.";
        StringBuilder sb = new StringBuilder("Catalogo de Productos:\n");
        for (Producto p : productos) {
            sb.append(String.format("- %s (Codigo: %s, Precio: $%.2f)%n",
                p.getNombre(), p.getCodigo(), p.getPrecio()));
        }
        return sb.toString();
    }
}
