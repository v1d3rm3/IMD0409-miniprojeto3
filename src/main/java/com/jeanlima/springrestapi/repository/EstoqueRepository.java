package com.jeanlima.springrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeanlima.springrestapi.model.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque,Integer>{

    @Query("SELECT e FROM Estoque e LEFT JOIN FETCH e.produto p WHERE p.descricao LIKE CONCAT(CONCAT('%', :nome), '%')")
    List<Estoque> recuperarPorNomeDeProduto(@Param("nome") String nome);

    @Query("SELECT e FROM Estoque e LEFT JOIN FETCH e.produto p WHERE p.id = :id")
    Estoque recuperarEstoquePorProdutoId(@Param("id") int id);
}
