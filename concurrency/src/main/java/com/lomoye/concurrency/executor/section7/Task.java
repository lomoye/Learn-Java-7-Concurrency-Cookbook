package com.lomoye.concurrency.executor.section7;

import java.util.concurrent.Callable;

/**
 * Created by lomoye on 2017/7/20.
 *
 */
public class Task implements Callable<String> {

    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.println("%s : 开始浪了..." + name);
        return name + "stop";
    }
}
