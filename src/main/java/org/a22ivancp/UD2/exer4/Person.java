package org.a22ivancp.UD2.exer4;

import java.util.Random;

public class Person implements Runnable{
    private String name;
    private Random rm;
    private Greeting sala;
    private boolean teach;


    public Person(String name, Random rm, Greeting sala, boolean teach) {
        this.name = name;
        this.rm = rm;
        this.sala = sala;
        this.teach = teach;
    }

    public void greet(){ getSala().arrive(this); }

    public Random getRandom(){
        return rm;
    }

    public String getName() {
        return name;
    }

    public Greeting getSala() {
        return sala;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(getRandom().nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        greet();
    }

    public boolean isTeach() {
        return teach;
    }
}
