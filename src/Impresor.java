import productos.Producto;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class Impresor {
    public void imprimirProductos(List<Producto> productos) {
        System.out.printf("%-36s | %-5s | %-7s | %-7s | %-10s | %-10s |%n", "ID", "Tipo", "Precio", "Peso", "Envase", "Expiración");
        System.out.println("=".repeat(92));
        productos.forEach(Impresor::imprimirInformacion);
    }

    public static void imprimirInformacion(Producto producto) {
        DateTimeFormatter fechaFormateador = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String nombre = producto.getNombre();
        String medidaPeso = producto.getMedidaPeso();
        UUID numeroUnico = producto.getNumeroUnico();
        int precioBase = producto.getPrecioBase();
        double masaEspacial = producto.getMasaEspacial();
        int diasHabiles = producto.getDiasHabiles();
        String fechaEnvase = fechaFormateador.format(producto.getFechaEnvase());
        String fechaVence = fechaFormateador.format(producto.getFechaVencimiento());
        System.out.printf("%-36s | %-5s | %-7s | %-7s | %-10s | %-10s |%n", numeroUnico, nombre, precioBase + "$", masaEspacial + medidaPeso, fechaEnvase, fechaVence);
    }

    // private
}
