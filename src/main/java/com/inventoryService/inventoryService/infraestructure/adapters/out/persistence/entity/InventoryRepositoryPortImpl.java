package com.inventoryService.inventoryService.infraestructure.adapters.out.persistence.entity;

import com.inventoryService.inventoryService.application.service.InventoryItemMapper;
import com.inventoryService.inventoryService.domain.model.InventoryItem;
import com.inventoryService.inventoryService.domain.port.out.InventoryRepositoryPort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class InventoryRepositoryPortImpl implements InventoryRepositoryPort {

    private final JpaInventoryItemRepository jpaRepo;
    private final InventoryItemMapper mapper;


    @Override
    public InventoryItem save(InventoryItem item) {
        InventoryItemEntity entity = mapper.toEntity(item);
        InventoryItemEntity saved = jpaRepo.save(entity);
        return mapper.toModel(saved);
    }

    @Override
    public Optional<InventoryItem> findById(String id) {
        return jpaRepo.findById(id).map(mapper::toModel);
    }

    @Override
    public boolean existsById(String id) { return jpaRepo.existsById(id); }

    @Override
    public void deleteById(String id) { jpaRepo.deleteById(id); }

    @Override
    public List<InventoryItem> findAll() {
        return jpaRepo.findAll().stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public List<InventoryItem> findByType(InventoryItem.Type type) {
        return jpaRepo.findByType(type.name()).stream().map(mapper::toModel).collect(Collectors.toList());
    }
}


