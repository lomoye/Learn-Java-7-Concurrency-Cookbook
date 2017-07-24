package com.lomoye.concurrency.executor.section2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/19.
 */
public class Task implements Runnable {

    private Date initDate;

    private String name;


    public Task(String name) {
        initDate = new Date();
        this.name = name;
    }


    @Override
    public void run() {
        System.out.printf("%s: section5 %s: Created on: %s\n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s: section5 %s: Started on: %s\n", Thread.currentThread().getName(), name, new Date());

        try {
            Long duration = (long) (Math.random() * 10);

            System.out.printf("%s: section5 %s: Doing a task during %dseconds\n", Thread.currentThread().getName(), name, duration);

            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s: section5 %s: Finished on: %s\n", Thread.currentThread().getName(), name, new Date());
    }
}