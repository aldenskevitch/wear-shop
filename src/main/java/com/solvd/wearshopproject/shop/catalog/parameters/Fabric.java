package com.solvd.wearshopproject.shop.catalog.parameters;

public enum Fabric {
    JEANS("Jeans"), LEATHER("Leather"), COTTON("Cotton");

    private final String description;

    Fabric(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
