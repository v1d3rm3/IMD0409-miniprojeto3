package com.jeanlima.springrestapi.service.impl;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanlima.springrestapi.dto.AdicionarItemEmPedidoDto;
import com.jeanlima.springrestapi.dto.CriarPedidoDto;
import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.model.ItemPedido;
import com.jeanlima.springrestapi.model.Pedido;
import com.jeanlima.springrestapi.repository.ClienteRepository;
import com.jeanlima.springrestapi.repository.EstoqueRepository;
import com.jeanlima.springrestapi.repository.PedidoRepository;
import com.jeanlima.springrestapi.repository.ProdutoRepository;
import com.jeanlima.springrestapi.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepo;

    @Autowired
    private EstoqueRepository estoqueRepo;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void criar(CriarPedidoDto params) {
        var pedido = new Pedido();
        var cliente = clienteRepository.findById(params.getClienteId()).get();
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedidoRepository.save(pedido);
    }

    @Override
    public void remover(int pedidoId) {
        var pedido = pedidoRepository.findById(pedidoId).get();
        pedidoRepository.delete(pedido);
    }

    @Override
    @Transactional
    public void AdicionarItemEmPedido(AdicionarItemEmPedidoDto params) {
        var pedido = pedidoRepository.findById(params.getPedidoId()).get();
        var produto = produtoRepo.findById(params.getProdutoId()).get();
        var estoque = estoqueRepo.recuperarEstoquePorProdutoId(produto.getId());
        estoque.reservarQuantidade(params.getQuantidade());
        estoqueRepo.save(estoque);
        pedido.adicionarItem(produto, params.getQuantidade());
        pedidoRepository.save(pedido);
    }
}
