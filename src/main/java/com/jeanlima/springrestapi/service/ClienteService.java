package com.jeanlima.springrestapi.service;

import com.jeanlima.springrestapi.dto.PatchClienteDto;
import com.jeanlima.springrestapi.model.Cliente;

public interface ClienteService {
    public void atualizarCampos(int clienteId, PatchClienteDto params);
    public Cliente recuperarClienteMaisDetalhesCompletos(int clienteId);
}
