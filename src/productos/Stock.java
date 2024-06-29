package productos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stock {
    private final List<Producto> productos = new ArrayList<>();
    private final List<String> encabezado = new ArrayList<>(List.of("ID", "Nombre", "Unidades", "Precio", "Envase", "Vencimiento"));

    public void agregar(Producto producto) {
        this.productos.add(producto);
    }

    public void ordenarPrecio() {
        this.productos.sort(Comparator.comparing(Producto::getPrecioBase).reversed());
    }

    public void ordenarUnidades() {
        this.productos.sort(Comparator.comparing(Producto::getUnidades).reversed());
    }

    public void ordenarFecha() {
        this.productos.sort(Comparator.comparing(Producto::getFechaEnvase).reversed());
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<String> getEncabezado() {
        return encabezado;
    }
}
