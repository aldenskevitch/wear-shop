package homework.task2.shop.catalog.parameters;

public class FabricParameter {

    private String colorClothes;
    private String materialClothes;

    public FabricParameter(String colorClothes, String materialClothes) {
        this.colorClothes = colorClothes;
        this.materialClothes = materialClothes;
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