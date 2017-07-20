package com.lomoye.concurrency.executor.section6;

/**
 * Created by lomoye on 2017/7/20.
 * 存储并发结果
 */
public class Result {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
