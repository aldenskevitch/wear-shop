package com.solvd.wearshopproject.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadClass extends Thread {

    private static final Logger LOGGER = LogManager.getLogger();

    private final ConnectionPool connectionPool;

    public ThreadClass(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        Connection connection = connectionPool.getConnection();
        LOGGER.debug(String.format("%s by extends Thread", connection.createConnection()));
        LOGGER.debug(String.format("%s by extends Thread", connection.readData()));
        LOGGER.debug(String.format("%s by extends Thread", connection.updateData()));
        LOGGER.debug(String.format("%s by extends Thread", connection.closeConnection()));
        connectionPool.releaseConnection(connection);
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }
}
