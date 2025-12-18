package agenda;

public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto(String nombre, String apellido, String telefono)  {
        this.nombre = nombre;
        this.apellido= apellido;
        if (telefonoValido(telefono)) {
            this.telefono = telefono;
        } else {
            this.telefono = "";
            System.out.println("Teléfono inválido. Debe tener entre 7 y 10 dígitos numéricos.");
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

    public void mostrarContacto() {
        System.out.println(
                nombre + " " + apellido + " - " + telefono
        );
    }
    private boolean telefonoValido(String telefono) {

        if (telefono == null) {
            return false;
        }

        if (!telefono.matches("\\d+")) {
            return false;
        }

        if (telefono.length() < 7 || telefono.length() > 10) {
            return false;
        }

        return true;
    }

}
