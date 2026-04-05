import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        // 1. catalogo
        Catalogo catalogo = crearCatalogo();

        // 2. cliente 
        Cliente cliente = registrarCliente();

        // 3. carrito
        Carrito carrito = llenarCarrito(cliente, catalogo);

        if (carrito.getProductoSeleccionados().isEmpty()) {
            System.out.println("\n El carrito está vacío.");
            return;
        }
        System.out.println("\n" + carrito);

        // 4. pago

        Pago pago = realizarPago(carrito.getTotal());
        if (pago == null) {
            return;
        }

        // 5. pedido
        Pedido pedido = new Pedido("PED001", cliente, carrito.getTotal(), EstadoPedido.CONFIRMADO);
        pedido.cambiarEstado(EstadoPedido.EN_PROCESO);

        // 6. transportadora y envio 
        Transportadora transportadora = new Transportadora("Envios Colombia";15000,3);
        Envio envio = new Envio(pedido, transportadora, EstadoPedido.PENDIENTE);
        envio.despachar();

        // 7. mostrar resumen
        System.out.println("\nResumen del pedido:");
        System.out.println(cliente);
        System.out.println("\nTotal pedido: " + formatearCOP(pedido.getTotal()));
        System.out.println("Estado del pedido: " + pedido.getEstado());
        System.out.println(envio);
        System.out.println("Estado del envío: " + formatearCOP(transportadora.getCostoEnvio()));
        System.out.println("Tiempo de entrega: " + transportadora.getTiempoEntrega() + " días");

    }

        // 8. Queja 
        
        registarQueja(cliente, pedido);
        scanner.close();
        
        // - Helpers ------------------

        static String formatearCOP(double valor) {
            return NumberFormat.getCurrencyInstance(new Locale("es", "CO")).format(valor);
        }

        static Catalogo crearCatalogo() {
        return new Catalogo(Arrays.asList(
            new Producto("P001", "Laptop",   "Portátil para análisis de datos",  3500000, 5),
            new Producto("P002", "Mouse",    "Mouse ergonómico inalámbrico",       250000, 10),
            new Producto("P003", "Teclado",  "Teclado mecánico",                   346500, 8),
            new Producto("P004", "Monitor",  "Monitor Full HD de 24 pulgadas",     900000, 4)
        ));
    }

        static Cliente registrarCliente() {
        System.out.println("\n=== Registro de Cliente ===");
        System.out.print("Nombre   : "); String nombre    = scanner.nextLine().trim();
        System.out.print("Correo   : "); String correo    = scanner.nextLine().trim();
        System.out.print("Dirección: "); String direccion = scanner.nextLine().trim();
        return new Cliente(nombre, correo, direccion);
    }

    static Carrito llenarCarrito(Cliente cliente, Catalogo catalogo) {
        Carrito carrito = cliente.crearCarrito();
        while (true) {
            cliente.verCatalogo(catalogo);
            System.out.print("\nCódigo del producto (o FIN para terminar): ");
            String codigo = scanner.nextLine().toUpperCase().trim();
            if (codigo.equals("FIN")) break;

            Producto producto = catalogo.buscarProducto(codigo);
            if (producto == null) { System.out.println("✗ Producto no encontrado."); continue; }

            try {
                System.out.print("Cantidad: ");
                int cantidad = Integer.parseInt(scanner.nextLine().trim());
                if (carrito.agregarProducto(producto, cantidad)) {
                    System.out.println("✓ Producto agregado.");
                } else {
                    System.out.println("✗ Stock insuficiente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return carrito;
    }

    static Pago realizarPago(double total) {
        System.out.println("\n=== Información de Pago ===");
        while (true) {
            System.out.print("Número de tarjeta (16 dígitos): "); String numero = scanner.nextLine().trim();
            System.out.print("Fecha de vencimiento (MM/AA)  : "); String fecha  = scanner.nextLine().trim();
            System.out.print("CVV (3 dígitos)               : "); String cvv    = scanner.nextLine().trim();
            try {
                PagoTarjeta pago = new PagoTarjeta(numero, fecha, cvv);
                if (pago.procesarPago(total)) {
                    System.out.println("✓ Pago procesado exitosamente.");
                    return pago;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Intente nuevamente.");
            }
        }
    }

    static void registrarQueja(Cliente cliente) {
        System.out.print("\n¿Desea registrar una queja? (si/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("si")) {
            System.out.print("Escriba su queja: ");
            String descripcion = scanner.nextLine().trim();
            Queja queja = new Queja("Q001", cliente.getNombre(), descripcion);
            queja.registrarQueja();
            System.out.println(cliente.presentarQueja(queja.getDescripcion()));
        }
    }
}
