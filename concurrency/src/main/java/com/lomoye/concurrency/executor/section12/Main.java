package com.lomoye.concurrency.executor.section12;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lomoye on 2017/7/21.
 */
public class Main {

    public static void main(String[] args) {
        RejectedTaskHandler handler = new RejectedTaskHandler();

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        executor.setRejectedExecutionHandler(handler);

        System.out.printf("Main: Starting.\n");

        for (int i = 0; i < 3; i++) {
            Task task = new Task("section5" + i);
            executor.submit(task);
        }

        System.out.printf("Main: Shutting down the Executor.\n");
        executor.shutdown();

        System.out.printf("Main: Sending another section5.\n");
        Task task = new Task("RejectedTask********");
        executor.submit(task);

        System.out.println("Main: End");
        System.out.printf("Main: End.\n");
    }
}
