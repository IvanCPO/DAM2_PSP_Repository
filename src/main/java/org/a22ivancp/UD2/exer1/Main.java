package org.a22ivancp.UD2.exer1;

public class Main {
    public static void main(String[] args) {
        Thread fio = null;
        for (int i = 0; i < 2; i++) {
            fio = new Thread(new MyThread(), "Thread "+i);
            fio.start();
        }
        try {
            fio.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!fio.isAlive())
            System.out.println("This is the end of this program");
    }
}
