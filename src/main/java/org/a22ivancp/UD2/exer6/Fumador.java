package org.a22ivancp.UD2.exer6;

import java.util.Random;

public class Fumador implements Runnable{
    private String name;
    private Material item;
    private Estanco estanco;
    private Random rm;

    public Fumador(String name, Material item, Estanco estanco, Random rm) {
        this.name = name;
        this.item = item;
        this.estanco = estanco;
        this.rm = rm;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(rm.nextInt(700));
            estanco.takeItems(item);
            smoke();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void smoke() throws InterruptedException {
        System.out.println(name+" está fumando");
        Thread.sleep(rm.nextInt(500));
    }
}
