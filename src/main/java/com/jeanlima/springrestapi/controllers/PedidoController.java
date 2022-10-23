
package com.jeanlima.springrestapi.controllers;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jeanlima.springrestapi.dto.CriarPedidoDto;
import com.jeanlima.springrestapi.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    
    @PostMapping
    @ResponseStatus(CREATED)
    public void criar(@RequestBody CriarPedidoDto params) {
        service.criar(params);
    }

    @DeleteMapping("{id}")
    public void remover(@PathVariable Integer id) {
        service.remover(id);
    }
}
