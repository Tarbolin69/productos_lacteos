package productos;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;

public class ProductoModeloTabla extends AbstractTableModel {
    private final Stock stock;
    public ProductoModeloTabla(Stock stock) {
        this.stock = stock;
    }
    @Override
    public int getRowCount() {
        return stock.getProductos().size();
    }
    @Override
    public int getColumnCount() {
        return stock.getEncabezado().size();
    }
    @Override
    public String getColumnName(int indiceColumna) {
        return stock.getEncabezado().get(indiceColumna);
    }
    @Override
    public Object getValueAt(int indiceLinea, int indiceColuma) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyy");
        Producto producto = stock.getProductos().get(indiceLinea);
        return switch (indiceColuma) {
            case 0 -> stock.getProductos().indexOf(producto);
            case 1 -> producto.getNombre();
            case 2 -> producto.getPrecioBase();
            case 3 -> producto.getUnidades();
            case 4 -> producto.getFechaEnvase();
            case 5 -> (producto.getFechaVencimiento() != null ? formatoFecha.format(producto.getFechaVencimiento()) : "N/A");
            default -> null;
        };
    }
}