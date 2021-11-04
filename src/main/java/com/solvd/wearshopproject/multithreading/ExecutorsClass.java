package com.solvd.wearshopproject.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

import static com.solvd.wearshopproject.multithreading.Main.sleep;

public class ExecutorsClass {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void start(ExecutorService executor) {
        IntStream.range(0, 100)
                .boxed()
                .forEach(index -> {
                    executor.submit(() -> {
                        Connection connection = new Connection();
                        LOGGER.debug(String.format("%s by ExecutorService", connection.createConnection()));
                        LOGGER.debug(String.format("%s by ExecutorService", connection.readData()));
                        LOGGER.debug(String.format("%s by ExecutorService", connection.updateData()));
                        LOGGER.debug(String.format("%s by ExecutorService", connection.closeConnection()));
                    });
                    sleep(500);
                });
    }
}
