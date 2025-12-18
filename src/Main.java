import agenda.Agenda;
import agenda.Contacto;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome A mi segundo Hackathon!");

        Contacto contactoNuevo = new Contacto("Yudith", "Leon", "3007706748");
        contactoNuevo.mostrarContacto();
        Agenda agendita = new Agenda();
    }
}