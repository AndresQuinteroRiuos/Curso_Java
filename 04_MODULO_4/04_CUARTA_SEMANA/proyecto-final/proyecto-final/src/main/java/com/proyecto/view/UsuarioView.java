package com.proyecto.view;

import com.proyecto.models.Usuario;
import com.proyecto.service.UsuarioService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

@Component
@Route(value = "usuarios", layout = MainLayout.class)
public class UsuarioView extends VerticalLayout {

    private final UsuarioService usuarioService;
    private final Grid<Usuario> grid = new Grid<>(Usuario.class);
    private final TextField nombreField = new TextField("Nombre");
    private final ComboBox<String> tipoField = new ComboBox<>("Tipo");
    private Usuario usuarioSeleccionado = null;

    public UsuarioView(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

        setSizeFull();
        configureGrid();
        configureForm();
        add(createHeader(), grid, createFormLayout());
        refreshGrid();
    }

    private void configureGrid() {
        grid.setColumns("id", "nombre", "tipo");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(event -> {
            usuarioSeleccionado = event.getValue();
            if (usuarioSeleccionado != null) {
                nombreField.setValue(usuarioSeleccionado.getNombre());
                tipoField.setValue(usuarioSeleccionado.getTipo());
            } else {
                clearFields();
            }
        });
    }

    private void configureForm() {
        tipoField.setItems("cliente", "vendedor");
        tipoField.setRequired(true);
        nombreField.setRequired(true);
    }

    private HorizontalLayout createHeader() {
        Button productosButton = new Button("Ir a Productos", e -> {
            getUI().ifPresent(ui -> ui.navigate("productos"));
        });
        Button ventasButton = new Button("Ir a Ventas", e -> {
            getUI().ifPresent(ui -> ui.navigate("ventas"));
        });
        return new HorizontalLayout(productosButton, ventasButton);
    }

    private HorizontalLayout createFormLayout() {
        Button addButton = new Button("Agregar Usuario", e -> {
            try {
                if (nombreField.getValue() == null || nombreField.getValue().trim().isEmpty()) {
                    Notification.show("El nombre no puede estar vacío", 3000, Notification.Position.MIDDLE);
                    return;
                }
                if (tipoField.getValue() == null) {
                    Notification.show("Debe seleccionar un tipo de usuario", 3000, Notification.Position.MIDDLE);
                    return;
                }

                usuarioService.registrarUsuario(
                        nombreField.getValue().trim(),
                        tipoField.getValue());
                refreshGrid();
                clearFields();
                Notification.show("Usuario agregado exitosamente", 3000, Notification.Position.MIDDLE);
            } catch (IllegalArgumentException ex) {
                Notification.show(ex.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        Button updateButton = new Button("Modificar Usuario", e -> {
            if (usuarioSeleccionado != null) {
                try {
                    if (nombreField.getValue() == null || nombreField.getValue().trim().isEmpty()) {
                        Notification.show("El nombre no puede estar vacío", 3000, Notification.Position.MIDDLE);
                        return;
                    }
                    if (tipoField.getValue() == null) {
                        Notification.show("Debe seleccionar un tipo de usuario", 3000, Notification.Position.MIDDLE);
                        return;
                    }

                    usuarioSeleccionado.setNombre(nombreField.getValue().trim());
                    usuarioSeleccionado.setTipo(tipoField.getValue());
                    usuarioService.actualizarUsuario(usuarioSeleccionado);
                    refreshGrid();
                    clearFields();
                    Notification.show("Usuario modificado exitosamente", 3000, Notification.Position.MIDDLE);
                } catch (IllegalArgumentException ex) {
                    Notification.show(ex.getMessage(), 3000, Notification.Position.MIDDLE);
                }
            } else {
                Notification.show("Por favor seleccione un usuario para modificar", 3000, Notification.Position.MIDDLE);
            }
        });

        Button deleteButton = new Button("Eliminar Usuario", e -> {
            if (usuarioSeleccionado != null) {
                try {
                    usuarioService.eliminarUsuario(usuarioSeleccionado.getId());
                    refreshGrid();
                    clearFields();
                    Notification.show("Usuario eliminado exitosamente", 3000, Notification.Position.MIDDLE);
                } catch (IllegalArgumentException ex) {
                    Notification.show(ex.getMessage(), 3000, Notification.Position.MIDDLE);
                }
            } else {
                Notification.show("Por favor seleccione un usuario para eliminar", 3000, Notification.Position.MIDDLE);
            }
        });

        return new HorizontalLayout(nombreField, tipoField, addButton, updateButton, deleteButton);
    }

    private void refreshGrid() {
        grid.setItems(usuarioService.listarUsuarios());
    }

    private void clearFields() {
        nombreField.clear();
        tipoField.clear();
        usuarioSeleccionado = null;
    }
}