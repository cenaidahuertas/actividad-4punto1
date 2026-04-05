import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalogo {
    private List<Producto> productos;

    public Catalogo() {
        this.productos = new ArrayList<>();
    }

# - Getters y Setters -------------
    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> valor) {
        if (valor == null) {
            throw new IllegalArgumentException("La lista de productos no puede ser nula");
        }
        this.productos = new ArrayList<>(valor);
    }

# - metodos --------------
    public Producto bucarProducto(String codigo) {
        return productos.stream()
                .filter(p -> p.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public List<Producto> filtrar(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede ser nula o vacía");
        }
        return productos.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        if (productos.isEmpty()) 
        return "El catálogo está vacío";
        StringBuilder sb = new StringBuilder("Catálogo de productos:\n");
        for (Producto p : productos) {
            sb.append(String.format("- %s (codigo: %s, precio: %.2f)\n", p.getNombre(), p.getCodigo(), p.getPrecio()));
        }
        return sb.toString();
    }
}

