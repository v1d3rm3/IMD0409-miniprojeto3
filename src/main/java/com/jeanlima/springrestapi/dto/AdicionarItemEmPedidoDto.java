package com.jeanlima.springrestapi.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class AdicionarItemEmPedidoDto {
    private int pedidoId;
    private int produtoId;
    private int quantidade;
}
