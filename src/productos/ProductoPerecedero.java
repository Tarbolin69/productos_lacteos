package productos;

import java.time.LocalDate;

public class ProductoPerecedero extends Producto {
    private int diasHabiles;

    public ProductoPerecedero(String nombre, int precioBase, int unidades, int diasHabiles) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.unidades = unidades;
        this.diasHabiles = diasHabiles;
    }

    public ProductoPerecedero(String nombre, int precioBase, int unidades, LocalDate envase, LocalDate vencimiento) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.unidades = unidades;
        this.fechaEnvase = envase;
        this.fechaVencimiento = vencimiento;
    }

    public LocalDate getFechaVencimiento() {
        return fechaEnvase.plusDays(diasHabiles);
    }
}
