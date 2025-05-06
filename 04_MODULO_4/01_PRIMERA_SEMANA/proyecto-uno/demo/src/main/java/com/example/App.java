package com.example;

import com.example.repository.NombreRepository;
import com.example.repository.impl.NombreRepositoryImpl;
import com.example.service.NombreService;
import com.example.service.impl.NombreServiceImpl;
import com.example.ui.swing.NombresFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * Clase principal que inicializa y ejecuta la aplicación gráfica.
 * Esta clase configura las dependencias necesarias y lanza la interfaz
 * gráfica de usuario.
 * 
 * @author Tu_Nombre
 * @version 1.0
 * @since 2024-03-XX
 */
public class App {
    /**
     * Método principal que inicia la aplicación.
     * Configura el look and feel del sistema, inicializa las capas
     * de la aplicación y lanza la interfaz gráfica.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Configurar el look and feel nativo del sistema
        configurarLookAndFeel();

        // Inicializar las capas
        NombreRepository repository = new NombreRepositoryImpl();
        NombreService service = new NombreServiceImpl(repository);

        // Iniciar la interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            NombresFrame frame = new NombresFrame(service);
            frame.setVisible(true);
        });
    }

    /**
     * Configura el look and feel nativo del sistema operativo.
     * Si ocurre algún error, se utilizará el look and feel por defecto.
     */
    private static void configurarLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println("Error al configurar el look and feel: " + e.getMessage());
        }
    }
}
