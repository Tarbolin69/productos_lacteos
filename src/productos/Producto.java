package productos;

import java.time.LocalDate;
import java.util.UUID;

// Quiza armar una clase llamada "Stock" que sea solo una lista de Producto, para poder hacer
// operaciones sobre todos los productos, como e print tabla
public abstract class Producto {
    protected String nombre;
    protected UUID numeroUnico = UUID.randomUUID();
    protected int precioBase;
    protected Double masaEspacial;
    protected LocalDate fechaEnvase;
    protected int diasHabiles;

    public LocalDate getFechaVencimiento(int diasHasta) {
        return fechaEnvase.plusDays(diasHasta);
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public UUID getNumeroUnico() {
        return numeroUnico;
    }

    public Double getMasaEspacial() {
        return masaEspacial;
    }

    public LocalDate getFechaEnvase() {
        return fechaEnvase;
    }

    public int getDiasHabiles() {
        return diasHabiles;
    }

    public String getNombre() {
        return nombre;
    }
}
