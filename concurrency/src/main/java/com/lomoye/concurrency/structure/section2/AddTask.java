package com.lomoye.concurrency.structure.section2;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Created by lomoye on 2017/7/26.
 */
public class AddTask implements Runnable {

    private ConcurrentLinkedDeque<String> list;

    public AddTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 1000; i++) {
            list.add(name + "Element" + i);
        }
    }
}
