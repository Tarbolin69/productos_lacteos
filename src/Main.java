import exhibidores.ExhibidorCLI;
import productos.Stock;

public class Main {
    public static void main(String[] args) {
        CSVTransformador lector = new CSVTransformador();
        Stock stockProductos = lector.leerCSV();
        ExhibidorCLI impresoraDemoniaca = new ExhibidorCLI();
        impresoraDemoniaca.visualizar(stockProductos);
        stockProductos.ordenarPrecio();
        System.out.println();
        impresoraDemoniaca.visualizar(stockProductos);
        stockProductos.ordenarFecha();
        System.out.println();
        impresoraDemoniaca.visualizar(stockProductos);
        stockProductos.ordenarUnidades();
        System.out.println();
        impresoraDemoniaca.visualizar(stockProductos);
        lector.escribirCSV(stockProductos);
    }
}