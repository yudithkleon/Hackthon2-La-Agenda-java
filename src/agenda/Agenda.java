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

    public boolean existeContacto(Contacto nuevo) {

        for (int i = 0; i < cantidadActual; i++) {
            Contacto actual = contactos[i];

            if (actual.getNombre().equalsIgnoreCase(nuevo.getNombre())
                    && actual.getApellido().equalsIgnoreCase(nuevo.getApellido())) {
                return true;
            }
        }

        return false;
    }

    public boolean añadirContacto(Contacto c) {

        if (c.getNombre().isEmpty() && c.getApellido().isEmpty()) {
            System.out.println("No se puede agregar el contacto: nombre o apellido vacío");
            return false;
        }

        if (agendaLlena()) {
            System.out.println("No se puede agregar el contacto: la agenda está llena");
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

        System.out.println("LISTA DE CONTACTOS:");

        for (int i = 0; i < cantidadActual; i++) {
            contactos[i].mostrarContacto();
        }
    }


}
