package productos;

import productos.lacteos.Leche;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Stock {
    private List<Producto> productos = new ArrayList<>();

    public Producto crearProducto() {
        boolean esPasteurizado = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el precio:");
        int precio = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el peso (Litros):");
        double peso = Double.parseDouble(scanner.nextLine());
        System.out.println("Es pausterizada?");
        String pasuterizado = scanner.nextLine();
        if (pasuterizado.equals("si")) {
            esPasteurizado = true;
        }
        scanner.close();
        return new Leche(precio, peso, esPasteurizado );
    }

    public void add(Producto producto) {
        this.productos.add(producto);
    }

    public void ordenarPrecio() {
        this.productos.sort(Comparator.comparing(Producto::getPrecioBase).reversed());
    }

    public void ordenarPeso() {
        this.productos.sort(Comparator.comparing(Producto::getMasaEspacial).reversed());
    }

    public void ordenarFecha() {
        this.productos.sort(Comparator.comparing(Producto::getFechaEnvase).reversed());
    }

    public void ordenarTipo() {
        this.productos.sort(Comparator.comparing(Producto::getNombre).reversed());
    }

    public List<Producto> getProductos() {
        return productos;
    }
}
