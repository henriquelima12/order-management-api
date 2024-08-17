package com.example.orderapi.entities;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens_pedidos")
@Getter
@Setter
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @OneToOne
    @JoinColumn(name = "id_item", nullable = false)
    private Item item;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;
    
}
