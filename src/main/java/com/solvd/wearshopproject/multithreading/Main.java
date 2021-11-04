package com.solvd.wearshopproject.multithreading;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        ConnectionPool connectionPool = ConnectionPool.getInstance(5);

        IntStream.range(0, 100)
                .boxed()
                .forEach(index -> {
                    Thread thread = new ThreadClass(connectionPool);
                    thread.start();
                    sleep(500);
                });

        IntStream.range(0, 100)
                .boxed()
                .forEach(index -> {
                    RunnableClass runnable = new RunnableClass(connectionPool);
                    Thread thread = new Thread(runnable);
                    thread.start();
                    sleep(500);
                });

        ExecutorsClass.start();

    }

    public static void sleep(Integer mils) {
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
