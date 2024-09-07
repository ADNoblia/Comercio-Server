package com.noblia.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.noblia.server.model.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer>{
    
}
