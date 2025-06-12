package com.empresa.consultasavanzadas.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;

import com.empresa.consultasavanzadas.service.PedidoService;
import com.empresa.consultasavanzadas.domain.entity.Pedido;
import com.empresa.consultasavanzadas.domain.filter.PedidoFiltro;
import com.empresa.consultasavanzadas.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repo;
    private final EntityManager em;

    @Override
    public List<Pedido> obtenerUltimoPedidos() {
        LocalDate haceUnMes = LocalDate.now().minusMonths(1);
        return repo.ultimosPedidos(haceUnMes);
    }

    @Override
    public List<Object[]> obtenerTopProductos(int topN) {
        return repo.topProductos(PageRequest.of(0, topN));
    }

    @Override
    public List<Object[]> obtenerClientesFrecuentes(long minCompras) {
        return repo.clientesFrecuentes(minCompras);
    }

    @Override
    public Pedido crearPedido(Pedido pedido) {
        return repo.save(pedido);
    }

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        return repo.findAll();
    }

    @Override
    public List<Pedido> buscarDinamico(PedidoFiltro filtro) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Pedido> cq = cb.createQuery(Pedido.class);
        Root<Pedido> root = cq.from(Pedido.class);

        root.fetch("Cliente", JoinType.LEFT);
        root.fetch("detalle", JoinType.LEFT);

        List<Predicate> condiciones = new ArrayList<>();
        if (filtro.getFechaDesde() != null) {
            condiciones.add(cb.greaterThanOrEqualTo(root.get("fecha"), filtro.getFechaDesde()));
        }

        if (filtro.getTotalMin() != null) {
            condiciones.add(cb.ge(root.get("total"), filtro.getTotalMin()));
        }

        cq.where(cb.and(condiciones.toArray(new Predicate[0])));
        cq.distinct(true);

        return em.createQuery(cq).getResultList();

    }

    /*
     * @Override
     * public List<Pedido> obtenerPedidosOrdenados(String campo, String direccion) {
     * Sort sort = direccion.equalsIgnoreCase("DESC") ? Sort.by(campo).descending()
     * : Sort.by(campo).ascending();
     * return repo.findAll(sort);
     * }
     */
}
