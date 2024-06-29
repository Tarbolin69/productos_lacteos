package productos;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto {
    private final int diasHabiles;

    public ProductoPerecedero(String nombre, int precioBase, int cantidad, double masaEspacial, int diasHabiles, String medidaPeso) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cantidad = cantidad;
        this.masaEspacial = masaEspacial;
        this.diasHabiles = diasHabiles;
        this.medidaPeso = medidaPeso;
    }

    public LocalDate getFechaVencimiento() {
        return fechaEnvase.plusDays(diasHabiles);
    }

    public int getDiasHabiles() {
        return diasHabiles;
    }
}
