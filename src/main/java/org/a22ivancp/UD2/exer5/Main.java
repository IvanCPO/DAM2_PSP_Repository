package org.a22ivancp.UD2.exer5;

public class Main {
    public static void main(String[] args) {
        Mailbox mailbox = new Mailbox();

        Thread mailman = new Thread(new Mailman(mailbox));
        Thread reader = new Thread(new Mailman(mailbox));

        mailman.start();
        reader.start();
    }
}
