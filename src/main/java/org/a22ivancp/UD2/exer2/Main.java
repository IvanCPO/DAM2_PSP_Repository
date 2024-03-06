package org.a22ivancp.UD2.exer2;


import java.util.Random;

public class Main {
    static Random rm = new Random();
    public static void main(String[] args) {
        int numGenerated = rm.nextInt(101);
        HiddenNumber hn = new HiddenNumber(numGenerated);
        Thread fio = null;
        for (int i = 0; i < 10; i++) {
            fio = new Thread(new MyThreadWorker(hn), "Thread "+i);
            fio.start();
        }
        System.out.println("The hidden number was "+numGenerated);
    }
}
