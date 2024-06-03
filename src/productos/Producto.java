package productos;

import java.time.LocalDate;
import java.util.UUID;

public abstract class Producto {
    protected UUID numeroUnico = UUID.randomUUID();
    protected int precioBase;
    protected LocalDate fechaEnvase = LocalDate.now();
    protected LocalDate fechaVencimiento;
}
