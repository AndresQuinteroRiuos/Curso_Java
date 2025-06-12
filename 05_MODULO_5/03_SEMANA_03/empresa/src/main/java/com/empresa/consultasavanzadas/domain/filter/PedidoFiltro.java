package com.empresa.consultasavanzadas.domain.filter;

import java.time.LocalDate;

public class PedidoFiltro {

    private LocalDate fechaDesde;

    private Double totalMin;

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesDate) {
        this.fechaDesde = fechaDesDate;
    }

    public Double getTotalMin() {
        return totalMin;
    }

    public void setTotalMin(Double totalMin) {
        this.totalMin = totalMin;
    }

}
