package com.jeanlima.springrestapi.service;

import com.jeanlima.springrestapi.dto.PatchProdutoDto;

public interface ProdutoService {
    void atualizarParcialmente(int produtoId, PatchProdutoDto params);
}
