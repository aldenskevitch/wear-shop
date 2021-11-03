package com.solvd.wearshopproject.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {

    private static final Logger LOGGER = LogManager.getLogger();

    public void createConnection() {
        LOGGER.debug("Connection was created...");
    }

    public void readData() {
        LOGGER.debug("Data has ben read...");
    }

    public void updateData() {
        LOGGER.debug("Data has ben update...");
    }

    public void closeConnection() {
        LOGGER.debug("Connection was closed...");
    }
}
