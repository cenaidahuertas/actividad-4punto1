import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<Producto> productosSeleccionados;
    private double total;

    public Carrito() {
        this.productosSeleccionados = new ArrayList<>();
        this.total = 0.0;
    }

 // - Getters -------------
    public List<Producto> getProductosSeleccionados() {
        return productosSeleccionados;
    }

    public double getTotal() {
        return total;
    }

   // - Metodos -------------
    public void calcularTotal() {
        total = productosSeleccionados.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
    }

    public boolean agregarProducto(Producto producto, int cantidad) {
        if (producto == null) 
            throw new IllegalArgumentException("El producto no puede ser nulo");

        if (cantidad <= 0) 
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        if (producto.getcantidadDisponible() < cantidad) 
        return false;

        for (int i = 0; i < cantidad; i++) {
            productosSeleccionados.add(producto);
        }
        producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
        calcularTotal();
        return true;

    public boolean eliminarProducto(Producto producto, int cantidad) {
        if (producto == null) 
            throw new IllegalArgumentException("El producto no puede ser nulo");

        if (cantidad <= 0) 
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        
        int eliminados = 0;
        for (int i = 0; i < cantidad; i++) {
            if (productosSeleccionados.remove(producto)) {
                eliminados++;
            } else {
                break; // No hay más productos para eliminar
            }
        }
        producto.setCantidadDisponible(producto.getCantidadDisponible() + eliminados);
        calcularTotal();
        return eliminados > 0;
    }

    public boolean confirmarPedido() {
        return !productosSeleccionados.isEmpty();
    }

    @Override
    public String toString() {
        if (productosSeleccionados.isEmpty())
            return "El carrito está vacío";
        StringBuilder sb = new StringBuilder("productos seleccionados:\n");
        for (Producto producto : productosSeleccionados) {
            sb.append(String.format("- %s ($%.2f)%n", producto.getNombre(), producto.getPrecio()));
        }
        sb.append(String.format("Total: $%.2f%n", total));
        return sb.toString(); 
        }
    }
}
        
            

        