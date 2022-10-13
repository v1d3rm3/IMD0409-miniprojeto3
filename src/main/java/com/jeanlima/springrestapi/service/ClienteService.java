package com.jeanlima.springrestapi.service;

import com.jeanlima.springrestapi.dto.PatchClienteDto;

public interface ClienteService {
    public void atualizarCampos(int clienteId, PatchClienteDto params);
}
