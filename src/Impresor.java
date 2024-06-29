import productos.Producto;
import productos.Stock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Impresor {
    static String formatoTabla = "%-3s | %-20s | %-8s | %-7s | %-10s | %-11s |%n";

    public void imprimirProductos(Stock stock) {
        List<Producto> productos = stock.getProductos();
        List<String> encabezado = stock.getEncabezado();
        imprimirProductosVencidos(productos);
        System.out.printf(formatoTabla, encabezado.toArray());
        System.out.println("=".repeat(76));
        for (Producto producto : productos) {
            int index = productos.indexOf(producto);
            imprimirInformacion(producto, index);
        }
    }

    public static void imprimirInformacion(Producto producto, int index) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String nombre = producto.getNombre();
        int precioBase = producto.getPrecioBase();
        int unidades = producto.getUnidades();
        String fechaEnvase = formatoFecha.format(producto.getFechaEnvase());
        String fechaVence = producto.getFechaVencimiento() != null ? formatoFecha.format(producto.getFechaVencimiento()) : "N/A";
        System.out.printf(formatoTabla, index, nombre, unidades, precioBase + "$", fechaEnvase,fechaVence);
    }
    public void imprimirProductosVencidos(List<Producto> productos) {
        LocalDate hoy = LocalDate.now();
        for (Producto producto : productos) {
            if (producto.getFechaVencimiento() != null && !hoy.isBefore(producto.getFechaVencimiento())) {
                System.out.println("* " + productos.indexOf(producto) + " ha expirado.");
            }
        }
    }
}
