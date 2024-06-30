package exhibidores;

import productos.Producto;
import productos.Stock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.StringJoiner;

public class ExhibidorCLI implements Visualizable {
    static String formatoTabla = "%-3s | %-25s | %-8s | %-7s | %-10s | %-11s |%n";
    static String separador = "=".repeat(81);

    public void visualizar(Stock stock) {
        List<Producto> productos = stock.getProductos();
        List<String> encabezado = stock.getEncabezado();
        imprimirProductosVencidos(productos);
        System.out.printf(formatoTabla, encabezado.toArray());
        System.out.println(separador);
        for (Producto producto : productos) {
            int index = productos.indexOf(producto);
            imprimirInformacion(producto, index);
        }
        System.out.println(separador);
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
        StringJoiner vencidos = new StringJoiner(", ");
        System.out.print("Productos vencidos: ");
        for (Producto producto : productos) {
            if (producto.getFechaVencimiento() != null && !hoy.isBefore(producto.getFechaVencimiento())) {
                vencidos.add(String.valueOf(productos.indexOf(producto)));
            }
        }
        System.out.println(vencidos);
    }
}
