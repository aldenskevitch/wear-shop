package com.solvd.wearshopproject.multithreading;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        ConnectionPool connectionPool = ConnectionPool.getInstance(5);

        IntStream.range(0, 100)
                .boxed()
                .forEach(index -> {
                    Thread thread = new Thread(() -> {
                        Connection connection = connectionPool.getConnection();
                        connection.createConnection();
                        connection.readData();
                        connection.updateData();
                        connection.closeConnection();
                        connectionPool.releaseConnection(connection);
                    });
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    thread.start();
                });
    }
}
