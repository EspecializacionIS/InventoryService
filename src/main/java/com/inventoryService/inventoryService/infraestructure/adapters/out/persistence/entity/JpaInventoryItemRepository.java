package com.inventoryService.inventoryService.infraestructure.adapters.out.persistence.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface JpaInventoryItemRepository extends JpaRepository<InventoryItemEntity, String> {

    List<InventoryItemEntity> findByType(String type);

}
