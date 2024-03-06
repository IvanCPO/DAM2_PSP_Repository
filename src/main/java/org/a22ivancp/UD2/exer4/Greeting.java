package org.a22ivancp.UD2.exer4;

import java.util.ArrayList;
import java.util.List;

public class Greeting {
    private List<Person> people;
    private boolean teacherArrived;

    public Greeting() {
        this.people = new ArrayList<>();
        this.teacherArrived = false;
    }

    public synchronized void arrive(Person p){

        if (!teacherArrived){
            if (p.isTeach()){
                System.out.println("Hola alumnos, yo, " + p.getName() + " he llegado");
                for (Person stundent: people) {
                    System.out.println("Te saluda "+stundent.getName() + " profe");
                }
                teacherArrived=true;
            }
            people.add(p);
            notifyAll();
        }else {
            System.out.println("Lo siento profe, yo, " + p.getName() + ", he llegado tarde");
        }

    }
}
