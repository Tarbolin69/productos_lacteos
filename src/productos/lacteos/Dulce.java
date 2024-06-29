package productos.lacteos;

import productos.Producto;
import java.time.LocalDate;
import java.util.Scanner;

public class Dulce extends Producto {
    private final int diasHabiles = 31;
    private final String UnidadPeso = "Kilogramos";

    public Dulce() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el precio:");
        this.precioBase = Integer.parseInt(scanner.nextLine());
        System.out.printf("Ingrese el peso/volumen (%s): ", this.UnidadPeso);
        this.masaEspacial = Double.parseDouble(scanner.nextLine());
        scanner.close();
    }

    public Dulce(int precio, double masa) {
        this.precioBase = precio;
        this.masaEspacial = masa;
        this.fechaEnvase = LocalDate.now();
        // TODO Avisar cuando expira.
    }
}

