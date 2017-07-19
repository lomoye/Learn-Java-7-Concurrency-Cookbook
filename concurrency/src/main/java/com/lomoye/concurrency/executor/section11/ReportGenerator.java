package com.lomoye.concurrency.executor.section11;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/19.
 * 报告生成者
 */
public class ReportGenerator implements Callable<String> {

    private String sender;

    private String title;

    public ReportGenerator(String sender, String title) {
        this.sender = sender;
        this.title = title;
    }


    public String call() throws Exception {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s_%s: ReportGenerator: Generating a report during %d seconds\n", this.sender, this.title, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sender + ": " + title;
    }
}

