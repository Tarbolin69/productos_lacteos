import productos.Producto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class Impresor {
    public void imprimirProductos(List<Producto> productos) {
        System.out.printf("%-36s | %-7s | %-7s | %-10s | %-10s |%n", "ID", "Precio", "Peso", "Envase", "Expiración", "Expiración");
        System.out.println("=".repeat(84));
        productos.forEach(Impresor::imprimirInformacion);
    }

    public static void imprimirInformacion(Producto producto) {
        UUID numeroUnico = producto.getNumeroUnico();
        int precioBase = producto.getPrecioBase();
        double masaEspacial = producto.getMasaEspacial();
        LocalDate fechaEnvase = producto.getFechaEnvase();
        int diasHabiles = producto.getDiasHabiles();
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-36s | %-7s | %-7s | %-10s | %-10s |%n", numeroUnico, precioBase + "$", masaEspacial + "L", fechaEnvase, producto.getFechaVencimiento(diasHabiles));
    }
}
