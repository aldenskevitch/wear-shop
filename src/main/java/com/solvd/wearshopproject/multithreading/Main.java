package com.solvd.wearshopproject.multithreading;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        ConnectionPool connectionPool = ConnectionPool.getInstance(5);

        IntStream.range(0, 10)
                .boxed()
                .forEach(index -> {
                    Thread thread = new ThreadClass(connectionPool);
                    thread.start();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });

        IntStream.range(0, 10)
                .boxed()
                .forEach(index -> {
                    RunnableClass runnable = new RunnableClass(connectionPool);
                    Thread thread = new Thread(runnable);
                    thread.start();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
    }
}
