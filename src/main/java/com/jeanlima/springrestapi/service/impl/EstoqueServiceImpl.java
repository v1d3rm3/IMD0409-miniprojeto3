package com.jeanlima.springrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanlima.springrestapi.dto.CriarEstoqueDto;
import com.jeanlima.springrestapi.model.Estoque;
import com.jeanlima.springrestapi.repository.EstoqueRepository;
import com.jeanlima.springrestapi.repository.ProdutoRepository;
import com.jeanlima.springrestapi.service.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepo;    

    @Autowired
    ProdutoRepository produtoRepo;

    @Override
    public void criar(CriarEstoqueDto params) {
        var produto = produtoRepo.findById(params.getProdutoId()).get();
        estoqueRepo.save(params.toEstoque(produto));
    }

    @Override
    public void remover(int id) {
        var estoque = estoqueRepo.findById(id).get();
        estoqueRepo.delete(estoque);
    }

    @Override
    public void atualizarQuantidade(int estoqueId, int quantidade) {
        var estoque = estoqueRepo.findById(estoqueId).get();
        estoque.setQuantidade(quantidade);
        estoqueRepo.save(estoque);
    }

    @Override
    public List<Estoque> recuperarPorNomeDeProduto(String nome) {
        return estoqueRepo.recuperarPorNomeDeProduto(nome);
    }

    @Override
    public List<Estoque> listar() {
        return estoqueRepo.findAll();
    }
    
}
