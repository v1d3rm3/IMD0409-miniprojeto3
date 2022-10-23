package com.jeanlima.springrestapi.dto;

import com.jeanlima.springrestapi.model.Estoque;
import com.jeanlima.springrestapi.model.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class CriarEstoqueDto {
    private Integer quantidade;
    private Integer produtoId;

    public Estoque toEstoque(Produto produto) {
        var estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setQuantidade(quantidade);
        return estoque;
    }
}
