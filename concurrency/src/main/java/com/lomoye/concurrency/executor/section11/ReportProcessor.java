package com.lomoye.concurrency.executor.section11;

import java.util.concurrent.CompletionService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/19.
 */
public class ReportProcessor implements Runnable {

    private CompletionService<String> service;

    private boolean end;

    public ReportProcessor(CompletionService<String> service) {
        this.service = service;
        end = false;
    }

    @Override
    public void run() {
        while (!end) {
            try {
                Future<String> result = service.poll(20, TimeUnit.SECONDS);
                if (result != null) {
                    String report = result.get();
                    System.out.printf("ReportReceiver: Report Received:%s\n", report);
                } else {
                    System.out.println("ReportReceiver: fuck empty~~~~~~");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.printf("ReportSender: End\n");
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}

