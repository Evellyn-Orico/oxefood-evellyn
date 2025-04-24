package br.com.ifpe.oxefood.modelo.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Transactional
    public Produto save(Produto produto) {

       produto.setHabilitado(Boolean.TRUE);
       return repository.save(produto);
    }


        public List<Produto> listarTodos() {   //faz parte da consulta de todos os produtos cadastrados (produtoController)

        return repository.findAll();
    }

    public Produto obterPorID(Long id) {  //faz parte da consulta por id os produtos cadastrados (produtoController)

        return repository.findById(id).get();
    }


    
}
