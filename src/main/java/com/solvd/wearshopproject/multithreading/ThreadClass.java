package com.solvd.wearshopproject.multithreading;

public class ThreadClass extends Thread {

    private ConnectionPool connectionPool;

    public ThreadClass(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    @Override
    public void run() {
        Connection connection = connectionPool.getConnection();
        connection.createConnection();
        connection.readData();
        connection.updateData();
        connection.closeConnection();
        connectionPool.releaseConnection(connection);
    }
}
