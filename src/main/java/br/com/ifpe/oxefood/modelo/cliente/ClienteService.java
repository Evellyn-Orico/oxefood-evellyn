package br.com.ifpe.oxefood.modelo.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente save(Cliente cliente) {

       cliente.setHabilitado(Boolean.TRUE);
       return repository.save(cliente);
    }

    public List<Cliente> listarTodos() {   //faz parte da consulta de todos os clientes cadastrados (clienteController)

        return repository.findAll();
    }

    public Cliente obterPorID(Long id) {  //faz parte da consulta por id os clientes cadastrados (clienteController)

        return repository.findById(id).get();
    }


}
