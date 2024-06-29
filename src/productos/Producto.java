package productos;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Producto {
    protected String nombre;
    protected UUID numeroUnico = UUID.randomUUID();
    protected int precioBase;
    protected int cantidad;
    protected Double masaEspacial;
    protected LocalDate fechaEnvase = LocalDate.now();
    protected String medidaPeso;

    public abstract LocalDate getFechaVencimiento();

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

    public String getNombre() {
        return nombre;
    }

    public String getMedidaPeso() {
        return medidaPeso;
    }

    public int getCantidad() {
        return cantidad;
    }
}
