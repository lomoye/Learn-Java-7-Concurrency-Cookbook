package com.lomoye.concurrency.executor.section10;


import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by lomoye on 2017/7/19.
 */
public class ResultTask extends FutureTask<String> {

    private String name;


    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name = ((ExecutableTask) callable).getName();
    }


    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been canceled\n",name);
        } else {
            System.out.printf("%s: Has finished\n",name);
        }
    }
}
