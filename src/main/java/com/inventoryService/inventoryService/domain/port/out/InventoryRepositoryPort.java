package com.inventoryService.inventoryService.domain.port.out;

import com.inventoryService.inventoryService.domain.model.InventoryItem;

import java.util.List;
import java.util.Optional;

public interface InventoryRepositoryPort {

    InventoryItem save(InventoryItem item);
    Optional<InventoryItem> findById(String id);
    boolean existsById(String id);
    void deleteById(String id);
    List<InventoryItem> findAll();
    List<InventoryItem> findByType(InventoryItem.Type type);


}
