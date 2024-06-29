package productos;

import java.time.LocalDate;

public abstract class Producto {
    protected String nombre;
    protected int precioBase;
    protected int unidades;
    protected LocalDate fechaEnvase = LocalDate.now();
    protected LocalDate fechaVencimiento = getFechaVencimiento();

    public String productoLinea() {
        return nombre + ";" + unidades + ";" + precioBase + ";" + fechaEnvase + ";" + (fechaVencimiento != null ? fechaVencimiento : "N/A");
    }

    public abstract LocalDate getFechaVencimiento();

    public int getPrecioBase() {
        return precioBase;
    }

    public LocalDate getFechaEnvase() {
        return fechaEnvase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getUnidades() {
        return unidades;
    }
}
