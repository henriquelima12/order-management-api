package com.example.orderapi.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "itens")
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", unique = true, length = 200, nullable = false)
    private String nome;

    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;
    
}
