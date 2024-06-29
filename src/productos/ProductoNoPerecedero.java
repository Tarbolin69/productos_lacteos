package productos;

import java.time.LocalDate;

public class ProductoNoPerecedero extends Producto {
    public ProductoNoPerecedero(String nombre, int precioBase, int cantidd, double masaEspacial, String medidaPeso) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cantidad = cantidd;
        this.masaEspacial = masaEspacial;
        this.medidaPeso = medidaPeso;
    }

    public LocalDate getFechaVencimiento() {
        return null;
    }
}
