package productos;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Producto {
    protected UUID numeroUnico = UUID.randomUUID();
    protected int precioBase;
    protected Double peso;
    protected LocalDate fechaEnvase;
    protected LocalDate fechaVencimiento;

    public abstract void imprimirInformacion();
}
