package com.noblia.server.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrdenCompraCabecera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrdenCompraCabezera;
    private Integer idCliente;
    private Integer idVendedor;
    private Date fecha;
    private Date fechaEntrega;
    private String estado;
    private Integer monto;
    
    @OneToMany(mappedBy = "ordenCompraCabecera", cascade = CascadeType.ALL)
    private List<OrdenCompraDetalle> detalles;
    
}
