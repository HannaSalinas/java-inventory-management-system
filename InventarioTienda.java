import java.util.ArrayList;
import java.util.Scanner;

public class InventarioTienda {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> inventario = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n===== MENÚ INVENTARIO =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Buscar producto por código");
            System.out.println("4. Calcular valor total del inventario");
            System.out.println("5. Eliminar producto por código");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Error: ingresa un número válido.");
                opcion = 0;
                continue;
            }

            switch (opcion) {

                case 1:
                    System.out.println("\n--- Registrar Producto ---");
                    try {
                        System.out.print("Código: ");
                        String codigo = scanner.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(scanner.nextLine());

                        System.out.print("Cantidad: ");
                        int cantidad = Integer.parseInt(scanner.nextLine());

                        System.out.print("Categoría: ");
                        String categoria = scanner.nextLine();

                        Producto nuevo = new Producto(codigo, nombre, precio, cantidad, categoria);
                        inventario.add(nuevo);
                        System.out.println("Producto agregado con éxito.");

                    } catch (Exception e) {
                        System.out.println("Error al registrar producto. Inténtalo nuevamente.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- Listado de Productos ---");
                    if (inventario.isEmpty()) {
                        System.out.println("No hay productos registrados.");
                    } else {
                        System.out.printf("%-10s %-15s %-10s %-10s %-15s %-10s\n",
                                "Código", "Nombre", "Precio", "Cantidad", "Categoría", "Total");

                        for (Producto p : inventario) {
                            p.mostrarInformacion();
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- Buscar Producto por Código ---");
                    System.out.print("Ingrese el código: ");
                    String buscado = scanner.nextLine();

                    boolean encontrado = false;

                    for (Producto p : inventario) {
                        if (p.getCodigo().equalsIgnoreCase(buscado)) {
                            System.out.println("Producto encontrado:");
                            System.out.printf("%-10s %-15s %-10s %-10s %-15s %-10s\n",
                                    "Código", "Nombre", "Precio", "Cantidad", "Categoría", "Total");
                            p.mostrarInformacion();
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No existe un producto con ese código.");
                    }

                    break;

                case 4:
                    System.out.println("\n--- Valor Total del Inventario ---");
                    double total = 0;

                    for (Producto p : inventario) {
                        total += p.calcularValorTotal();
                    }

                    System.out.printf("Valor total en inventario: $%,.2f\n", total);
                    break;

                case 5:
                   System.out.println("\n--- Eliminar Producto por Código ---");
                   System.out.print("Ingrese el código del producto a eliminar: ");
                   String codigoEliminar = scanner.nextLine();

                   boolean eliminado = false;

                   for (int i = 0; i < inventario.size(); i++) {
                   if (inventario.get(i).getCodigo().equalsIgnoreCase(codigoEliminar)) {
                   inventario.remove(i);
                   eliminado = true;
                   System.out.println("Producto eliminado correctamente.");

                   break;
        }
    }

                  if (!eliminado) {
                  System.out.println("No existe un producto con ese código.");
    }
                  break;


                case 6:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}
