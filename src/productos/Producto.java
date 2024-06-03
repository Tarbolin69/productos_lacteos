package productos;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Producto {
    protected UUID numeroUnico;
    protected int precioBase;
    protected Double peso;
    protected LocalDate fechaEnvase;
    protected LocalDate fechaVencimiento;
}
