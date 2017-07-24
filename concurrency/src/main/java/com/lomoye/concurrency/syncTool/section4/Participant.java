package com.lomoye.concurrency.syncTool.section4;

import java.util.concurrent.TimeUnit;

/**
 * Created by lomoye on 2017/7/24.
 */
public class Participant implements Runnable {

    private VideoConference conference;

    private String name;


    public Participant(VideoConference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {

        long duration = (long) (Math.random() * 10);

        try {
            System.out.println("睡眠:" + duration);
            TimeUnit.SECONDS.sleep(duration);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }
        conference.arrive(name);
    }
}
