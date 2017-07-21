package com.lomoye.concurrency.executor.section8;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/21.
 */
public class Task implements Runnable {

    private String name;

    public Task(String name) {
        this.name = name;
    }


    @Override
    public void run() {

        System.out.printf("%s: sleep at : %s\n", name, new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
