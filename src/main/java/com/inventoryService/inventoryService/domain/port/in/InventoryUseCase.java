package com.inventoryService.inventoryService.domain.port.in;

import com.inventoryService.inventoryService.domain.model.InventoryItem;

import java.util.List;
import java.util.Optional;

public interface InventoryUseCase {

    InventoryItem createItem(InventoryItem item);
    InventoryItem updateItem(String id, InventoryItem item);
    Optional<InventoryItem> getItem(String id);
    void deleteItem(String id);
    List<InventoryItem> listAll();
    List<InventoryItem> listByType(InventoryItem.Type type);
    InventoryItem adjustStock(String id, int delta);


}
