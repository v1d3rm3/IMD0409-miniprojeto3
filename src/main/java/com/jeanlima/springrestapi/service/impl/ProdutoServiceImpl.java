package com.jeanlima.springrestapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jeanlima.springrestapi.dto.PatchProdutoDto;
import com.jeanlima.springrestapi.model.Produto;
import com.jeanlima.springrestapi.repository.ProdutoRepository;
import com.jeanlima.springrestapi.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepo;

    public void atualizarParcialmente(int produtoId, PatchProdutoDto params) {
        Optional<Produto> clienteOptionalWrapper = produtoRepo.findById(produtoId);

        if (clienteOptionalWrapper.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Produto não encontrado");
        }

        Produto produto = clienteOptionalWrapper.get();

        if (params.getDescricao() != null) {
            produto.setDescricao(params.getDescricao());
        }

        if (params.getPreco() != null) {
            produto.setPreco(params.getPreco());
        }

        produtoRepo.save(produto);
    }
}
