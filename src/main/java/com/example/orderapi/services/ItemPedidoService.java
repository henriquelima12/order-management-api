package com.example.orderapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderapi.entities.ItemPedido;
import com.example.orderapi.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> getAllItems() {
        return itemPedidoRepository.findAll();
    }

    public List<ItemPedido> getItemsByPedidoId(Long pedidoId) {
        return itemPedidoRepository.findByPedidoId(pedidoId);
    }

    public Optional<ItemPedido> getItemById(Long id) {
        return itemPedidoRepository.findById(id);
    }

    public ItemPedido saveItem(ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    public void deleteItem(Long id) {
        itemPedidoRepository.deleteById(id);
    }
    
}
