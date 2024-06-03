package productos.lacteos;

import productos.Producto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Leche extends Producto {
    public Leche(int precio, double litros) {
        this.numeroUnico = UUID.randomUUID();
        this.precioBase = precio;
        this.peso = litros;
        this.fechaEnvase = LocalDate.now();
        this.fechaVencimiento = fechaEnvase.plusDays(7);
    }
    public String toString() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ("ID: " + numeroUnico + "\n" +
                "Precio: " + precioBase + "$" + "\n" +
                "Peso: " + peso + "L" + "\n" +
                "Envasado el: " + fechaEnvase.format(formatoFecha) + "\n" +
                "Fecha de vencimiento: " + fechaVencimiento.format(formatoFecha) + "\n"

        );
    }
}
