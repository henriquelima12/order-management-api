package com.example.orderapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderapi.entities.ItemPedido;
import com.example.orderapi.services.ItemPedidoService;

@RestController
@RequestMapping("/itens-pedidos")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public List<ItemPedido> getAllItems() {
        return itemPedidoService.getAllItems();
    }

    @GetMapping("/pedido/{pedidoId}")
    public List<ItemPedido> getItemsByPedidoId(@PathVariable Long pedidoId) {
        return itemPedidoService.getItemsByPedidoId(pedidoId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> getItemById(@PathVariable Long id) {
        Optional<ItemPedido> itemPedido = itemPedidoService.getItemById(id);
        return itemPedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemPedido> createItem(@RequestBody ItemPedido itemPedido) {
        ItemPedido createdItem = itemPedidoService.saveItem(itemPedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemPedido> updateItem(@PathVariable Long id, @RequestBody ItemPedido itemPedido) {
        if (!itemPedidoService.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemPedido.setId(id);
        ItemPedido updatedItem = itemPedidoService.saveItem(itemPedido);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (!itemPedidoService.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemPedidoService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
    
}
