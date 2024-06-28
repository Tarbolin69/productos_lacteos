package productos.lacteos;

import productos.Producto;

import java.time.LocalDate;

public class Queso extends Producto {
    public Queso(int precio, double kilos) {
        this.nombre = "Queso";
        this.medidaPeso = "K";
        this.precioBase = precio;
        this.masaEspacial = kilos;
        this.fechaEnvase = LocalDate.now();
    }
}
