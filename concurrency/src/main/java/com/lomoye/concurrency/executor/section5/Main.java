package com.lomoye.concurrency.executor.section5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lomoye on 2017/7/19.
 *
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        UserValidator pigValidator = new UserValidator("猪验证器");
        UserValidator dragonValidator = new UserValidator("龙验证器");

        TaskValidator pigTask = new TaskValidator(pigValidator, "root", "12306");
        TaskValidator dragonTask = new TaskValidator(dragonValidator, "root", "12305");

        List<TaskValidator> tasks = new ArrayList<>();
        tasks.add(pigTask);
        tasks.add(dragonTask);

        try {
            String name = executor.invokeAny(tasks);
            System.out.println("name:" + name + ":厉害咯");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
