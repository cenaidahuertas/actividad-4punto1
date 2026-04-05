import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Catalogo catalogo = crearCatalogo();
        Cliente cliente = registrarCliente();
        Carrito carrito = llenarCarrito(cliente, catalogo);

        if (carrito.getProductosSeleccionados().isEmpty()) {
            System.out.println("\nCarrito vacio. No se realizo el pedido.");
            scanner.close();
            return;
        }

        System.out.println("\n" + carrito);

        Pago pago = realizarPago(carrito.getTotal());
        if (pago == null) { scanner.close(); return; }

        Pedido pedido = new Pedido("PED001", cliente, carrito.getTotal(), EstadoPedido.CONFIRMADO);
        Transportadora transportadora = new Transportadora("Envios Colombia", 15000, 3);
        Envio envio = new Envio(pedido, transportadora, EstadoPedido.PENDIENTE);
        envio.despachar();

        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println(cliente);
        System.out.printf("Total pedido   : $%.2f%n", pedido.getTotal());
        System.out.println("Estado pedido  : " + pedido.getEstado());
        System.out.println(envio);
        System.out.printf("Costo de envio : $%.2f%n", transportadora.getCostoEnvio());
        System.out.println("Tiempo entrega : " + transportadora.getTiempoEntrega() + " dias");
        registrarQueja(cliente);
        scanner.close();
    }

    static Catalogo crearCatalogo() {
        return new Catalogo(Arrays.asList(
            new Producto("P001", "Laptop",  "Portatil para analisis de datos", 3500000, 5),
            new Producto("P002", "Mouse",   "Mouse ergonomico inalambrico",      250000, 10),
            new Producto("P003", "Teclado", "Teclado mecanico",                  346500,  8),
            new Producto("P004", "Monitor", "Monitor Full HD de 24 pulgadas",    900000,  4)
        ));
    }

    static Cliente registrarCliente() {
        System.out.println("\n=== Registro de Cliente ===");
        System.out.print("Nombre   : ");
        String nombre = scanner.nextLine().trim();
        System.out.print("Correo   : ");
        String correo = scanner.nextLine().trim();
        System.out.print("Direccion: ");
        String direccion = scanner.nextLine().trim();
        return new Cliente(nombre, correo, direccion);
    }

    static Carrito llenarCarrito(Cliente cliente, Catalogo catalogo) {
        Carrito carrito = cliente.crearCarrito();
        while (true) {
            cliente.verCatalogo(catalogo);
            System.out.print("\nCodigo del producto (o FIN para terminar): ");
            String codigo = scanner.nextLine().toUpperCase().trim();
            if (codigo.equals("FIN")) break;
            Producto producto = catalogo.buscarProducto(codigo);
            if (producto == null) { System.out.println("Producto no encontrado."); continue; }
            try {
                System.out.print("Cantidad: ");
                int cantidad = Integer.parseInt(scanner.nextLine().trim());
                if (carrito.agregarProducto(producto, cantidad)) {
                    System.out.println("Producto agregado.");
                } else {
                    System.out.println("Stock insuficiente.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return carrito;
    }

    static Pago realizarPago(double total) {
        System.out.println("\n=== Informacion de Pago ===");
        while (true) {
            System.out.print("Numero de tarjeta (16 digitos): ");
            String numero = scanner.nextLine().trim();
            System.out.print("Fecha de vencimiento (MM/AA)  : ");
            String fecha = scanner.nextLine().trim();
            System.out.print("CVV (3 digitos)               : ");
            String cvv = scanner.nextLine().trim();
            try {
                PagoTarjeta pago = new PagoTarjeta(numero, fecha, cvv);
                if (pago.procesarPago(total)) {
                    System.out.println("Pago procesado exitosamente.");
                    return pago;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Intente nuevamente.");
            }
        }
    }

    static void registrarQueja(Cliente cliente) {
        System.out.print("\nDesea registrar una queja? (si/no): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("si")) {
            System.out.print("Escriba su queja: ");
            String descripcion = scanner.nextLine().trim();
            Queja queja = new Queja("Q001", cliente.getNombre(), descripcion);
            queja.registrarQueja();
            System.out.println(cliente.presentarQueja(queja.getDescripcion()));
        }
    }
}
