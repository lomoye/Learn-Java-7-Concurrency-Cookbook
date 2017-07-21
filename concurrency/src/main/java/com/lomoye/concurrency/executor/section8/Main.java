package com.lomoye.concurrency.executor.section8;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/21.
 */
public class Main {

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        Task task = new Task("Task");

        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 5, TimeUnit.SECONDS);

        //executor.scheduleWithFixedDelay(task, 10, 5, TimeUnit.SECONDS);  此方法会等task执行完再等5秒，不会管执行花了多久时间



        for (int i = 0; i < 100; i++) {

            System.out.printf("Main: Delay: %d\n", result.getDelay(TimeUnit.MILLISECONDS));
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*executor.shutdown();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Finished at: %s\n",new Date());*/
    }
}
