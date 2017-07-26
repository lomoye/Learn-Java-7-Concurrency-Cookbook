package com.lomoye.concurrency.structure.section3;

import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/26.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        LinkedBlockingDeque<String> list = new LinkedBlockingDeque<>(3);

        Client client = new Client(list);

        Thread thread = new Thread(client);

        thread.start();

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 5; j++) {
                String request = list.take();
                System.out.printf("Main: Request: %s at %s. Size:%d\n", request, new Date(), list.size());
            }
            TimeUnit.MILLISECONDS.sleep(300);
        }


        System.out.printf("Main: End of the program.\n");

    }


}
