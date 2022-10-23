package com.jeanlima.springrestapi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.model.ItemPedido;
import com.jeanlima.springrestapi.model.Pedido;

public class ClienteDetalhesPedidoDto {
    private Integer id;
    private Cliente cliente;
    private LocalDate dataPedido;
    private BigDecimal total;
    private List<ItemPedido> itens;

    static public List<ClienteDetalhesPedidoDto> from(Set<Pedido> pedidos) {
        return pedidos.stream().map(p -> {
            var n = new ClienteDetalhesPedidoDto();
            n.setId(p.getId());
            n.setDataPedido(p.getDataPedido());
            n.setTotal(p.getTotal());
            return n;
        }).toList();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    
}
