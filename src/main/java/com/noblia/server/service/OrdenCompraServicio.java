package com.noblia.server.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noblia.server.model.OrdenCompraCabecera;
import com.noblia.server.model.OrdenCompraDetalle;
import com.noblia.server.repository.OrdenCompraCabezeraRepositorio;
import com.noblia.server.repository.OrdenCompraDetalleRepositorio;

@Service
public class OrdenCompraServicio {

    @Autowired
    private OrdenCompraCabezeraRepositorio ordenCompraCabezeraRepositorio;

    @Autowired
    private OrdenCompraDetalleRepositorio ordenCompraDetalleRepositorio;

    public List<OrdenCompraCabecera> listarOrdenesPorCliente(Integer idCliente) {
        return ordenCompraCabezeraRepositorio.findByIdCliente(idCliente);
    }

    public List<OrdenCompraCabecera> listarOrdenesPorRangoFechas(Date fechaInicio, Date fechaFin) {
        return ordenCompraCabezeraRepositorio.findByFechaBetween(fechaInicio, fechaFin);
    }

    public OrdenCompraCabecera crearOrden(OrdenCompraCabecera orden, List<OrdenCompraDetalle> detalles) {
        ordenCompraCabezeraRepositorio.save(orden);
        for (OrdenCompraDetalle detalle : detalles) {
            detalle.setIdOrdenCompraDetalle(orden.getIdOrdenCompraCabezera());
            ordenCompraDetalleRepositorio.save(detalle);
        }
        return orden;
    }

    public OrdenCompraCabecera actualizarEstadoOrden(Integer idOrden, String estado) {
        OrdenCompraCabecera orden = ordenCompraCabezeraRepositorio.findById(idOrden)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));
        orden.setEstado(estado);
        return ordenCompraCabezeraRepositorio.save(orden);
    }

    public void eliminarOrden(Integer idOrden) {
        ordenCompraCabezeraRepositorio.deleteById(idOrden);
    }
}
