package com.lomoye.concurrency.executor.section10;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/19.
 */
public class ExecutableTask implements Callable<String> {

    private String name;

    public ExecutableTask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        long duration = (long) (Math.random() * 10);
        System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
        TimeUnit.SECONDS.sleep(duration);
        return "Hello, my name is " + name;
    }

    public String getName() {
        return name;
    }
}
