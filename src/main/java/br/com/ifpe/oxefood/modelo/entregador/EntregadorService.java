package br.com.ifpe.oxefood.modelo.entregador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    @Transactional
    public Entregador save(Entregador entregador) {

        entregador.setHabilitado(Boolean.TRUE);
        return repository.save(entregador);
    }

    public List<Entregador> listarTodos() {   //faz parte da consulta de todos os entregadores cadastrados (entregadorController)

        return repository.findAll();
    }

    public Entregador obterPorID(Long id) {  //faz parte da consulta por id os entregadores cadastrados (entregadorController)

        return repository.findById(id).get();
    }

    @Transactional
    public void update(Long id, Entregador clienteAlterado) {  // Implementando a Alteração (Cntroller.java e Service)

        Entregador entregador = repository.findById(id).get();
        entregador.setNome(clienteAlterado.getNome());
        entregador.setCpf(clienteAlterado.getCpf());
        entregador.setRg(clienteAlterado.getRg());
        entregador.setDataNascimento(clienteAlterado.getDataNascimento());
        entregador.setFoneCelular(clienteAlterado.getFoneCelular());
        entregador.setFoneFixo(clienteAlterado.getFoneFixo());
        entregador.setQtdEntregasRealizadas(clienteAlterado.getQtdEntregasRealizadas());
        entregador.setValorFrete(clienteAlterado.getValorFrete());
        entregador.setEnderecoRua(clienteAlterado.getEnderecoRua());
        entregador.setEnderecoComplemento(clienteAlterado.getEnderecoComplemento());
        entregador.setEnderecoNumero(clienteAlterado.getEnderecoNumero());
        entregador.setEnderecoBairro(clienteAlterado.getEnderecoBairro());
        entregador.setEnderecoCidade(clienteAlterado.getEnderecoCidade());

        entregador.setEnderecoCep(clienteAlterado.getEnderecoCep());
        entregador.setEnderecoUf(clienteAlterado.getEnderecoUf());

        repository.save(entregador);
    }

    @Transactional      // deletar/remover 
    public void delete(Long id) {

        Entregador entregador = repository.findById(id).get();
        entregador.setHabilitado(Boolean.FALSE);

        repository.save(entregador);
    }

}
