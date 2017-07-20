package com.lomoye.concurrency.executor.section2;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by lomoye on 2017/7/19.
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

    }


    public void executeTask(Task task) {
        System.out.printf("Server: A new task has arrived\n");

        executor.submit(task);

        System.out.printf("Server: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("Server: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n", executor.getCompletedTaskCount());
        System.out.printf("Server: Task Count: %d\n", executor.getTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }

}
