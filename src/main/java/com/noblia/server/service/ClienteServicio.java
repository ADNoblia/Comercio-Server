package com.noblia.server.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.noblia.server.model.Cliente;
import com.noblia.server.repository.ClienteRepositorio;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    public Cliente obtenerClientePorId(Integer id) {
        return clienteRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }

    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public void eliminarCliente(Integer id) {
        clienteRepositorio.deleteById(id);
    }
}
