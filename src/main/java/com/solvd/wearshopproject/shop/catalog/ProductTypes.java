package com.solvd.wearshopproject.shop.catalog;

public enum ProductTypes {
    PANTS("Pants"), SHIRT("Shirt"), OUTERWEAR("Outerwear"), SUNGLASSES("Sunglasses");

    private final String description;

    ProductTypes(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
