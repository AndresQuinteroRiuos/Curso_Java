package com.example.ui.swing;

import com.example.service.NombreService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ventana principal de la aplicación que gestiona la lista de nombres.
 * Esta clase proporciona una interfaz gráfica de usuario para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una lista de
 * nombres.
 * 
 * @author Tu_Nombre
 * @version 1.0
 * @since 2024-03-XX
 */
public class NombresFrame extends JFrame {
    /** Servicio que maneja la lógica de negocio de los nombres */
    private final NombreService nombreService;

    /** Componente que muestra la lista de nombres */
    private JList<String> listaNombres;

    /** Modelo de datos para la lista de nombres */
    private DefaultListModel<String> modeloLista;

    /** Campo de texto para ingresar/editar nombres */
    private JTextField campoNombre;

    /** Botón para agregar nuevos nombres */
    private JButton btnAgregar;

    /** Botón para eliminar nombres seleccionados */
    private JButton btnEliminar;

    /** Botón para modificar nombres existentes */
    private JButton btnModificar;

    /** Botón para limpiar toda la lista */
    private JButton btnLimpiar;

    /**
     * Constructor que inicializa la ventana principal y sus componentes.
     * 
     * @param nombreService Servicio que proporciona la lógica de negocio para
     *                      gestionar nombres
     * @throws IllegalArgumentException si nombreService es null
     */
    public NombresFrame(NombreService nombreService) {
        if (nombreService == null) {
            throw new IllegalArgumentException("El servicio de nombres no puede ser null");
        }
        this.nombreService = nombreService;
        configurarVentana();
        inicializarComponentes();
        agregarComponentes();
        configurarEventos();
        actualizarLista();
    }

    /**
     * Configura las propiedades básicas de la ventana.
     */
    private void configurarVentana() {
        setTitle("Gestión de Nombres");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
    }

    /**
     * Inicializa todos los componentes de la interfaz gráfica.
     */
    private void inicializarComponentes() {
        // Inicialización de componentes de entrada
        campoNombre = new JTextField(20);
        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnLimpiar = new JButton("Limpiar Lista");

        // Inicialización de la lista
        modeloLista = new DefaultListModel<>();
        listaNombres = new JList<>(modeloLista);
        listaNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * Organiza y agrega los componentes a la ventana.
     */
    private void agregarComponentes() {
        setLayout(new BorderLayout(10, 10));

        // Panel de entrada
        JPanel panelEntrada = crearPanelEntrada();

        // Panel de botones
        JPanel panelBotones = crearPanelBotones();

        // Lista con scroll
        JScrollPane scrollLista = new JScrollPane(listaNombres);
        scrollLista.setBorder(BorderFactory.createTitledBorder("Lista de Nombres"));

        // Agregar paneles a la ventana
        add(panelEntrada, BorderLayout.NORTH);
        add(scrollLista, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Agregar márgenes
        ((JPanel) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    /**
     * Crea el panel de entrada de datos.
     * 
     * @return JPanel configurado con los componentes de entrada
     */
    private JPanel crearPanelEntrada() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(new JLabel("Nombre:"));
        panel.add(campoNombre);
        panel.add(btnAgregar);
        return panel;
    }

    /**
     * Crea el panel de botones de acción.
     * 
     * @return JPanel configurado con los botones de acción
     */
    private JPanel crearPanelBotones() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(btnModificar);
        panel.add(btnEliminar);
        panel.add(btnLimpiar);
        return panel;
    }

    /**
     * Configura los eventos y listeners de los componentes.
     */
    private void configurarEventos() {
        btnAgregar.addActionListener(e -> agregarNombre());
        btnModificar.addActionListener(e -> modificarNombre());
        btnEliminar.addActionListener(e -> eliminarNombre());
        btnLimpiar.addActionListener(e -> limpiarLista());

        // Configurar doble clic en la lista
        configurarEventosDobleClic();
    }

    /**
     * Configura el evento de doble clic en la lista.
     */
    private void configurarEventosDobleClic() {
        listaNombres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String nombreSeleccionado = listaNombres.getSelectedValue();
                    if (nombreSeleccionado != null) {
                        campoNombre.setText(nombreSeleccionado);
                    }
                }
            }
        });
    }

    /**
     * Agrega un nuevo nombre a la lista.
     * Valida que el nombre no esté vacío antes de agregarlo.
     */
    private void agregarNombre() {
        String nombre = campoNombre.getText().trim();
        if (!nombre.isEmpty()) {
            nombreService.agregarNombre(nombre);
            actualizarLista();
            campoNombre.setText("");
            campoNombre.requestFocus();
        } else {
            mostrarError("El nombre no puede estar vacío");
        }
    }

    /**
     * Modifica el nombre seleccionado en la lista.
     * Valida que haya un nombre seleccionado y que el nuevo nombre no esté vacío.
     */
    private void modificarNombre() {
        int indiceSeleccionado = listaNombres.getSelectedIndex();
        String nuevoNombre = campoNombre.getText().trim();

        if (indiceSeleccionado != -1 && !nuevoNombre.isEmpty()) {
            nombreService.modificarNombre(indiceSeleccionado, nuevoNombre);
            actualizarLista();
            campoNombre.setText("");
        } else {
            mostrarError("Selecciona un nombre y escribe el nuevo valor");
        }
    }

    /**
     * Elimina el nombre seleccionado de la lista.
     * Valida que haya un nombre seleccionado.
     */
    private void eliminarNombre() {
        int indiceSeleccionado = listaNombres.getSelectedIndex();
        if (indiceSeleccionado != -1) {
            nombreService.eliminarPorPosicion(indiceSeleccionado);
            actualizarLista();
            campoNombre.setText("");
        } else {
            mostrarError("Selecciona un nombre para eliminar");
        }
    }

    /**
     * Limpia toda la lista de nombres.
     * Solicita confirmación antes de realizar la operación.
     */
    private void limpiarLista() {
        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que quieres limpiar toda la lista?",
                "Confirmar limpieza",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            nombreService.limpiarLista();
            actualizarLista();
            campoNombre.setText("");
        }
    }

    /**
     * Actualiza la lista de nombres mostrada en la interfaz.
     */
    private void actualizarLista() {
        modeloLista.clear();
        nombreService.obtenerTodosLosNombres().forEach(modeloLista::addElement);
    }

    /**
     * Muestra un mensaje de error al usuario.
     * 
     * @param mensaje El mensaje de error a mostrar
     */
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}