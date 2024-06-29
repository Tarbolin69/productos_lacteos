package productos.lacteos;

import productos.Producto;

import java.time.LocalDate;
import java.util.Scanner;

public class Leche extends Producto {
    private boolean esPasteurizada;

    // Para leer de CSV
    public Leche(int precio, double litros, LocalDate fechaEnvase) {
        this.nombre = "Leche";
        this.medidaPeso = "L";
        this.precioBase = precio;
        this.masaEspacial = litros;
        this.esPasteurizada = true;
        this.fechaEnvase = fechaEnvase;
        this.diasHabiles = 7;
    }

    // Para ingreso manual en Main.java
    public Leche(int precio, double litros, boolean pasteurizada) {
        this.nombre = "Leche";
        this.medidaPeso = "L";
        this.precioBase = precio;
        this.masaEspacial = litros;
        this.esPasteurizada = pasteurizada;
        this.fechaEnvase = LocalDate.now();
        this.diasHabiles = 7;
    }

    public boolean isEsPasteurizada() {
        return esPasteurizada;
    }
}
