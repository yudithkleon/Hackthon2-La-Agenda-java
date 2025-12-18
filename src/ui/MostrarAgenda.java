package ui;

import agenda.Agenda;
import javax.swing.*;

public class MostrarAgenda extends JFrame  {
    private Agenda agenda;
    private JPanel panel;
    private JButton btnAgregar;
    private JButton btnListar;


    public MostrarAgenda() {
        agenda = new Agenda(15);
        panel = new JPanel();
        btnAgregar = new JButton("Añadir contacto");
        btnListar = new JButton("Listar contactos");

        panel.add(btnAgregar);
        panel.add(btnListar);

        add(panel);


        setTitle("Agenda de Contactos");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
