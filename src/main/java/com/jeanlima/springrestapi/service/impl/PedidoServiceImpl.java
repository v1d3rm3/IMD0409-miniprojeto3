package com.jeanlima.springrestapi.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeanlima.springrestapi.dto.CriarPedidoDto;
import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.model.Pedido;
import com.jeanlima.springrestapi.repository.ClienteRepository;
import com.jeanlima.springrestapi.repository.PedidoRepository;
import com.jeanlima.springrestapi.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void criar(CriarPedidoDto params) {
        
        System.out.println(params.toString());
        var pedido = new Pedido();
        var cliente = clienteRepository.findById(params.getClienteId()).get();
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        System.out.println(pedido.toString());

        pedidoRepository.save(pedido);
    }

    @Override
    public void remover(int pedidoId) {
        var pedido = pedidoRepository.findById(pedidoId).get();
        pedidoRepository.delete(pedido);
    }
}
