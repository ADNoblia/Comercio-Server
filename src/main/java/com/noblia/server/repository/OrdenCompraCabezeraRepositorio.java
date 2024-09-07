package com.noblia.server.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.noblia.server.model.OrdenCompraCabecera;

public interface OrdenCompraCabezeraRepositorio extends JpaRepository<OrdenCompraCabecera, Integer>{
    List<OrdenCompraCabecera> findByIdCliente(Integer idCliente);
    List<OrdenCompraCabecera> findByFechaBetween(Date startDate, Date endDate);
}
