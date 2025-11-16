package com.inventoryService.inventoryService.infraestructure.adapters.config;

import com.inventoryService.inventoryService.application.service.InventoryService;
import com.inventoryService.inventoryService.application.useCase.InventoryUseCaseImpl;
import com.inventoryService.inventoryService.domain.port.in.InventoryUseCase;
import com.inventoryService.inventoryService.domain.port.out.InventoryRepositoryPort;
import com.inventoryService.inventoryService.infraestructure.adapters.out.persistence.entity.JpaInventoryItemRepository;
import org.springframework.context.annotation.Bean;

public class ApplicationConfig {

    @Bean
    public InventoryService inventoryService(InventoryRepositoryPort inventoryRepositoryPort, /*ClassCliem classClient*/
            InventoryUseCase inventoryUseCase, JpaInventoryItemRepository jpaInventoryItemRepository){

        return new InventoryService(
                new InventoryUseCaseImpl(inventoryRepositoryPort)
        );
    }









}
