package org.a22ivancp.UD2.exer5;

import java.util.Random;

public class Mailman implements Runnable{
    Mailbox buzon;
    Random rm;

    public Mailman(Mailbox message) {
        this.buzon = message;
        rm = new Random();
    }


    @Override
    public void run() {
        String[] mails = {"Angel!!!! TERRIBLE. He perdido el libro de como " +
                "ser tu propio coach.", "Angel, quiero decirte que al final " +
                "lo encontre. Lo tenia Mateo escondido entre pelotas de " +
                "baloncesto. De chill.", "Joveeeeee, ya parezco Pouso. " +
                "Lo he vuelto a perder y esta vez no esta en la de Mateiño." +
                " Me puedes dar otros dos por si las moscas?", "No te" +
                " lo vas a creer, pero lo volvi a encontrar gracias a Jabato" +
                " Jonsson. Dijo que habia que revisar el horno. FINAL FELIZ"};

        for (String mail : mails) {
            buzon.putMessage(mail);
            System.out.println("En mensajero deposito un mensaje en el buzon");
            try {
                Thread.sleep(rm.nextInt(200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        buzon.putMessage("Finished!!!");
    }
}
