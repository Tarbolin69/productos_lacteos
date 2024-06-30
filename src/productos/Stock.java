package productos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stock {
    private final List<Producto> productos = new ArrayList<>();
    private final List<String> encabezado = new ArrayList<>();

    public Stock() {
        encabezado.add("ID");
        encabezado.add("Nombre");
        encabezado.add("Unidades");
        encabezado.add("Precio");
        encabezado.add("Envase");
        encabezado.add("Vencimiento");
    }

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

    public void elimanarIndice(int indice) {
        if (indice >= 0 && indice <= productos.size()) {
            productos.remove(indice);
        } else {
            System.out.println("Este indice no tiene producto relacionado");
        }
    }

    public void eliminarVencidos() {
        LocalDate hoy = LocalDate.now();
        productos.removeIf(producto -> producto.getFechaVencimiento() != null && !hoy.isBefore(producto.getFechaVencimiento()));
    }
}
