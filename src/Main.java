import agenda.Agenda;
import agenda.Contacto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda(3);

        int opcion;

        do {
            System.out.println("\n===== AGENDA DE CONTACTOS =====");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Ver espacios disponibles");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    //agregar el ciontact
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    Contacto nuevo = new Contacto(nombre, apellido, telefono);
                    agenda.añadirContacto(nuevo);


                break;

                case 2:
                    //listar
                    agenda.listarContactos();
                    break;

                case 3:
                    // buscar
                    System.out.print("Nombre: ");
                    String nombreBuscar = scanner.nextLine();

                    System.out.print("Apellido: ");
                    String apellidoBuscar = scanner.nextLine();

                    agenda.buscaContacto(nombreBuscar, apellidoBuscar);
                    break;

                case 4:
                    // eliminar
                    System.out.print("Nombre: ");
                    String nombreEliminar = scanner.nextLine();

                    System.out.print("Apellido: ");
                    String apellidoEliminar = scanner.nextLine();

                    Contacto eliminar = new Contacto(nombreEliminar, apellidoEliminar, "");
                    agenda.eliminarContacto(eliminar);
                    break;

                case 5:
                    // modificar
                    System.out.print("Nombre: ");
                    String nombreMod = scanner.nextLine();

                    System.out.print("Apellido: ");
                    String apellidoMod = scanner.nextLine();

                    System.out.print("Nuevo teléfono: ");
                    String nuevoTelefono = scanner.nextLine();

                    agenda.modificarTelefono(nombreMod, apellidoMod, nuevoTelefono);
                    break;

                case 6:
                    // espacios
                    agenda.espacioLibres();
                    break;

                case 0:
                    System.out.println("Saliendo de la agenda...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);

        scanner.close();
    }



}
