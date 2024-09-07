package com.noblia.server.service;

import com.noblia.server.repository.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.noblia.server.model.Vendedor;

@Service
public class VendedorServicio {
    @Autowired
    private VendedorRepositorio vendedorRepositorio;

    public List<Vendedor> listarVendedores() {
        return vendedorRepositorio.findAll();
    }

    public Vendedor obtenerVendedorPorId(Integer id) {
        return vendedorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
    }

    public Vendedor guardarVendedor(Vendedor vendedor) {
        return vendedorRepositorio.save(vendedor);
    }

    public void eliminarVendedor(Integer id) {
        vendedorRepositorio.deleteById(id);
    }
}
