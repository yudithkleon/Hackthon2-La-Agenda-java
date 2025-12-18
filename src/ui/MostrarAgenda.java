package ui;

import agenda.Agenda;
import agenda.Contacto;

import javax.swing.*;
import java.awt.*;

public class MostrarAgenda extends JFrame {
    private Agenda agenda;

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtTelefono;
    private JTextArea areaSalida;


    public MostrarAgenda( Agenda agenda) {
        this.agenda = agenda;

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
        panelFormulario.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Datos del contacto"),
                        BorderFactory.createEmptyBorder(15, 15, 15, 15)
                )
        );


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

        JPanel panelBotones = new JPanel(new GridLayout(2, 4, 10, 10));
        JButton btnLimpiar = new JButton("🧹 Limpiar");
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
        panelBotones.add(btnLimpiar);

        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        areaSalida.setFont(new Font("Monospaced", Font.PLAIN, 13));

        JScrollPane scroll = new JScrollPane(areaSalida);

        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(panelBotones, BorderLayout.NORTH);
        panelInferior.add(scroll, BorderLayout.CENTER);
        panelInferior.setBorder(
                BorderFactory.createEmptyBorder(10, 15, 15, 15)
        );

        add(panelInferior, BorderLayout.SOUTH);


        //Llamando a la lógica
        btnAgregar.addActionListener(e -> {
            Contacto c = new Contacto(
                    txtNombre.getText().trim(),
                    txtApellido.getText().trim(),
                    txtTelefono.getText().trim()
            );

            String resultado = agenda.añadirContactoTexto(c);

            if (resultado.equals("Contacto agregado correctamente")) {
                JOptionPane.showMessageDialog(
                        this,
                        resultado,
                        "Éxito",
                        JOptionPane.INFORMATION_MESSAGE
                );
                limpiarCampos();
                areaSalida.setText(agenda.listarContactosTexto());
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        resultado,
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });


        btnBuscar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese nombre y apellido",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            areaSalida.setText(
                    agenda.buscarContactoTexto(nombre, apellido)
            );
        });

        btnEliminar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese nombre y apellido",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            String resultado = agenda.eliminarContactoTexto(nombre, apellido);

            JOptionPane.showMessageDialog(
                    this,
                    resultado,
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
            );

            areaSalida.setText(agenda.listarContactosTexto());
            limpiarCampos();
        });



        btnModificar.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String telefono = txtTelefono.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty()) {
                JOptionPane.showMessageDialog(
                        this,
                        "Ingrese nombre, apellido y teléfono",
                        "Advertencia",
                        JOptionPane.WARNING_MESSAGE
                );
                return;
            }

            String resultado = agenda.modificarTelefonoTexto(nombre, apellido, telefono);
            areaSalida.setText(resultado + "\n\n" + agenda.listarContactosTexto());
            limpiarCampos();
        });

        btnListar.addActionListener(e -> {
            areaSalida.setText(agenda.listarContactosTexto());
        });


        btnEspacios.addActionListener(e ->

        {
            int espacios = agenda.espacioLibres();
            JOptionPane.showMessageDialog(
                    this,
                    "Espacios disponibles: " + espacios,
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );
        });
        btnLimpiar.addActionListener(e -> {
            limpiarCampos();
            areaSalida.setText("");
        });

    }


    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
    }
}
