package com.inventoryService.inventoryService.application.mapper;


import com.inventoryService.inventoryService.domain.model.InventoryItem;
import com.inventoryService.inventoryService.infraestructure.adapters.out.persistence.entity.InventoryItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryItemMapper {

    InventoryItem toModel(InventoryItemEntity nannyCarEntity);

    InventoryItemEntity toEntity(InventoryItem nannyCar);


}
