package com.lomoye.concurrency.syncTool.section6;

import com.lomoye.concurrency.syncTool.section7.MyPhaser;

import java.util.concurrent.Phaser;

/**
 * Created by lomoye on 2017/7/25.
 *
 */
public class Main {

    public static void main(String[] args) {
        Phaser phaser = new MyPhaser();
        phaser.register();phaser.register();phaser.register();
        FileSearch system = new FileSearch("C:\\Windows", "hosts", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "hosts", phaser);
        FileSearch documents = new FileSearch("C:\\data", "hosts", phaser);

        Thread systemThread = new Thread(system, "System");

        systemThread.start();

        Thread appsThread = new Thread(apps, "Apps");

        appsThread.start();

        Thread documentsThread = new Thread(documents, "Documents");

        documentsThread.start();

        try {
            systemThread.join();

            appsThread.join();

            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Terminated: " + phaser.isTerminated());

    }
}
