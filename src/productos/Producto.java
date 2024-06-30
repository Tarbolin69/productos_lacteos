package productos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Producto {
    protected String nombre;
    protected int precioBase;
    protected int unidades;
    protected LocalDate fechaEnvase = LocalDate.now();
    protected LocalDate fechaVencimiento = getFechaVencimiento();

    public String[] productoString() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyy");
        return new String[]{nombre, String.valueOf(unidades), String.valueOf(precioBase), formatoFecha.format(fechaEnvase), (fechaVencimiento != null ? formatoFecha.format(fechaVencimiento) : "N/A")};
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

    public void agregarUnidades(int cantidad) {
        this.unidades += unidades;
    }
    public void removerUnidades(int cantidad) {
        this.unidades -= unidades;
    }
}
