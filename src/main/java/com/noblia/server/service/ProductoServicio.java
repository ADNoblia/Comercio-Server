package com.noblia.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.noblia.server.model.Producto;
import com.noblia.server.repository.ProductoRepositorio;

@Service
public class ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    public List<Producto> listaProductos() {
        return productoRepositorio.findAll();
    }

    public Producto obtenerProductoPorId(Integer id) {
        return productoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public void eliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }
}
