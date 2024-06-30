package transformadores;

import productos.Producto;
import productos.ProductoNoPerecedero;
import productos.ProductoPerecedero;
import productos.Stock;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSVTransformador {
    public void escribirCSV(Stock stock){
        File csvArchivo = new File("productos.csv");
        try (PrintWriter escritorCSV = new PrintWriter(csvArchivo)) {
            List<Producto> productos = stock.getProductos();
            String encabezado = String.join(";", stock.getEncabezado());
            escritorCSV.println(encabezado);
            for (Producto producto : productos) {
                String valores = String.join(";", producto.productoString());
                escritorCSV.println(productos.indexOf(producto) + ";" + valores);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo \"productos.csv\" no existe");
        }
    }
    public Stock leerCSV() {
        Stock stockProductos = new Stock();
        try {
            File csvArchivo = new File("productos.csv");
            Scanner lector = new Scanner(csvArchivo);
            lector.nextLine(); // Nos saltamos el encabezado

            DateTimeFormatter fechaFormateador = DateTimeFormatter.ofPattern("dd/MM/yyy");

            while (lector.hasNextLine()) {
                String producto = lector.nextLine();
                String[] valores = Arrays.stream(producto.split(";"))
                        .map(String::trim)
                        .toArray(String[]::new);
                String nombre = valores[1];
                int unidades = Integer.parseInt(valores[2]);
                int precio = Integer.parseInt(valores[3]);
                LocalDate envase = LocalDate.parse(valores[4], fechaFormateador);
                if (!valores[5].equals("N/A")) {
                    LocalDate vencimiento = LocalDate.parse(valores[5], fechaFormateador);
                    ProductoPerecedero pp = new ProductoPerecedero(nombre, precio, unidades, envase, vencimiento);
                    stockProductos.agregar(pp);
                } else {
                    ProductoNoPerecedero pnp = new ProductoNoPerecedero(nombre, precio, unidades, envase);
                    stockProductos.agregar(pnp);
                }
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo \"productos.csv\" no existe");
            System.exit(0);
        }
        return stockProductos;
    }
}