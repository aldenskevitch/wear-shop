package com.solvd.tacoursesolvd.task7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class ShopInfo implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger();

    private final String FILEPATH = "ShopInfo.txt";

    public void writeToFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
    }

    @Override
    public String toString() {
        return "ShopInfo{" +
                "filePath='" + FILEPATH + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopInfo shopInfo = (ShopInfo) o;
        return Objects.equals(FILEPATH, shopInfo.FILEPATH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FILEPATH);
    }

    public String getFILEPATH() {
        return FILEPATH;
    }

    @Override
    public void close() throws Exception {
        LOGGER.debug("File is close");
    }
}
