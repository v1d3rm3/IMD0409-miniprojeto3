package com.jeanlima.springrestapi.dto;

public class CriarPedidoDto {
    int clienteId;

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "CriarPedidoDto [clienteId=" + clienteId + "]";
    }

    
}
