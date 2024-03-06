package org.a22ivancp.UD2.exer8;

import java.util.ArrayList;
import java.util.List;

public class Bakery {
    public static void main(String[] args) {
        TakeANumber takeANumber = new TakeANumber();
        Clerk clerk = new Clerk(takeANumber);
        List<Customer> people = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            people.add(new Customer(takeANumber));
        }
        Thread t;
        for (Customer c : people) {
            t = new Thread(c);
            t.start();
        }
        t= new Thread(clerk);
        t.start();

    }
}
