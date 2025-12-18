package agenda;

public class Contacto {
    String nombre;
    String apellido;
    String telefono;

    public Contacto(String nombre, String apellido, String telefono)  {
        this.nombre = nombre;
        this.apellido= apellido;
        this.telefono=telefono;

        System.out.println("El contacto se Creo yupiiii...");

    }
    public void mostrarContacto() {
        System.out.println(
                nombre + " " + apellido + " - " + telefono
        );
    }

}
