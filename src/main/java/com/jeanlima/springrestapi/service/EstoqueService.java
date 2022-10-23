package com.jeanlima.springrestapi.service;

import java.util.List;

import com.jeanlima.springrestapi.dto.CriarEstoqueDto;
import com.jeanlima.springrestapi.model.Estoque;

public interface EstoqueService {
    public void criar(CriarEstoqueDto params);

    public List<Estoque> listar();

    public void remover(int id);

    public void atualizarQuantidade(int estoqueId, int quantidade);

    public List<Estoque> recuperarPorNomeDeProduto(String nome);
}
