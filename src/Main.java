import productos.Stock;
import productos.lacteos.Leche;

public class Main {
    public static void main(String[] args) {
        // Convertir "productos" en una clase
        Impresor impresoraDemoniaca = new Impresor();
        Stock stockProductos = new Stock();
        Leche lecheJersey = new Leche(1500, 1.5, true);
        Leche lecheVaca = new Leche(2500, 2.5, true);
        Leche lecheCabra = new Leche(1300, 1.0, true);
        Leche lecheLeche = new Leche(1200, 2.0, true);
        stockProductos.add(lecheJersey);
        stockProductos.add(lecheVaca);
        stockProductos.add(lecheCabra);
        stockProductos.add(lecheLeche);
        impresoraDemoniaca.imprimirProductos(stockProductos.getProductos());
    }
}