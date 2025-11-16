package com.inventoryService.inventoryService.application.useCase;

import com.inventoryService.inventoryService.domain.model.InventoryItem;
import com.inventoryService.inventoryService.domain.port.in.InventoryUseCase;
import com.inventoryService.inventoryService.domain.port.out.InventoryRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;



public class InventoryUseCaseImpl implements InventoryUseCase {


    private final InventoryRepositoryPort inventoryRepositoryPort;


    public InventoryUseCaseImpl(InventoryRepositoryPort inventoryRepositoryPort) {
        this.inventoryRepositoryPort = inventoryRepositoryPort;
    }

    @Override
    public InventoryItem createItem(InventoryItem item) {
        return null;
    }

    @Override
    public InventoryItem updateItem(String id, InventoryItem item) {
        return null;
    }

    @Override
    public InventoryItem getItem(String id) {
        return null;
    }

    @Override
    public void deleteItem(String id) {

    }

    @Override
    public List<InventoryItem> listAll() {
        return null;
    }

    @Override
    public List<InventoryItem> listByType(InventoryItem.Type type) {
        return null;
    }

    @Override
    public InventoryItem adjustStock(String id, int delta) {
        return null;
    }
}
