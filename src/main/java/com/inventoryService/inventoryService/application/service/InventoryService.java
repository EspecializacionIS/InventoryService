package com.inventoryService.inventoryService.application.service;


import com.inventoryService.inventoryService.domain.exception.NotFoundException;
import com.inventoryService.inventoryService.domain.model.InventoryItem;
import com.inventoryService.inventoryService.domain.port.in.InventoryUseCase;
import com.inventoryService.inventoryService.domain.port.out.InventoryRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService implements InventoryUseCase {

    private final InventoryUseCase inventoryUseCase;

    @Override
    public InventoryItem createItem(InventoryItem item) {

        return inventoryUseCase.createItem(item);
    }

    @Override
    public InventoryItem updateItem(String id, InventoryItem item) {

        return inventoryUseCase.updateItem(id,item);
    }

    @Override
    public InventoryItem getItem(String id) {
        return inventoryUseCase.getItem(id);
    }

    @Override
    public void deleteItem(String id) {throw new NotFoundException("Item no encontrado: " + id);
    }

    @Override
    public List<InventoryItem> listAll() {
        return inventoryUseCase.listAll();
    }

    @Override
    public List<InventoryItem> listByType(InventoryItem.Type type) {

        return listByType(type);
    }

    @Override
    public InventoryItem adjustStock(String id, int delta) {

        return inventoryUseCase.adjustStock(id,delta);
    }

}
