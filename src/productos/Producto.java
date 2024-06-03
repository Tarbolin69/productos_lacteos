package productos;

import java.time.LocalDate;
import java.util.UUID;

// Quiza armar una clase llamada "Stock" que sea solo una lista de Producto, para poder hacer
// operaciones sobre todos los productos, como e print tabla
public abstract class Producto {
    protected UUID numeroUnico = UUID.randomUUID();
    protected int precioBase;
    protected Double peso;
    protected LocalDate fechaEnvase;
    protected LocalDate fechaVencimiento;

    public abstract void imprimirInformacion();
}
