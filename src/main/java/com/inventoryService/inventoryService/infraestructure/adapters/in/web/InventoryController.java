package com.inventoryService.inventoryService.infraestructure.adapters.in.web;

import com.inventoryService.inventoryService.infraestructure.adapters.out.persistence.entity.InventoryItemEntity;
import com.inventoryService.inventoryService.infraestructure.adapters.out.persistence.entity.JpaInventoryItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
public class InventoryController {

    private final JpaInventoryItemRepository repository;


    @PostMapping
    public ResponseEntity<InventoryItemEntity> create(@RequestBody InventoryItemEntity item) {
        InventoryItemEntity saved = repository.save(item);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<InventoryItemEntity>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItemEntity> getById(@PathVariable String id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItemEntity> update(@PathVariable String id, @RequestBody InventoryItemEntity updatedItem) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(updatedItem.getName());
                    existing.setStock(updatedItem.getStock());
                    existing.setCost(updatedItem.getCost());
                    existing.setType(updatedItem.getType());
                    return ResponseEntity.ok(repository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
