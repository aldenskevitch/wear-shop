package com.solvd.wearshopproject.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        IntStream.range(0, 100)
                .boxed()
                .forEach(index -> {
                    ConnectionPool connectionPool = ConnectionPool.getInstance(5);
                    Thread thread = new ThreadClass(connectionPool);
                    thread.start();
                });

        IntStream.range(0, 100)
                .boxed()
                .forEach(index -> {
                    ConnectionPool connectionPool = ConnectionPool.getInstance(5);
                    RunnableClass runnable = new RunnableClass(connectionPool);
                    Thread thread = new Thread(runnable);
                    thread.start();
                });

        ExecutorsClass.start(executorService);
        CompletableClass.start(executorService);
    }
}
