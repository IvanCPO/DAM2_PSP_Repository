package org.a22ivancp.UD2.exer7;

import java.util.ArrayList;
import java.util.List;

public class BalloonStorage {
    List<Balloon> balloons;

    BalloonStorage(){
        balloons = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            balloons.add(new Balloon());
        }
    }

    public void takeForBlow(){
        for (Balloon balloon:
                balloons) {
            if (balloon.state == State.ESPERANDO){
                blowed(balloon);
            }
        }
    }

    public synchronized void takeForPick(){
        while (!can()){
            try {
                wait();
                notifyAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        for (Balloon balloon:
                balloons) {
            if (balloon.state == State.HINCHANDO){
                balloon.prick();
                notifyAll();
                break;
            }
        }

    }

    private boolean can() {
        boolean can = false;
        for (Balloon balloon:
                balloons) {
            if (balloon.state == State.HINCHANDO){
                can =true;
                break;
            }
        }
        return can;
    }

    private synchronized void blowed(Balloon balloon) {
        balloon.blow();
        notifyAll();
        for (int i = 1; i <= 6 ; i++) {
            try {
                Thread.sleep(1000);
                if (balloon.state != State.PINCHADO)
                    System.out.println("Inflado "+i+" litro de aire al globo "+ balloon.id);
                else{
                    System.out.println("El globo " + balloon.id + " fue explotado.");
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
        balloon.burst();
        System.out.println("El globo "+ balloon.id +" explotó");
    }
}
