package com.jeanlima.springrestapi.dto;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.model.Pedido;

public class ClienteDetalhesCompletaDto {
    private int id;
    private String nome;
    private String cpf;
    private List<ClienteDetalhesPedidoDto> pedidos;

    static public ClienteDetalhesCompletaDto from(Cliente cliente) {
        var cli = new ClienteDetalhesCompletaDto();
        cli.cpf = cliente.getCpf();
        cli.id = cliente.getId();
        cli.nome = cliente.getNome();
        cli.setPedidos(ClienteDetalhesPedidoDto.from(cliente.getPedidos()));
        return cli;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ClienteDetalhesPedidoDto> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ClienteDetalhesPedidoDto> pedidos) {
        this.pedidos = pedidos;
    }
}
