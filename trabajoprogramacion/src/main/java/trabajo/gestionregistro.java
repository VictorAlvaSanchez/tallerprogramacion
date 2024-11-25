
package trabajo;


import java.util.Scanner;

public class gestionregistro {
    private static final Scanner scanner = new Scanner(System.in);
    private static final gestionLenguaje gestionLenguaje = new gestionLenguaje();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar lenguaje");
            System.out.println("2. Buscar lenguaje");
            System.out.println("3. Eliminar lenguaje");
            System.out.println("4. Imprimir lenguajes");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    agregarLenguaje();
                    break;
                case 2:
                    buscarLenguaje();
                    break;
                case 3:
                    eliminarLenguaje();
                    break;
                case 4:
                    imprimirLenguajes();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private static void agregarLenguaje() {
        System.out.print("Año de creación: ");
        int anioCreacion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        System.out.print("Característica principal: ");
        String caracteristicaPrincipal = scanner.nextLine();

        System.out.print("Nombre del lenguaje: ");
        String nombre = scanner.nextLine();

        System.out.print("Utilización: ");
        String utilizacion = scanner.nextLine();

        gestionLenguaje.agregarLenguaje(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
        System.out.println("Lenguaje agregado exitosamente.");
    }

    private static void buscarLenguaje() {
        System.out.print("Nombre del lenguaje a buscar: ");
        String nombre = scanner.nextLine();

        LenguajeProgramacion lenguaje = gestionLenguaje.buscarLenguaje(nombre);
        if (lenguaje != null) {
            System.out.println("Lenguaje encontrado: " + lenguaje);
        } else {
            System.out.println("Lenguaje no encontrado.");
        }
    }

    private static void eliminarLenguaje() {
        System.out.print("Nombre del lenguaje a eliminar: ");
        String nombre = scanner.nextLine();

        if (gestionLenguaje.eliminarLenguaje(nombre)) {
            System.out.println("Lenguaje eliminado exitosamente.");
        } else {
            System.out.println("Lenguaje no encontrado.");
        }
    }

    private static void imprimirLenguajes() {
        System.out.println("\nLista de lenguajes:");
        gestionLenguaje.imprimirLenguajes();
    }
}