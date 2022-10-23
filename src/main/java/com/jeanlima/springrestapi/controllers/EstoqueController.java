package com.jeanlima.springrestapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jeanlima.springrestapi.dto.AtualizarQuantidadeEstoqueDto;
import com.jeanlima.springrestapi.dto.CriarEstoqueDto;
import com.jeanlima.springrestapi.model.Estoque;
import com.jeanlima.springrestapi.service.impl.EstoqueServiceImpl;

@RequestMapping("/api/estoques")
@RestController 
public class EstoqueController {
    
    @Autowired
    private EstoqueServiceImpl service;

    @GetMapping
    public List<Estoque> listar() {
        return service.listar();
    }

    @GetMapping("produto")
    @ResponseStatus(HttpStatus.OK)
    public List<Estoque> recuperarPorNomeDeProduto(@RequestParam String nomeProduto){
        return service.recuperarPorNomeDeProduto(nomeProduto);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody CriarEstoqueDto params){
        service.criar(params);
    }

    @PatchMapping
    public void atualizarQuantidade(@RequestBody AtualizarQuantidadeEstoqueDto params) {
        service.atualizarQuantidade(params.getEstoqueId(), params.getQuantidade());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void remover(@PathVariable Integer id){
        service.remover(id);
    }
}
