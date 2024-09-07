package com.noblia.server.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.noblia.server.model.OrdenCompraCabecera;
import com.noblia.server.model.OrdenCompraDetalle;
import com.noblia.server.service.OrdenCompraServicio;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraServicio ordenCompraServicio;

    // Listar órdenes por cliente
    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<OrdenCompraCabecera>> listarOrdenesPorCliente(@PathVariable Integer idCliente) {
        List<OrdenCompraCabecera> ordenes = ordenCompraServicio.listarOrdenesPorCliente(idCliente);
        if (ordenes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    // Listar órdenes por rango de fechas
    @GetMapping("/fechas")
    public ResponseEntity<List<OrdenCompraCabecera>> listarOrdenesPorRangoFechas(
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {
        List<OrdenCompraCabecera> ordenes = ordenCompraServicio.listarOrdenesPorRangoFechas(fechaInicio, fechaFin);
        if (ordenes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ordenes, HttpStatus.OK);
    }

    // Crear una nueva orden
    @PostMapping("/nueva")
    public ResponseEntity<OrdenCompraCabecera> crearOrden(@RequestBody OrdenCompraCabecera orden) {
        List<OrdenCompraDetalle> detalles = orden.getDetalles();
        OrdenCompraCabecera nuevaOrden = ordenCompraServicio.crearOrden(orden, detalles);
        return new ResponseEntity<>(nuevaOrden, HttpStatus.CREATED);
    }

    // Actualizar el estado de una orden
    @PutMapping("/actualizar/{idOrden}")
    public ResponseEntity<OrdenCompraCabecera> actualizarEstadoOrden(@PathVariable Integer idOrden, @RequestBody String estado) {
        OrdenCompraCabecera ordenActualizada = ordenCompraServicio.actualizarEstadoOrden(idOrden, estado);
        return new ResponseEntity<>(ordenActualizada, HttpStatus.OK);
    }

    // Eliminar una orden
    @DeleteMapping("/eliminar/{idOrden}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable Integer idOrden) {
        ordenCompraServicio.eliminarOrden(idOrden);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
