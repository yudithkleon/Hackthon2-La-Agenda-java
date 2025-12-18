package agenda;

public class Agenda {
    private Contacto[] contactos;
    private int cantidadActual;

    public Agenda(int tamMaximo) {
        contactos = new Contacto[tamMaximo];
        cantidadActual = 0;
    }

    public boolean agendaLlena() {
        return cantidadActual >= contactos.length;
    }

    public boolean existeContacto(Contacto c) {
        return buscarIndiceContacto(c.getNombre(), c.getApellido()) != -1;
    }

    private int buscarIndiceContacto(String nombre, String apellido) {

        for (int i = 0; i < cantidadActual; i++) {
            Contacto actual = contactos[i];

            if (actual.getNombre().equalsIgnoreCase(nombre)
                    && actual.getApellido().equalsIgnoreCase(apellido)) {
                return i;
            }
        }

        return -1;
    }


    public boolean añadirContacto(Contacto c) {

        if (c.getNombre().isEmpty() || c.getApellido().isEmpty()) {
            System.out.println("No se puede agregar el contacto: nombre o apellido vacío");
            return false;
        }

        if (agendaLlena()) {
            System.out.println("La agenda está llena. No hay espacio disponible.");
            return false;
        }

        if (existeContacto(c)) {
            System.out.println("No se puede agregar el contacto: el contacto ya existe");
            return false;
        }

        contactos[cantidadActual] = c;
        cantidadActual++;

        System.out.println("Contacto agregado correctamente");
        return true;
    }

    public void listarContactos() {

        if (cantidadActual == 0) {
            System.out.println("La agenda está vacía");
            return;
        }

        ordenarContactos();

        System.out.println("LISTA DE CONTACTOS:");

        for (int i = 0; i < cantidadActual; i++) {
            contactos[i].mostrarContacto();
        }
    }

    private void ordenarContactos() {

        for (int i = 0; i < cantidadActual - 1; i++) {
            for (int j = 0; j < cantidadActual - 1 - i; j++) {

                Contacto actual = contactos[j];
                Contacto siguiente = contactos[j + 1];

                int comparacionNombre = actual.getNombre()
                        .compareToIgnoreCase(siguiente.getNombre());

                boolean cambiar = false;

                if (comparacionNombre > 0) {
                    cambiar = true;
                } else if (comparacionNombre == 0) {
                    int comparacionApellido = actual.getApellido()
                            .compareToIgnoreCase(siguiente.getApellido());

                    if (comparacionApellido > 0) {
                        cambiar = true;
                    }
                }

                if (cambiar) {
                    contactos[j] = siguiente;
                    contactos[j + 1] = actual;
                }
            }
        }
    }

    public void buscaContacto(String nombre, String apellido) {

        if (cantidadActual == 0) {
            System.out.println("La agenda está vacía");
            return;
        }

        int indice = buscarIndiceContacto(nombre, apellido);

        if (indice == -1) {
            System.out.println("Contacto no encontrado");
            return;
        }

        Contacto c = contactos[indice];
        System.out.println("Contacto encontrado:");
        System.out.println(c.getNombre() + " " + c.getApellido() + " - " + c.getTelefono());
    }

    public void eliminarContacto(Contacto c) {

        int indice = buscarIndiceContacto(c.getNombre(), c.getApellido());

        if (indice == -1) {
            System.out.println("No se pudo eliminar, el contacto no existe");
            return;
        }

        for (int i = indice; i < cantidadActual - 1; i++) {
            contactos[i] = contactos[i + 1];
        }

        contactos[cantidadActual - 1] = null;
        cantidadActual--;

        System.out.println("Contacto eliminado correctamente");
    }


    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {

        if (nuevoTelefono.isEmpty()) {
            System.out.println("El teléfono no puede estar vacío");
            return;
        }

        int indice = buscarIndiceContacto(nombre, apellido);

        if (indice == -1) {
            System.out.println("No se pudo modificar, el contacto no existe");
            return;
        }

        contactos[indice].setTelefono(nuevoTelefono);
        System.out.println("Teléfono modificado correctamente");
    }
    public int espacioLibres() {

        int espacios = contactos.length - cantidadActual;

        System.out.println("Espacios disponibles en la agenda: " + espacios);

        return espacios;
    }

    //--Para rendirizar en la view
    public String listarContactosTexto() {

        if (cantidadActual == 0) {
            return "La agenda está vacía";
        }

        ordenarContactos();

        StringBuilder sb = new StringBuilder("LISTA DE CONTACTOS:\n\n");

        for (int i = 0; i < cantidadActual; i++) {
            Contacto c = contactos[i];
            sb.append(c.getNombre())
                    .append(" ")
                    .append(c.getApellido())
                    .append(" - ")
                    .append(c.getTelefono())
                    .append("\n");
        }

        return sb.toString();
    }
/// ---------para renderizar en la ui
public String buscarContactoTexto(String nombre, String apellido) {
    if (cantidadActual == 0) {
        return "La agenda está vacía";
    }

    int indice = buscarIndiceContacto(nombre, apellido);

    if (indice == -1) {
        return "Contacto no encontrado";
    }

    Contacto c = contactos[indice];
    return "Contacto encontrado:\n\n"
            + c.getNombre() + " "
            + c.getApellido() + " - "
            + c.getTelefono();
}

    public String eliminarContactoTexto(String nombre, String apellido) {
        int indice = buscarIndiceContacto(nombre, apellido);

        if (indice == -1) {
            return "No se pudo eliminar: contacto no existe";
        }

        for (int i = indice; i < cantidadActual - 1; i++) {
            contactos[i] = contactos[i + 1];
        }

        contactos[cantidadActual - 1] = null;
        cantidadActual--;

        return "Contacto eliminado correctamente";
    }

    public String modificarTelefonoTexto(String nombre, String apellido, String telefono) {
        if (telefono.isEmpty()) {
            return "El teléfono no puede estar vacío";
        }

        int indice = buscarIndiceContacto(nombre, apellido);

        if (indice == -1) {
            return "No se pudo modificar: contacto no existe";
        }

        contactos[indice].setTelefono(telefono);
        return "Teléfono actualizado correctamente";
    }

}