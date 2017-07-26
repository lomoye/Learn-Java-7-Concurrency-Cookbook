package com.lomoye.concurrency.structure.section2;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by lomoye on 2017/7/26.
 */
public class PollTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            System.out.println(list.poll());
            list.pollLast();
        }

    }
}
