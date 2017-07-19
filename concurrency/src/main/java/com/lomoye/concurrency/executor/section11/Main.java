package com.lomoye.concurrency.executor.section11;



import java.util.concurrent.*;

/**
 * Created by lomoye on 2017/7/19.
 *
 * CompletionService 可以维护一个任务队列，等任务完成后便可取出
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        CompletionService<String> service = new ExecutorCompletionService<>(executor);

        ReportRequest wRequest = new ReportRequest("Miss W", service);

        ReportRequest yRequest = new ReportRequest("Mr Y", service);

        Thread wThread = new Thread(wRequest);

        Thread yThread = new Thread(yRequest);

        ReportProcessor processor = new ReportProcessor(service);

        Thread senderThread = new Thread(processor);

        System.out.printf("Main: Starting the Threads\n");

        wThread.start();
        yThread.start();
        senderThread.start();

        try {
            System.out.printf("Main: Waiting for the report");
            wThread.join();
            yThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Main: Shutting down the executor.\n");
        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        processor.setEnd(true);
        System.out.println("Main: Ends");
    }
}
