package com.solvd.wearshopproject.shop.catalog;

import java.util.Objects;

public abstract class Product {

    protected ProductType productName;
    protected Double productCost;

    public Product(ProductType productName) {
        switch (productName) {
            case PANTS:
                this.productCost = 100.00;
                break;
            case OUTERWEAR:
                this.productCost = 200.00;
                break;
            case SHIRT:
                this.productCost = 50.00;
                break;
            case SUNGLASSES:
                this.productCost = 60.00;
                break;
            default:
                this.productCost = 0.00;
        }
        this.productName = productName;
    }

    public abstract void doPrepareForSale();

    @Override
    public String toString() {
        return this.productName.toString() + this.productCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productName.equals(product.productName) && productCost.equals(product.productCost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productCost);
    }

    public ProductType getProductType() {
        return productName;
    }

    public void setProductType(ProductType productName) {
        this.productName = productName;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }
}