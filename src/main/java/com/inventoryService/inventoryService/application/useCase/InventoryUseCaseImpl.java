package com.inventoryService.inventoryService.application.useCase;

import com.inventoryService.inventoryService.domain.model.InventoryItem;
import com.inventoryService.inventoryService.domain.port.in.InventoryUseCase;
import com.inventoryService.inventoryService.domain.port.out.InventoryRepositoryPort;

import java.util.List;
import java.util.Optional;


public class InventoryUseCaseImpl implements InventoryUseCase {


    private final InventoryRepositoryPort inventoryRepositoryPort;


    public InventoryUseCaseImpl(InventoryRepositoryPort inventoryRepositoryPort) {
        this.inventoryRepositoryPort = inventoryRepositoryPort;
    }

    @Override
    public InventoryItem createItem(InventoryItem item) {
        return inventoryRepositoryPort.save(item);
    }

    @Override
    public InventoryItem updateItem(String id, InventoryItem item) {
        Optional<InventoryItem> existing = inventoryRepositoryPort.findById(id);

        if (existing.isEmpty()) {
            throw new RuntimeException("Item with id " + id + " not found");
        }

        InventoryItem current = existing.get();

        current.setName(item.getName());
        current.setType(item.getType());
        current.setCost(item.getCost());
        current.setStock(item.getStock());

        return inventoryRepositoryPort.save(current);
    }

    @Override
    public Optional<InventoryItem> getItem(String id) {
        return inventoryRepositoryPort.findById(id);
    }

    @Override
    public void deleteItem(String id) {
        if (inventoryRepositoryPort.findById(id).isEmpty()) {
            throw new RuntimeException("Cannot delete: item with id " + id + " does not exist");
        }
        inventoryRepositoryPort.deleteById(id);
    }

    @Override
    public List<InventoryItem> listAll() {

       return inventoryRepositoryPort.findAll();

    }

    @Override
    public List<InventoryItem> listByType(InventoryItem.Type type) {
        return inventoryRepositoryPort.findByType(type);
    }

    @Override
    public InventoryItem adjustStock(String id, int delta) {
        Optional<InventoryItem> existing = inventoryRepositoryPort.findById(id);

        if (existing.isEmpty()) {
            throw new RuntimeException("Item with id " + id + " not found");
        }

        InventoryItem item = existing.get();
        int newStock = item.getStock() + delta;

        if (newStock < 0) {
            throw new RuntimeException("Stock cannot be negative");
        }

        item.setStock(newStock);

        return inventoryRepositoryPort.save(item);
    }

}
