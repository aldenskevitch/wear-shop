package homework.task2345;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class ShopInfo implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger();
    private String filePath = "ShopInfo.txt";

    public void writeToFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
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

    @Override
    public void close() throws Exception {
        LOGGER.debug("File is close");
    }
}
