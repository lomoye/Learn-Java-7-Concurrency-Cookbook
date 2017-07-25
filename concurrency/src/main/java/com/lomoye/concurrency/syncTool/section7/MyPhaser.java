package com.lomoye.concurrency.syncTool.section7;

import java.util.concurrent.Phaser;

/**
 * Created by lomoye on 2017/7/25.
 */
public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                System.out.println("第一步准备开始咯");
                break;
            case 1:
                System.out.println("第二步开始咯");
                break;

            default:
                System.out.println("wu fa ke suo");
                break;
        }

        return super.onAdvance(phase, registeredParties);
    }
}
