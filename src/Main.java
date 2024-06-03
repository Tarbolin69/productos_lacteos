import productos.Producto;
import productos.lacteos.Leche;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Leche lecheJersey = new Leche(1500, 1.5);
        lecheJersey.imprimirInformacion();
    }
}