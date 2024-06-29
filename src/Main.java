import exhibidores.ExhibidorCLI;
import productos.Stock;

public class Main {
    public static void main(String[] args) {
        CSVTransformador lector = new CSVTransformador();
        ExhibidorCLI impresoraDemoniaca = new ExhibidorCLI();
        Stock stockProductos = lector.leerCSV();
        impresoraDemoniaca.imprimirProductos(stockProductos);
        stockProductos.ordenarPrecio();
        System.out.println();
        impresoraDemoniaca.imprimirProductos(stockProductos);
        stockProductos.ordenarFecha();
        System.out.println();
        impresoraDemoniaca.imprimirProductos(stockProductos);
        stockProductos.ordenarUnidades();
        System.out.println();
        impresoraDemoniaca.imprimirProductos(stockProductos);
        lector.escribirCSV(stockProductos);
    }
}