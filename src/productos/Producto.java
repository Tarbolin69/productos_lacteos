package productos;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Producto {
    protected String nombre;
    protected UUID numeroUnico = UUID.randomUUID();
    protected int precioBase;
    protected Double masaEspacial;
    protected LocalDate fechaEnvase;
    protected int diasHabiles;
    protected String medidaPeso;

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
