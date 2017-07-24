package com.lomoye.concurrency.executor.section2;

/**
 * Created by lomoye on 2017/7/19.
 */
public class Main {

    public static void main(String[] args) {
        Server server = new Server();

        for (int i = 0; i < 100; i++) {

            Task task = new Task("section5 " + i);

            server.executeTask(task);

        }
        server.endServer();
    }


}
