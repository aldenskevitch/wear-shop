package com.solvd.wearshopproject.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {

    private static ConnectionPool instance;
    private static volatile List<Connection> connectionPool;

    private ConnectionPool() {
    }

    public static synchronized ConnectionPool getInstance(Integer pool) {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        connectionPool = Collections.synchronizedList(new ArrayList<>());
        IntStream.range(0, pool).forEach(i ->
                connectionPool.add(new Connection()));
        return instance;
    }

    public synchronized void releaseConnection(Connection connection) {
        connectionPool.add(connection);
    }

    public synchronized Connection getConnection() {
        return connectionPool
                .remove(connectionPool.size() - 1);
    }
}
