package org.a22ivancp.UD2.exer7;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BalloonStorage bs = new BalloonStorage();
        Random rm = new Random();
        for (int i = 0; i < 5; i++) {
            new Thread(new BalloonPricker(rm, bs)).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new BalloonBlower(rm, bs)).start();
        }
    }
}
