package com.lomoye.concurrency.frokJoin.section6;

import java.util.Random;

/**
 * Created by lomoye on 2017/7/24.
 */
public class ArrayGenerator {
    public int[] generateArray(int size) {
        int array[] = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10);
        }
        return array;
    }
}
