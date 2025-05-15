package com.proyecto.service;

import com.proyecto.models.Venta;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReporteService {

    public void resumenVentas(List<Venta> ventas) {
        DoubleSummaryStatistics stats = ventas.stream()
                .collect(Collectors.summarizingDouble(v -> v.getProducto().getPrecio() * v.getCantidad()));

        System.out.println("Total ventas: " + stats.getSum());
        System.out.println("Promedio: " + stats.getAverage());
        System.out.println("Máximo: " + stats.getMax());
    }

    public void ventasPorUsuario(List<Venta> ventas) {
        Map<Long, Double> porUsuario = ventas.stream()
                .collect(Collectors.groupingBy(
                        v -> v.getVendedor().getId(),
                        Collectors.summingDouble(v -> v.getProducto().getPrecio() * v.getCantidad())));
        porUsuario.forEach((id, total) -> System.out.println("Usuario ID: " + id + " - Total: $" + total));
    }

    public void ventasMayoresA(double umbral, List<Venta> ventas) {
        ventas.stream()
                .filter(v -> v.getProducto().getPrecio() * v.getCantidad() > umbral)
                .forEach(System.out::println);
    }
}
