package productos;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StockModeloTabla extends AbstractTableModel {
    private final Stock modelo;
    private final String[] nombreColumnas;

    public StockModeloTabla(Stock modelo) {
        this.modelo = modelo;
        List<String> encabezado = modelo.getEncabezado();
        this.nombreColumnas = encabezado.toArray(new String[0]);
    }

    @Override
    public int getRowCount() {
        return getModelo().getProductos().size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int fileIndice, int columnaIndice) {
        Producto producto = getModelo().getProductos().get(fileIndice);
        return switch (columnaIndice) {
            case 0 -> modelo.getProductos().indexOf(producto);
            case 1 -> producto.getNombre();
            case 2 -> producto.getUnidades();
            case 3 -> producto.getPrecioBase();
            case 4 -> producto.getFechaEnvase();
            case 5 -> producto.getFechaVencimiento();
            default -> null;
        };
    }

    @Override
    public String getColumnName(int columna) {
        return nombreColumnas[columna];
    }

    public Stock getModelo() {
        return modelo;
    }
}
