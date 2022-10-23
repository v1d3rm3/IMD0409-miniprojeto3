package com.jeanlima.springrestapi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //Um cliente pode ter muitos pedidos!
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column
    private LocalDate dataPedido;

    //1000.00
    @Column(name = "total", precision = 20,scale = 2)
    private BigDecimal total = new BigDecimal(0);


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemPedido> itens = new ArrayList<ItemPedido>();

    public void adicionarItem(Produto produto, int quantidade) {
        var itemPedido = new ItemPedido();
        itemPedido.setPedido(this);
        itemPedido.setProduto(produto);
        itemPedido.setQuantidade(quantidade);
        this.itens.add(itemPedido);
        System.out.println("TOTAL");
        System.out.println(total);
        this.total = BigDecimal.valueOf(quantidade).multiply(produto.getPreco()).add(this.total);
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
    
    public BigDecimal getTotal() {
        return total;
    }
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    public LocalDate getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }
    public List<ItemPedido> getItens() {
        return itens;
    }
    // public void setItens(List<ItemPedido> itens) {
    //     this.itens = itens;
    // }
    @Override
    public String toString() {
        return "Pedido [dataPedido=" + dataPedido + ", id=" + id + ", total=" + total + ", cliente=" + cliente.getId() + "]";
    }

    
    

    
    
}
