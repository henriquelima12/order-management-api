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

import com.example.orderapi.entities.Item;
import com.example.orderapi.services.ItemService;

@RestController
@RequestMapping("itens")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Optional<Item> Item = itemService.getItemById(id);
        return Item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item Item) {
        Item createdItem = itemService.saveItem(Item);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item Item) {
        if (!itemService.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Item.setId(id);
        Item updatedItem = itemService.saveItem(Item);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (!itemService.getItemById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

}
