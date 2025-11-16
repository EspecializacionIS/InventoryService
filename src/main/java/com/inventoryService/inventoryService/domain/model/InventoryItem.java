package com.inventoryService.inventoryService.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {

    public enum Type { MEDICAMENTO, PROCEDIMIENTO, AYUDA_DIAGNOSTICA }

    private String id;
    private String name;
    private Type type;
    private BigDecimal cost;
    private Integer stock;
    private String specialtyId;

    public void decreaseStock(int amount) {
        if (amount < 0) throw new IllegalArgumentException("amount negativo");
        if (this.stock - amount < 0) throw new IllegalStateException("stock insuficiente");
        this.stock -= amount;
    }

    public void increaseStock(int amount) {
        if (amount < 0) throw new IllegalArgumentException("amount negativo");
        this.stock += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryItem)) return false;
        InventoryItem that = (InventoryItem) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() { return Objects.hash(id); }



}
