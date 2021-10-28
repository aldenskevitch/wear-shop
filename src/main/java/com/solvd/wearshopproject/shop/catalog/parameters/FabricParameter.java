package com.solvd.wearshopproject.shop.catalog.parameters;

import java.util.Objects;

public class FabricParameter {

    private Color colorClothes;
    private Fabric materialClothes;

    public FabricParameter(Color colorClothes, Fabric materialClothes) {
        this.colorClothes = colorClothes;
        this.materialClothes = materialClothes;
    }

    @Override
    public String toString() {
        return colorClothes.toString() + materialClothes.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FabricParameter that = (FabricParameter) o;
        return colorClothes.equals(that.colorClothes) && materialClothes.equals(that.materialClothes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorClothes, materialClothes);
    }

    public Color getColorClothes() {
        return colorClothes;
    }

    public void setColorClothes(Color colorClothes) {
        this.colorClothes = colorClothes;
    }

    public Fabric getMaterialClothes() {
        return materialClothes;
    }

    public void setMaterialClothes(Fabric materialClothes) {
        this.materialClothes = materialClothes;
    }
}