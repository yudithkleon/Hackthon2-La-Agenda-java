package ui;

import agenda.Agenda;
import agenda.Contacto;

import javax.swing.*;
import java.awt.*;

public class MostrarAgenda extends JFrame  {
    private Agenda agenda;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextArea areaSalida;


    public MostrarAgenda() {
        agenda = new Agenda(15);
        setTitle("📒 Agenda de Contactos");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        crearInterfaz();

        setVisible(true);


    }
    private void crearInterfaz() {

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("AGENDA DE CONTACTOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(titulo, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del contacto"));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelFormulario.add(txtApellido);

        panelFormulario.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panelFormulario.add(txtTelefono);

        add(panelFormulario, BorderLayout.CENTER);


        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 10, 10));

        JButton btnAgregar = new JButton("➕ Añadir");
        JButton btnBuscar = new JButton("🔍 Buscar");
        JButton btnEliminar = new JButton("🗑 Eliminar");
        JButton btnModificar = new JButton("✏ Modificar");
        JButton btnListar = new JButton("📋 Listar");
        JButton btnEspacios = new JButton("ℹ Espacios");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnListar);
        panelBotones.add(btnEspacios);


        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        areaSalida.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scroll = new JScrollPane(areaSalida);

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(panelBotones, BorderLayout.NORTH);
        panelInferior.add(scroll, BorderLayout.CENTER);

        add(panelInferior, BorderLayout.SOUTH);


        //Llamando a la lógica
        btnListar.addActionListener(e -> {
            areaSalida.setText(agenda.listarContactosTexto());
        });

    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
    }
}
