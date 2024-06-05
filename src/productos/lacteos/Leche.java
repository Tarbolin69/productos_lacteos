package productos.lacteos;

import productos.Producto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Leche extends Producto {
    private boolean esPasteurizada;

    public Leche(int precio, double litros, boolean pasteurizada) {
        this.precioBase = precio;
        this.peso = litros;
        this.esPasteurizada = pasteurizada;
        this.fechaEnvase = LocalDate.now();
        // TODO Avisar cuando expira.
        this.fechaVencimiento = fechaEnvase.plusDays(7);
    }

    // El metodo este va a haber que moverlo a algun otro lado para usarlo con todos los objetos
    public void imprimirInformacion() {
        // TODO Hacer table con printf
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("%-36s | %-7s | %-7s | %-10s | %-10s | %-13s |%n", "ID", "Precio", "Peso", "Envase", "Expiración", "Pasteurizada");
        System.out.println("=".repeat(100));
        System.out.printf("%-36s | %-7s | %-7s | %-10s | %-10s | %-13s |%n", numeroUnico, precioBase + "$", peso + "L", fechaEnvase, fechaVencimiento, esPasteurizada);
    }
}
