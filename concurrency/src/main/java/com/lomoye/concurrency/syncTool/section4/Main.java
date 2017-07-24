package com.lomoye.concurrency.syncTool.section4;

/**
 * Created by lomoye on 2017/7/24.
 */
public class Main {

    public static void main(String[] args) {
        VideoConference conference = new VideoConference(10);

        Thread t = new Thread(conference);
        t.start();
        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(conference, "参与者:" + i);
            Thread thread = new Thread(participant);
            thread.start();
        }
    }
}
