package com.inventoryService.inventoryService.infraestructure.adapters.out.persistence.entity;


import com.inventoryService.inventoryService.domain.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface JpaInventoryItemRepository extends JpaRepository<InventoryItemEntity, String> {

    List<InventoryItemEntity> findByType(String type);

}
