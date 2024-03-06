package org.a22ivancp.UD2.exer1;
import java.util.Random;
public class MyThread implements Runnable{
    Random rm = new Random();
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Welcome home, "+threadName);
        for (int i = 0; i < 5; i++) {
            long number = rm.nextLong(10l,501l);
            try {
                Thread.sleep(number);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(number);
        }
        System.out.println("Goodbye, "+threadName);
    }
}