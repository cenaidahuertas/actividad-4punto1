import java.util.ArrayList;
import java.util.List;

/**
 * Representa el carrito de compras de un cliente.
 * Gestiona los productos seleccionados y calcula el total de la compra.
 */
public class Carrito {
    private final List<Producto> productosSeleccionados;
    private double total;

    public Carrito() {
        this.productosSeleccionados = new ArrayList<>();
        this.total = 0.0;
    }

    public List<Producto> getProductosSeleccionados() {
        return new ArrayList<>(productosSeleccionados);
    }

    public double getTotal() {
        return total;
    }

    /**
     * Calcula el total del carrito sumando los precios de los productos.
     */
    private void calcularTotal() {
        double suma = 0;
        for (Producto p : productosSeleccionados) {
            suma += p.getPrecio();
        }
        this.total = suma;
    }

    /**
     * Agrega una cantidad específica de un producto al carrito.
     *
     * @param producto el producto a agregar
     * @param cantidad la cantidad de unidades
     * @return true si se agregó exitosamente, false si stock insuficiente
     */
    public boolean agregarProducto(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null.");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva.");
        }
        if (producto.getCantidadDisponible() < cantidad) {
            return false;
        }

        for (int i = 0; i < cantidad; i++) {
            productosSeleccionados.add(producto);
        }
        producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
        calcularTotal();
        return true;
    }

    /**
     * Elimina una cantidad específica de un producto del carrito.
     *
     * @param producto el producto a eliminar
     * @param cantidad la cantidad de unidades a eliminar
     * @return true si se eliminó al menos una unidad, false en caso contrario
     */
    public boolean eliminarProducto(Producto producto, int cantidad) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser null.");
        }
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva.");
        }

        int eliminados = 0;
        for (int i = 0; i < cantidad; i++) {
            if (productosSeleccionados.remove(producto)) {
                eliminados++;
            } else {
                break;
            }
        }
        producto.setCantidadDisponible(producto.getCantidadDisponible() + eliminados);
        calcularTotal();
        return eliminados > 0;
    }

    /**
     * Verifica si el carrito tiene productos.
     *
     * @return true si el carrito no está vacío
     */
    public boolean confirmarPedido() {
        return !productosSeleccionados.isEmpty();
    }

    @Override
    public String toString() {
        if (productosSeleccionados.isEmpty()) {
            return "El carrito esta vacio.";
        }
        StringBuilder sb = new StringBuilder("Productos seleccionados:\n");
        for (Producto p : productosSeleccionados) {
            sb.append(String.format("- %s ($%.2f)%n", p.getNombre(), p.getPrecio()));
        }
        sb.append(String.format("Total: $%.2f", total));
        return sb.toString();
    }
}
