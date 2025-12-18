package agenda;

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;

        if (telefonoValido(telefono)) {
            this.telefono = telefono;
        } else {
            this.telefono = null;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        if (telefonoValido(telefono)) {
            this.telefono = telefono;
        } else {
            System.out.println("Teléfono inválido. No se realizó el cambio.");
        }

    }

  /*  public void mostrarContacto() {
        System.out.println(
                nombre + " " + apellido + " - " + telefono
        );
    }*/

    private boolean telefonoValido(String telefono) {
        return telefono != null && telefono.matches("\\d{7,10}");
    }

    public boolean esValido() {
        return nombre != null && !nombre.isEmpty()
                && apellido != null && !apellido.isEmpty()
                && telefono != null;
    }
    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + telefono;
    }
}
