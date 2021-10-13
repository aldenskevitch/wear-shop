package homework.task2345;

import java.util.Objects;

public class ShopInfo {

    private String filePath = "ShopInfo.txt";

    public ShopInfo() {
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "filePath='" + filePath + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopInfo shopInfo = (ShopInfo) o;
        return Objects.equals(filePath, shopInfo.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filePath);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
