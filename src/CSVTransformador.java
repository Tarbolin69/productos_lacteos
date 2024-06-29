import productos.Stock;
import productos.lacteos.Leche;
import productos.lacteos.Queso;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class CSVTransformador {
    public Stock leerCSV(String archivo) {
        Stock stockProductos = new Stock();
        try {
            File csvArchivo = new File("src/" + archivo);
            Scanner lector = new Scanner(csvArchivo);

            DateTimeFormatter fechaFormateador = DateTimeFormatter.ofPattern("dd/MM/yyy");


            if (lector.hasNextLine()) {
                String encabezado = lector.nextLine();
                String[] valores = encabezado.split(";");
                for (String valor : valores) {
                    stockProductos.addEncabezado(valor);
                }
            }

            while (lector.hasNextLine()) {
                String producto = lector.nextLine();
                String[] valores = Arrays.stream(producto.split(";"))
                        .map(String::trim)
                        .toArray(String[]::new);
                switch (valores[1]) {
                    case "Leche":
                        Leche leche = new Leche(Integer.parseInt(valores[2]), Double.parseDouble(valores[3]), LocalDate.parse(valores[4], fechaFormateador));
                        stockProductos.add(leche);
                        break;
                    case "Queso":
                        Queso queso = new Queso(Integer.parseInt(valores[2]), Double.parseDouble(valores[3]), LocalDate.parse(valores[4], fechaFormateador));
                        stockProductos.add(queso);
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
