package org.a22ivancp.UD2.exer7;

import java.util.Random;

public class BalloonPricker implements Runnable{
    Random rm;
    BalloonStorage storage;
    BalloonPricker(Random rm, BalloonStorage storage){
        this.rm = rm;
        this.storage = storage;
    }

    private void rest(){
        try {
            Thread.sleep(rm.nextInt(1000,10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        rest();
        boolean can = false;
        for ( Balloon balloon: storage.balloons ) {
            if ( balloon.state == State.HINCHANDO || balloon.state == State.ESPERANDO ) {
                can = true;
                break;
            }
        }
        while (can)
            storage.takeForPick();
    }
}
