package org.a22ivancp.UD2.exer4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rm = new Random();
        Greeting salon = new Greeting();

        String[] nombres = {"Ivan", "Melendi", "Angel", "Vlad", "Diana", "David",
        "Ruben", "Mateo", "Pouso", "Martin", "Felipe", "Raul", "Oscar", "Xavi",
        "Javi", "Bralan", "Jaime", "Fran", "Nuria"};
        List< Person > people = new ArrayList<>();

        people.add(new Person("Lozano", rm, salon,true));
        for (String name: nombres ) {
            people.add(new Person(name,rm,salon,false));
        }
        Thread fio;
        for (Person person: people) {
            fio= new Thread(person);
            fio.start();
        }
    }
}
