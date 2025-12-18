import agenda.Agenda;
import agenda.Contacto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contacto[] contactos = new Contacto[3];

        for (int i = 0; i < contactos.length; i++) {

            System.out.println("Ingrese el nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el apellido:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese el telefono:");
            String telefono = scanner.nextLine();

            contactos[i] = new Contacto(nombre, apellido, telefono);

            System.out.println("Contacto guardado\n");
        }


        System.out.println("LISTA DE CONTACTOS:");

        for (Contacto contacto : contactos) {
            contacto.mostrarContacto();
        }

        Agenda agendita = new Agenda();
    }
}