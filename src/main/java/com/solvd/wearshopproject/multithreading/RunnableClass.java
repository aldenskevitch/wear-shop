package com.solvd.wearshopproject.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableClass implements Runnable {

    private static final Logger LOGGER = LogManager.getLogger();

    private final ConnectionPool connectionPool;

    public RunnableClass(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        Connection connection = connectionPool.getConnection();
        LOGGER.debug(String.format("%s by implements Runnable", connection.createConnection()));
        LOGGER.debug(String.format("%s by implements Runnable", connection.readData()));
        LOGGER.debug(String.format("%s by implements Runnable", connection.updateData()));
        LOGGER.debug(String.format("%s by implements Runnable", connection.closeConnection()));
        connectionPool.releaseConnection(connection);
    }
}
