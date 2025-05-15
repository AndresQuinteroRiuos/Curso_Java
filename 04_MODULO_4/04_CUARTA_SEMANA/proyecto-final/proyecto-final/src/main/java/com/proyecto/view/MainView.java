package com.proyecto.view;

import com.proyecto.models.Producto;
import com.proyecto.service.ProductoService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

@Component
@Route(value = "productos", layout = MainLayout.class)
public class MainView extends VerticalLayout {

    private final ProductoService productoService;
    private final Grid<Producto> grid = new Grid<>(Producto.class);
    private final TextField nombreField = new TextField("Nombre");
    private final TextField categoriaField = new TextField("Categoría");
    private final TextField precioField = new TextField("Precio");
    private Producto productoSeleccionado = null;

    public MainView(ProductoService productoService) {
        this.productoService = productoService;

        setSizeFull();
        configureGrid();
        add(grid, createFormLayout());
        refreshGrid();
    }

    private void configureGrid() {
        grid.setColumns("id", "nombre", "categoria", "precio");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
        grid.asSingleSelect().addValueChangeListener(event -> {
            productoSeleccionado = event.getValue();
            if (productoSeleccionado != null) {
                nombreField.setValue(productoSeleccionado.getNombre());
                categoriaField.setValue(productoSeleccionado.getCategoria());
                precioField.setValue(String.valueOf(productoSeleccionado.getPrecio()));
            } else {
                clearFields();
            }
        });
    }

    private HorizontalLayout createFormLayout() {
        Button addButton = new Button("Agregar Producto", e -> {
            try {
                if (nombreField.getValue() == null || nombreField.getValue().trim().isEmpty()) {
                    Notification.show("El nombre del producto no puede estar vacío", 3000,
                            Notification.Position.MIDDLE);
                    return;
                }
                if (categoriaField.getValue() == null || categoriaField.getValue().trim().isEmpty()) {
                    Notification.show("La categoría del producto no puede estar vacía", 3000,
                            Notification.Position.MIDDLE);
                    return;
                }
                if (precioField.getValue() == null || precioField.getValue().trim().isEmpty()) {
                    Notification.show("El precio del producto no puede estar vacío", 3000,
                            Notification.Position.MIDDLE);
                    return;
                }
                double precio = Double.parseDouble(precioField.getValue());
                if (precio < 0) {
                    Notification.show("El precio no puede ser negativo", 3000, Notification.Position.MIDDLE);
                    return;
                }
                Producto producto = new Producto(
                        nombreField.getValue(),
                        categoriaField.getValue(),
                        precio);
                productoService.agregarProducto(
                        producto.getNombre(),
                        producto.getCategoria(),
                        producto.getPrecio());
                refreshGrid();
                clearFields();
                Notification.show("Producto agregado exitosamente", 3000, Notification.Position.MIDDLE);
            } catch (NumberFormatException ex) {
                Notification.show("El precio debe ser un número válido", 3000, Notification.Position.MIDDLE);
            } catch (IllegalArgumentException ex) {
                Notification.show(ex.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        Button updateButton = new Button("Modificar Producto", e -> {
            if (productoSeleccionado != null) {
                try {
                    if (nombreField.getValue() == null || nombreField.getValue().trim().isEmpty()) {
                        Notification.show("El nombre del producto no puede estar vacío", 3000,
                                Notification.Position.MIDDLE);
                        return;
                    }
                    if (categoriaField.getValue() == null || categoriaField.getValue().trim().isEmpty()) {
                        Notification.show("La categoría del producto no puede estar vacía", 3000,
                                Notification.Position.MIDDLE);
                        return;
                    }
                    if (precioField.getValue() == null || precioField.getValue().trim().isEmpty()) {
                        Notification.show("El precio del producto no puede estar vacío", 3000,
                                Notification.Position.MIDDLE);
                        return;
                    }
                    double precio = Double.parseDouble(precioField.getValue());
                    if (precio < 0) {
                        Notification.show("El precio no puede ser negativo", 3000, Notification.Position.MIDDLE);
                        return;
                    }
                    productoService.actualizarProducto(
                            productoSeleccionado.getId(),
                            nombreField.getValue(),
                            categoriaField.getValue(),
                            precio);
                    refreshGrid();
                    clearFields();
                    Notification.show("Producto modificado exitosamente", 3000, Notification.Position.MIDDLE);
                } catch (NumberFormatException ex) {
                    Notification.show("El precio debe ser un número válido", 3000, Notification.Position.MIDDLE);
                } catch (IllegalArgumentException ex) {
                    Notification.show(ex.getMessage(), 3000, Notification.Position.MIDDLE);
                }
            } else {
                Notification.show("Por favor seleccione un producto para modificar", 3000,
                        Notification.Position.MIDDLE);
            }
        });

        Button deleteButton = new Button("Eliminar Producto", e -> {
            if (productoSeleccionado != null) {
                try {
                    productoService.eliminarProducto(productoSeleccionado.getId());
                    refreshGrid();
                    clearFields();
                    Notification.show("Producto eliminado exitosamente", 3000, Notification.Position.MIDDLE);
                } catch (IllegalArgumentException ex) {
                    Notification.show(ex.getMessage(), 3000, Notification.Position.MIDDLE);
                }
            } else {
                Notification.show("Por favor seleccione un producto para eliminar", 3000, Notification.Position.MIDDLE);
            }
        });

        return new HorizontalLayout(nombreField, categoriaField, precioField, addButton, updateButton, deleteButton);
    }

    private void refreshGrid() {
        grid.setItems(productoService.listarProductos());
    }

    private void clearFields() {
        nombreField.clear();
        categoriaField.clear();
        precioField.clear();
        productoSeleccionado = null;
    }
}