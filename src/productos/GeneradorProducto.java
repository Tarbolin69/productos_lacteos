package productos;

public class GeneradorProducto {
        public ProductoNoPerecedero generarProductoNoPerecedero(String nombre, int precioBase, int unidades) {
            return new ProductoNoPerecedero(nombre, precioBase, unidades);
        }
        public ProductoPerecedero generarPerecedero(String nombre, int precioBase, int unidades, int diasHabiles) {
            return new ProductoPerecedero(nombre, precioBase, unidades, diasHabiles);
        }
}
