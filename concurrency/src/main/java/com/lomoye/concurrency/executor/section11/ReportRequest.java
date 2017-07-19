package com.lomoye.concurrency.executor.section11;

import java.util.concurrent.CompletionService;

/**
 * Created by lomoye on 2017/7/19.
 * 报告请求
 */
public class ReportRequest implements Runnable {
    private String name;

    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    @Override
    public void run() {
        ReportGenerator reportGenerator = new ReportGenerator(name, "吃西瓜");
        service.submit(reportGenerator);
    }
}
