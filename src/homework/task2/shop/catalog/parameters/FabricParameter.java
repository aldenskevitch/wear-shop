package homework.task2.shop.catalog.parameters;

public class FabricParameter {

    private String[] fabric;

    public FabricParameter(String colorClothes, String materialClothes) {
        fabric= new String[]{colorClothes, materialClothes};
    }

    public String[] getFabric() {
        return fabric;
    }

    public void setFabric(String[] fabric) {
        this.fabric = fabric;
    }
}
