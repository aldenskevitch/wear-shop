package com.solvd.wearshopproject.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

public class CompletableClass {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void start(ExecutorService executor) {
        Connection connection = new Connection();
        CompletableFuture.runAsync(() -> {
            LOGGER.debug(String.format("%s by CompletableFuture", connection.createConnection()));
            LOGGER.debug(String.format("%s by CompletableFuture", connection.readData()));
        }, executor).thenRunAsync(() -> {
            LOGGER.debug(String.format("%s by CompletableFuture", connection.updateData()));
            LOGGER.debug(String.format("%s by CompletableFuture", connection.closeConnection()));
        }, executor);
    }
}
