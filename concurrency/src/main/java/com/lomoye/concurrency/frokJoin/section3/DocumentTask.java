package com.lomoye.concurrency.frokJoin.section3;

import java.util.concurrent.RecursiveTask;

/**
 * Created by lomoye on 2017/7/21.
 *
 */
public class DocumentTask extends RecursiveTask<Integer> {

    private String document[][];

    private int start;

    private int end;

    private String word;

    public DocumentTask(String[][] document, int start, int end, String word) {
        this.document = document;
        this.start = start;
        this.end = end;
        this.word = word;
    }

    @Override
    protected Integer compute() {

        return null;
    }
}
