package productos.lacteos;

import productos.Producto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Leche extends Producto {
    public Leche(int precio, double litros) {
        this.precioBase = precio;
        this.peso = litros;
        this.fechaEnvase = LocalDate.now();
        // TODO Avisar cuando expira.
        this.fechaVencimiento = fechaEnvase.plusDays(7);
    }

    // El metodo este va a haber que moverlo a algun otro lado para usarlo con todos los objetos
    public void imprimirInformacion() {
        // TODO Hacer table con printf
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-36s | %-7s | %-7s | %-10s | %-10s |%n", "ID", "Precio", "Peso", "Envase", "Expiración");
        System.out.println("=".repeat(84));
        System.out.printf("%-36s | %-7s | %-7s | %-10s | %-10s |%n", numeroUnico, precioBase + "$", peso + "L", fechaEnvase, fechaVencimiento);
    }
}
