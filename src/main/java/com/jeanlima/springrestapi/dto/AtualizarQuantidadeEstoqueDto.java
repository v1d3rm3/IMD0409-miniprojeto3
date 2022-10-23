package com.jeanlima.springrestapi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AtualizarQuantidadeEstoqueDto {
    int estoqueId;
    int quantidade;
}
