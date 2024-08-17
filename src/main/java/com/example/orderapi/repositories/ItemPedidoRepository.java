package com.example.orderapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderapi.entities.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {

    List<ItemPedido> findByPedidoId(Long pedidoId);

}
