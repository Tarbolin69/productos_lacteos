import productos.ProductoNoPerecedero;
import productos.ProductoPerecedero;
import productos.Stock;

public class Main {
    public static void main(String[] args) {
        CSVTransformador lector = new CSVTransformador();
        Impresor impresoraDemoniaca = new Impresor();
        Stock stockProductos = lector.leerCSV();
        //Stock stockProductos = new Stock();
        //ProductoPerecedero lecheJersery = new ProductoPerecedero("Leche Jersey", 1500, 50, 7);
        //ProductoNoPerecedero mielAbeja = new ProductoNoPerecedero("Miel Pura", 2500, 20);
        //ProductoPerecedero quesoVerde = new ProductoPerecedero("Queso Verde", 3000, 15, 96);
        //ProductoNoPerecedero lechePolvo = new ProductoNoPerecedero("Leche en Polvo", 1600, 80);
        //stockProductos.agregar(lecheJersery);
        //stockProductos.agregar(mielAbeja);
        //stockProductos.agregar(quesoVerde);
        //stockProductos.agregar(lechePolvo);
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