package com.lomoye.concurrency.frokJoin.section5;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/24.
 */
public class Task extends RecursiveTask<Integer> {

    private int[] array;

    private int start;

    private int end;

    public Task(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        System.out.printf("section5: Start from %d to %d\n", start, end);

        if (end - start < 10) {

            if ((3 > start) && (3 < end)) {
                throw new RuntimeException("This task throws an" + "Exception: section5 from " + start + " to " + end);
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            int mid = (end + start) / 2;
            Task task1 = new Task(array, start, mid);
            Task task2 = new Task(array, mid, end);
            invokeAll(task1, task2);
        }
        System.out.printf("section5: End form %d to %d\n", start, end);
        return 0;
    }
}
