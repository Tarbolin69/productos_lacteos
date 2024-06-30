package exhibidores;

import productos.ProductoModeloTabla;
import productos.Stock;

import javax.swing.*;
import java.awt.*;

public class ExhibidorGUI implements Visualizable {
    public void visualizar(Stock stock) {
        SwingUtilities.invokeLater(() -> {
            JFrame marco = new JFrame("Universal STOCKWARE");
            marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ProductoModeloTabla modelo = new ProductoModeloTabla(stock);
            JTable tabla = new JTable(modelo);

            marco.add(new JScrollPane(tabla), BorderLayout.CENTER);
            marco.pack();
            marco.setLocationRelativeTo(null);
            marco.setVisible(true);
        });
    }
}
