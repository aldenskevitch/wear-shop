package com.solvd.wearshopproject.multithreading;

public class Connection {

    public String createConnection() {
        sleep(500);
        return "Connection was created...";
    }

    public String readData() {
        sleep(500);
        return "Data has ben read...";
    }

    public String updateData() {
        sleep(500);
        return "Data has ben update...";
    }

    public String closeConnection() {
        sleep(500);
        return "Connection was closed...";
    }

    private static void sleep(Integer mils) {
        try {
            Thread.sleep(mils);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
