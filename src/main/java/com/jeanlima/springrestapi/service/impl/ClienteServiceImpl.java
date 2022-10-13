package com.jeanlima.springrestapi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.jeanlima.springrestapi.dto.PatchClienteDto;
import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.repository.ClienteRepository;
import com.jeanlima.springrestapi.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepo;

    public void atualizarCampos(int clienteId, PatchClienteDto params) {
        Optional<Cliente> clienteOptionalWrapper = clienteRepo.findById(clienteId);

        if (clienteOptionalWrapper.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Cliente não encontrado");
        } 

        Cliente cliente = clienteOptionalWrapper.get();

        if (params.getCpf() != null) {
            cliente.setCpf(params.getCpf());
        }

        if (params.getNome() != null) {
            cliente.setNome(params.getNome());
        }

        clienteRepo.save(cliente);
    }
}
