package com.solvd.tacoursesolvd.wearshopproject.shop.catalog.parameters;

import java.util.Objects;

public class FabricParameter {

    private String colorClothes;
    private String materialClothes;

    public FabricParameter(String colorClothes, String materialClothes) {
        this.colorClothes = colorClothes;
        this.materialClothes = materialClothes;
    }

    @Override
    public String toString() {
        return colorClothes + materialClothes;
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

    public String getColorClothes() {
        return colorClothes;
    }

    public void setColorClothes(String colorClothes) {
        this.colorClothes = colorClothes;
    }

    public String getMaterialClothes() {
        return materialClothes;
    }

    public void setMaterialClothes(String materialClothes) {
        this.materialClothes = materialClothes;
    }
}