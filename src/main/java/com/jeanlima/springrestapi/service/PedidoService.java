package com.jeanlima.springrestapi.service;

import com.jeanlima.springrestapi.dto.AdicionarItemEmPedidoDto;
import com.jeanlima.springrestapi.dto.CriarPedidoDto;

public interface PedidoService {
    public void criar(CriarPedidoDto params);
    public void remover(int pedidoId);
    public void AdicionarItemEmPedido(AdicionarItemEmPedidoDto params);
}
