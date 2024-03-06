package org.a22ivancp.UD2.exer2;

import java.util.Random;

public class MyThreadWorker implements Runnable{
    private HiddenNumber hn;
    private int num;
    private Random rm;
    public MyThreadWorker(HiddenNumber hn) {
        this.hn = hn;
        rm = new Random();
    }
    @Override
    public void run() {
        while (hn.numberGuess(num)!=-1){
            num = rm.nextInt(101);
            if (hn.numberGuess(num)==1){
                System.out.println(Thread.currentThread().getName()+" win with "+num);
                break;
            }
            try {
                Thread.sleep(50l);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (hn.numberGuess(num)==-1){
            System.out.println(Thread.currentThread().getName()+" loss with "+num);
        }
    }
}
