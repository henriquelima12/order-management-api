package com.example.orderapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderapi.entities.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
