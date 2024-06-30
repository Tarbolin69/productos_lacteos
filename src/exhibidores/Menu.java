package exhibidores;

import productos.GeneradorProducto;
import productos.ProductoNoPerecedero;
import productos.ProductoPerecedero;
import productos.Stock;
import transformadores.CSVTransformador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements Visualizable {
    ExhibidorCLI impresoraMenu;
    CSVTransformador generarCSV;
    Stock inventario;
    String nombre;
    int unidades;
    int diasCantidad;
    int precio;
    Scanner scanner;
    public Menu() {
        this.impresoraMenu = new ExhibidorCLI();
        this.generarCSV = new CSVTransformador();
        this.inventario = generarCSV.leerCSV();
        this.scanner = new Scanner(System.in);
        visualizar(inventario);
    }
    public void visualizar(Stock stock) {
        int opcion = 0;
        while (opcion!=7) {
            try {
                System.out.println("1 - Agregar producto");
                System.out.println("2 - Eliminar producto");
                System.out.println("3 - Eliminar productos vencidos");
                System.out.println("4 - Mostrar stock");
                System.out.println("5 - Filtrar stock");
                System.out.println("6 - Abrir tabla GUI");
                System.out.println("7 - salir");
                System.out.println("Ingrese una opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (InputMismatchException|NumberFormatException e){
                System.out.println("Ingrese solo numeros y sin espacios");
            } finally {
                switch (opcion) {
                    case 1:
                        try {
                            System.out.println("1 - Perecedero");
                            System.out.println("2 - No perecedero");
                            System.out.println("Elija un tipo de producto: ");
                            int producto = Integer.parseInt(scanner.nextLine());
                            GeneradorProducto generadorDeProductos = new GeneradorProducto();
                            switch (producto) {
                                case 1:
                                    System.out.println("Ingrese el nombre:");
                                    nombre = scanner.nextLine();
                                    System.out.println("Ingrese el precio:");
                                    precio = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Ingrese las Unidades:");
                                    unidades = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Ingrese la cantidad de dias que tarda en vencerse:");
                                    diasCantidad = Integer.parseInt(scanner.nextLine());
                                    ProductoPerecedero nuevoPerecedero = generadorDeProductos.generarPerecedero(nombre, precio, unidades, diasCantidad);
                                    inventario.agregar(nuevoPerecedero);
                                    break;
                                case 2:
                                    System.out.print("Ingrese el nombre: ");
                                    nombre = scanner.nextLine();
                                    System.out.print("Ingrese el precio: ");
                                    precio = Integer.parseInt(scanner.nextLine());
                                    System.out.print("Ingrese las Unidades: ");
                                    unidades = Integer.parseInt(scanner.nextLine());
                                    ProductoNoPerecedero nuevoNoPercedero = generadorDeProductos.generarProductoNoPerecedero(nombre, precio, unidades);
                                    inventario.agregar(nuevoNoPercedero);
                                    break;
                                default:
                                    System.out.println("Opcion Invalida");
                                    break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Error al ingresar Datos");
                        }
                        break;
                    case 2:
                        try {
                            System.out.print("Ingrese el indice: ");
                            int indice = Integer.parseInt(scanner.nextLine());
                            inventario.elimanarIndice(indice);
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Hubo un error" + e);
                        }
                    case 3:
                        int cantidad = inventario.getProductos().size();
                        inventario.eliminarVencidos();
                        if (cantidad == inventario.getProductos().size()) {
                            System.out.println("No se encontraron productos vencidos.");
                        } else {
                            System.out.println("Productos vencidos eliminados");
                        }
                        break;
                    case 4:
                        impresoraMenu.visualizar(inventario);
                        break;
                    case 5:
                        try {
                            System.out.println("1 - Filtrar por precio");
                            System.out.println("2 - Filtrar por fecha de envase");
                            System.out.println("3 - Filtrar for n de unidades");
                            System.out.println("Elija un metodo de filtrado: ");
                            int filtro = Integer.parseInt(scanner.nextLine());
                            switch (filtro) {
                                case 1:
                                    inventario.ordenarPrecio();
                                    impresoraMenu.visualizar(inventario);
                                    break;
                                case 2:
                                    inventario.ordenarFecha();
                                    impresoraMenu.visualizar(inventario);
                                    break;
                                case 3:
                                    inventario.ordenarUnidades();
                                    impresoraMenu.visualizar(inventario);
                                    break;
                                case 4:
                                    impresoraMenu.imprimirProductosVencidos(inventario.getProductos());
                                    break;
                                default:
                                    System.out.println("Opcion invalida.");
                                    break;
                            }
                        } catch (Exception e) {
                            System.out.println("Erro al selecionar o ordenar");
                        }
                        break;
                    case 6:
                        ExhibidorGUI swingGUI = new ExhibidorGUI();
                        swingGUI.visualizar(inventario);
                        break;
                    case 7:
                        generarCSV.escribirCSV(inventario);
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
        }
        System.out.println("Saliendo...");
        scanner.close();
    }
}
