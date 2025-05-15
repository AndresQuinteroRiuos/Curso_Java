package com.proyecto.view;

import com.proyecto.models.Venta;
import com.proyecto.models.Usuario;
import com.proyecto.service.VentaService;
import com.proyecto.service.UsuarioService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.stereotype.Component;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Route(value = "reportes", layout = MainLayout.class)
public class ReporteView extends VerticalLayout {

    private final VentaService ventaService;
    private final UsuarioService usuarioService;
    private final Grid<Venta> grid = new Grid<>(Venta.class);
    private final TextField totalVentasField = new TextField("Total Ventas");
    private final TextField promedioVentasField = new TextField("Promedio por Venta");
    private final TextField ventaMaximaField = new TextField("Venta Máxima");
    private final TextField ventaMinimaField = new TextField("Venta Mínima");

    public ReporteView(VentaService ventaService, UsuarioService usuarioService) {
        this.ventaService = ventaService;
        this.usuarioService = usuarioService;

        setSizeFull();
        setupView();
        actualizarEstadisticas();
    }

    private void setupView() {
        // Configurar grid
        grid.setColumns("id", "producto", "cliente", "vendedor", "cantidad", "fecha");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        // Configurar campos de estadísticas
        totalVentasField.setReadOnly(true);
        promedioVentasField.setReadOnly(true);
        ventaMaximaField.setReadOnly(true);
        ventaMinimaField.setReadOnly(true);

        // Crear botones
        Button productosButton = new Button("Ir a Productos", e -> {
            getUI().ifPresent(ui -> ui.navigate("productos"));
        });

        Button ventasButton = new Button("Ir a Ventas", e -> {
            getUI().ifPresent(ui -> ui.navigate("ventas"));
        });

        Button usuariosButton = new Button("Ir a Usuarios", e -> {
            getUI().ifPresent(ui -> ui.navigate("usuarios"));
        });

        Button ventasPorVendedorButton = new Button("Ventas por Vendedor", e -> {
            mostrarVentasPorVendedor();
        });

        Button ventasPorClienteButton = new Button("Ventas por Cliente", e -> {
            mostrarVentasPorCliente();
        });

        Button refreshButton = new Button("Actualizar Reportes", e -> {
            actualizarEstadisticas();
            grid.setItems(ventaService.listarVentas());
        });

        // Agregar componentes a la vista
        HorizontalLayout header = new HorizontalLayout(productosButton, ventasButton, usuariosButton);
        HorizontalLayout statsLayout = new HorizontalLayout(
                totalVentasField, promedioVentasField, ventaMaximaField, ventaMinimaField);
        HorizontalLayout buttonsLayout = new HorizontalLayout(
                ventasPorVendedorButton, ventasPorClienteButton, refreshButton);

        add(header, statsLayout, buttonsLayout, grid);
        grid.setItems(ventaService.listarVentas());
    }

    private void actualizarEstadisticas() {
        List<Venta> ventas = ventaService.listarVentas();
        DoubleSummaryStatistics stats = ventas.stream()
                .collect(Collectors.summarizingDouble(v -> v.getProducto().getPrecio() * v.getCantidad()));

        totalVentasField.setValue(String.format("$%.2f", stats.getSum()));
        promedioVentasField.setValue(String.format("$%.2f", stats.getAverage()));
        ventaMaximaField.setValue(String.format("$%.2f", stats.getMax()));
        ventaMinimaField.setValue(String.format("$%.2f", stats.getMin()));
    }

    private void mostrarVentasPorVendedor() {
        List<Venta> ventas = ventaService.listarVentas();
        Map<Usuario, Double> ventasPorVendedor = ventas.stream()
                .collect(Collectors.groupingBy(
                        Venta::getVendedor,
                        Collectors.summingDouble(v -> v.getProducto().getPrecio() * v.getCantidad())));

        StringBuilder reporte = new StringBuilder("Ventas por Vendedor:\n");
        ventasPorVendedor.forEach(
                (vendedor, total) -> reporte.append(String.format("%s: $%.2f\n", vendedor.getNombre(), total)));

        grid.setItems(ventas.stream()
                .sorted((v1, v2) -> v1.getVendedor().getNombre().compareTo(v2.getVendedor().getNombre()))
                .toList());
    }

    private void mostrarVentasPorCliente() {
        List<Venta> ventas = ventaService.listarVentas();
        Map<Usuario, Double> ventasPorCliente = ventas.stream()
                .collect(Collectors.groupingBy(
                        Venta::getCliente,
                        Collectors.summingDouble(v -> v.getProducto().getPrecio() * v.getCantidad())));

        StringBuilder reporte = new StringBuilder("Ventas por Cliente:\n");
        ventasPorCliente
                .forEach((cliente, total) -> reporte.append(String.format("%s: $%.2f\n", cliente.getNombre(), total)));

        grid.setItems(ventas.stream()
                .sorted((v1, v2) -> v1.getCliente().getNombre().compareTo(v2.getCliente().getNombre()))
                .toList());
    }
}