package com.lomoye.concurrency.executor.section12;

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
        System.out.println("section5 " + name + ": Starting");
        try {
            long duration = 10L;
            System.out.printf("section5 %s: ReportGenerator: Generating a report during %d seconds\n", name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("section5 %s: Ending\n",name);
    }

    public String toString() {
        return name;
    }

}
