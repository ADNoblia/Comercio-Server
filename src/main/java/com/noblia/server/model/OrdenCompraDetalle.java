package com.noblia.server.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdenCompraDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrdenCompraDetalle;
    private Integer idOrdenCompraCabezera;
    private Integer idProducto;
    private Integer precio;
    private Integer cantidad;
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "IdOrdenComproCabecera")
    private OrdenCompraCabecera ordenCompraCabecera;

}
