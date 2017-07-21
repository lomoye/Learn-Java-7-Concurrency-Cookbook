package com.lomoye.concurrency.executor.section9;

import java.util.concurrent.Callable;

/**
 * Created by lomoye on 2017/7/21.
 */
public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        try {
            while (true) {
                System.out.printf("Task: Test\n");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("中断。。。。");
        }
        return null;
    }
}
