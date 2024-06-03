package productos.lacteos;

import productos.Producto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Leche extends Producto {
    public Leche(int precio, double litros) {
        this.precioBase = precio;
        this.peso = litros;
        this.fechaEnvase = LocalDate.now();
        this.fechaVencimiento = fechaEnvase.plusDays(7);
    }
    public void imprimirInformacion() {
        // TODO Hacer table con printf
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("ID: " + numeroUnico);
                System.out.println("Precio: " + precioBase + "$");
                System.out.println("Peso: " + peso + "L");
                System.out.println("Envasado el: " + fechaEnvase.format(formatoFecha));
                System.out.println("Fecha de vencimiento: " + fechaVencimiento.format(formatoFecha));
    }
}
