import agenda.Agenda;
import agenda.Contacto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda(3);

        for (int i = 0; i < 3; i++) {

            System.out.println("Ingrese el nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese el telefono:");
            String telefono = scanner.nextLine();

            Contacto contacto = new Contacto(nombre, apellido, telefono);

            boolean agregado = agenda.añadirContacto(contacto);

            if (agregado) {
                System.out.println("Contacto guardado\n");
            } else {
                System.out.println("El contacto NO fue guardado\n");
            }
            System.out.println();
        }

        agenda.listarContactos();

        System.out.println("Buscar contacto:");
        System.out.print("Nombre: ");
        String nombreBuscar = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellidoBuscar = scanner.nextLine();

        agenda.buscaContacto(nombreBuscar, apellidoBuscar);


        System.out.println("\nEliminar contacto");
        System.out.print("Nombre: ");
        String nombreEliminar = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellidoEliminar = scanner.nextLine();

        Contacto contactoEliminar = new Contacto(nombreEliminar, apellidoEliminar, "");

        agenda.eliminarContacto(contactoEliminar);
        System.out.println("\nModificar teléfono");
        System.out.print("Nombre: ");
        String nombreModificar = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellidoModificar = scanner.nextLine();

        System.out.print("Nuevo teléfono: ");
        String nuevoTelefono = scanner.nextLine();

        agenda.modificarTelefono(nombreModificar, apellidoModificar, nuevoTelefono);


    }


}