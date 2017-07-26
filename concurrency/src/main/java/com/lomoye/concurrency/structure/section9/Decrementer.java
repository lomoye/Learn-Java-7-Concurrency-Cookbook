package com.lomoye.concurrency.structure.section9;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by lomoye on 2017/7/26.
 */
public class Decrementer implements Runnable {

    private AtomicIntegerArray vector;

    public Decrementer(AtomicIntegerArray vector) {
        this.vector = vector;
    }

    @Override
    public void run() {
        for (int i = 0; i < vector.length(); i++) {
            vector.getAndDecrement(i);
        }
    }
}
