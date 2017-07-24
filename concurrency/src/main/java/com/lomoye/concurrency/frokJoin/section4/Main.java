package com.lomoye.concurrency.frokJoin.section4;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/24.
 */
public class Main {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        FolderProcessor system = new FolderProcessor("C:\\Windows", "log");

        FolderProcessor apps = new FolderProcessor("C:\\Program Files", "log");
        FolderProcessor documents = new FolderProcessor("C:\\workspace", "log");

        pool.execute(system);
        pool.execute(apps);
        pool.execute(documents);

        do {

            System.out.printf("***************\n");

            System.out.println("***********   状态信息巡查 ***************");
            System.out.printf("最大并行任务:%s,当前活动任务数(不准确的):%s,队列中的任务数量:%s,窃取数量:%s\n",
                    pool.getParallelism(),
                    pool.getActiveThreadCount(),
                    pool.getQueuedTaskCount(),
                    pool.getStealCount());

            System.out.printf("**************\n");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while ((!system.isDone()) || (!apps.isDone()) || (!documents.isDone()));

        pool.shutdown();

        List<String> results;

        results = system.join();

        System.out.printf("System: %d files found.\n", results.size());

        results = apps.join();

        System.out.printf("Apps: %d files found.\n", results.size());

        results = documents.join();

        System.out.printf("Documents: %d files found.\n", results.size());

    }
}
