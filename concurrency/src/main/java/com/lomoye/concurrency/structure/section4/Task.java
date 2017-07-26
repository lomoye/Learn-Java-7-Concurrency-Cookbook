package com.lomoye.concurrency.structure.section4;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by lomoye on 2017/7/26.
 */
public class Task implements Runnable {

    private int id;

    private PriorityBlockingQueue<Event> queue;

    public Task(int id, PriorityBlockingQueue<Event> queue) {
        this.id = id;
        this.queue = queue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PriorityBlockingQueue<Event> getQueue() {
        return queue;
    }

    public void setQueue(PriorityBlockingQueue<Event> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Event event = new Event(id, i);
            queue.add(event);
        }
    }
}
