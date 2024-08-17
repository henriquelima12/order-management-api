package com.example.orderapi.controllers;

import java.time.LocalDateTime;
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

import com.example.orderapi.entities.Pedido;
import com.example.orderapi.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.getPedidoById(id);
        return pedido.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        pedido.setDataPedido(LocalDateTime.now());
        Pedido createdPedido = pedidoService.savePedido(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        if (!pedidoService.getPedidoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pedido.setId(id);
        Pedido updatedPedido = pedidoService.savePedido(pedido);
        return ResponseEntity.ok(updatedPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        if (!pedidoService.getPedidoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
    
}
