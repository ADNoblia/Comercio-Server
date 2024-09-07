package com.noblia.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noblia.server.model.Vendedor;
import com.noblia.server.service.VendedorServicio;

@RestController
@RequestMapping("/api/vendedores")
public class VendedorController {

    @Autowired
    private VendedorServicio vendedorServicio;

    @GetMapping
    public List<Vendedor> listarVendedores() {
        return vendedorServicio.listarVendedores();
    }

    @GetMapping("/{id}")
    public Vendedor obtenerVendedor(@PathVariable Integer id) {
        return vendedorServicio.obtenerVendedorPorId(id);
    }

    @PostMapping
    public Vendedor crearVendedor(@RequestBody Vendedor vendedor) {
        return vendedorServicio.guardarVendedor(vendedor);
    }

    @DeleteMapping("/{id}")
    public void eliminarVendedor(@PathVariable Integer id) {
        vendedorServicio.eliminarVendedor(id);
    }
}
