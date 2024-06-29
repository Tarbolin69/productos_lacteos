package productos;

import java.time.LocalDate;

public class ProductoNoPerecedero extends Producto {
    public ProductoNoPerecedero(String nombre, int precioBase, int unidades) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.unidades = unidades;
    }

    public ProductoNoPerecedero(String nombre, int precioBase, int unidades, LocalDate envase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.unidades = unidades;
        this.fechaEnvase = envase;
    }

    public LocalDate getFechaVencimiento() {
        return null;
    }
}
