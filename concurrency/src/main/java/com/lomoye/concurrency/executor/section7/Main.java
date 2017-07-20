package com.lomoye.concurrency.executor.section7;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/20.
 *
 */
public class Main {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        for (int i = 0; i < 10; i++) {
            Task task = new Task("任务-" + i);
            executorService.schedule(task, i, TimeUnit.SECONDS);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Ends at: %s\n",new Date());

    }
}
