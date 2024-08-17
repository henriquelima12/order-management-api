package com.example.orderapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderapi.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
