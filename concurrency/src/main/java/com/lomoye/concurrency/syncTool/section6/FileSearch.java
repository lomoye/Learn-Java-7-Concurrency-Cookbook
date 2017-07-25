package com.lomoye.concurrency.syncTool.section6;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/25.
 */
public class FileSearch implements Runnable {

    //搜索开始的时候的文件夹。
    private String initPath;

    private String end;

    //符合条件的文件的路径
    private List<String> results;

    //控制任务的不同phaser的同步。
    private Phaser phaser;

    public FileSearch(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        results = new ArrayList<>();
    }

    private void directoryProcess(File file) {
        File list[] = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
        }
    }

    private void fileProcess(File file) {
        if (file.getName().endsWith(end)) {
            results.add(file.getAbsolutePath());
        }
    }


    private void filterResults() {
        List<String> newResults = new ArrayList<>();
        long actualDate = new Date().getTime();
        for (int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            long fileDate = file.lastModified();
            if (actualDate - fileDate < TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                newResults.add(results.get(i));
            }
        }

        results = newResults;

    }

    private boolean checkResults() {
        if (results.isEmpty()) {
            System.out.printf("%s: Phase %d: 0 results.\n", Thread.currentThread().getName(), phaser.getPhase());

            System.out.printf("%s: Phase %d: End.\n", Thread.currentThread().getName(), phaser.getPhase());

            phaser.arriveAndDeregister();

            return false;

        } else {
            System.out.printf("%s: Phase %d: %d results.\n", Thread.currentThread().getName(), phaser.getPhase(), results.size());
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }


    private void showInfo() {
        for (int i = 0; i < results.size(); i++) {
            File file = new File(results.get(i));
            System.out.printf("%s: %s\n", Thread.currentThread().getName(), file.getAbsolutePath());
        }
        phaser.arriveAndAwaitAdvance();
    }


    @Override
    public void run() {
        System.out.println(phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        System.out.println(phaser.getPhase());

        File file = new File(initPath);

        if (file.isDirectory()) {
            directoryProcess(file);
        }

        if (!checkResults()) {
            return;
        }

        filterResults();

        if (!checkResults()) {
            return;
        }

        showInfo();

        phaser.arriveAndDeregister();

        System.out.printf("%s: Work completed.\n", Thread.currentThread().getName());
    }
}
