package com.proyecto.view;

import com.proyecto.models.Venta;
import com.proyecto.models.Producto;
import com.proyecto.models.Usuario;
import com.proyecto.service.VentaService;
import com.proyecto.service.ProductoService;
import com.proyecto.service.UsuarioService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import org.springframework.stereotype.Component;

@Component
@Route(value = "ventas", layout = MainLayout.class)
public class VentaView extends VerticalLayout implements BeforeEnterObserver {

    private final VentaService ventaService;
    private final ProductoService productoService;
    private final UsuarioService usuarioService;
    private ComboBox<Producto> productoField;
    private ComboBox<Usuario> clienteField;
    private ComboBox<Usuario> vendedorField;
    private Grid<Venta> grid;

    public VentaView(VentaService ventaService, ProductoService productoService, UsuarioService usuarioService) {
        this.ventaService = ventaService;
        this.productoService = productoService;
        this.usuarioService = usuarioService;

        setSizeFull();
        setupView();
    }

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        // Actualizar la lista de productos cada vez que se entra a la vista
        if (productoField != null) {
            productoField.setItems(productoService.listarProductos());
        }
        // Actualizar la lista de clientes
        if (clienteField != null) {
            clienteField.setItems(usuarioService.listarUsuarios().stream()
                    .filter(u -> u.getTipo().equals("cliente"))
                    .toList());
        }
        // Actualizar la lista de vendedores
        if (vendedorField != null) {
            vendedorField.setItems(usuarioService.listarUsuarios().stream()
                    .filter(u -> u.getTipo().equals("vendedor"))
                    .toList());
        }
        if (grid != null) {
            grid.setItems(ventaService.listarVentas());
        }
    }

    private void setupView() {
        grid = new Grid<>(Venta.class);
        productoField = new ComboBox<>("Producto");
        clienteField = new ComboBox<>("Cliente");
        vendedorField = new ComboBox<>("Vendedor");
        IntegerField cantidadField = new IntegerField("Cantidad");

        // Configurar grid
        grid.setColumns("id", "producto", "cliente", "vendedor", "cantidad", "fecha");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        // Configurar campos
        productoField.setItems(productoService.listarProductos());
        productoField.setItemLabelGenerator(Producto::getNombre);
        productoField.setRequired(true);

        clienteField.setItems(usuarioService.listarUsuarios().stream()
                .filter(u -> u.getTipo().equals("cliente"))
                .toList());
        clienteField.setItemLabelGenerator(Usuario::getNombre);
        clienteField.setRequired(true);

        vendedorField.setItems(usuarioService.listarUsuarios().stream()
                .filter(u -> u.getTipo().equals("vendedor"))
                .toList());
        vendedorField.setItemLabelGenerator(Usuario::getNombre);
        vendedorField.setRequired(true);

        cantidadField.setMin(1);
        cantidadField.setRequired(true);

        // Crear botones
        Button productosButton = new Button("Ir a Productos", e -> {
            getUI().ifPresent(ui -> ui.navigate("productos"));
        });

        Button usuariosButton = new Button("Ir a Usuarios", e -> {
            getUI().ifPresent(ui -> ui.navigate("usuarios"));
        });

        Button saveButton = new Button("Registrar Venta", e -> {
            try {
                if (productoField.getValue() == null || clienteField.getValue() == null ||
                        vendedorField.getValue() == null || cantidadField.getValue() == null) {
                    Notification.show("Por favor complete todos los campos", 3000, Notification.Position.MIDDLE);
                    return;
                }

                ventaService.registrarVenta(
                        productoField.getValue(),
                        clienteField.getValue(),
                        vendedorField.getValue(),
                        cantidadField.getValue());
                grid.setItems(ventaService.listarVentas());
                clearFields(productoField, clienteField, vendedorField, cantidadField);
                Notification.show("Venta registrada exitosamente", 3000, Notification.Position.MIDDLE);
            } catch (IllegalArgumentException ex) {
                Notification.show(ex.getMessage(), 3000, Notification.Position.MIDDLE);
            }
        });

        Button deleteButton = new Button("Eliminar Venta", e -> {
            Venta selectedVenta = grid.getSelectedItems().stream().findFirst().orElse(null);
            if (selectedVenta != null) {
                ventaService.eliminarVenta(selectedVenta.getId());
                grid.setItems(ventaService.listarVentas());
                Notification.show("Venta eliminada exitosamente", 3000, Notification.Position.MIDDLE);
            } else {
                Notification.show("Por favor seleccione una venta para eliminar", 3000, Notification.Position.MIDDLE);
            }
        });

        Button refreshButton = new Button("Actualizar Lista", e -> {
            productoField.setItems(productoService.listarProductos());
            clienteField.setItems(usuarioService.listarUsuarios().stream()
                    .filter(u -> u.getTipo().equals("cliente"))
                    .toList());
            vendedorField.setItems(usuarioService.listarUsuarios().stream()
                    .filter(u -> u.getTipo().equals("vendedor"))
                    .toList());
            grid.setItems(ventaService.listarVentas());
            Notification.show("Lista actualizada", 3000, Notification.Position.MIDDLE);
        });

        // Agregar componentes a la vista
        HorizontalLayout header = new HorizontalLayout(productosButton, usuariosButton);
        HorizontalLayout formLayout = new HorizontalLayout(
                productoField, clienteField, vendedorField, cantidadField,
                saveButton, deleteButton, refreshButton);

        add(header, grid, formLayout);
        grid.setItems(ventaService.listarVentas());
    }

    private void clearFields(ComboBox<Producto> productoField, ComboBox<Usuario> clienteField,
            ComboBox<Usuario> vendedorField, IntegerField cantidadField) {
        productoField.clear();
        clienteField.clear();
        vendedorField.clear();
        cantidadField.clear();
    }
}