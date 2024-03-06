package org.a22ivancp.UD2.exer5;

public class Reader implements Runnable{
    Mailbox buzon;

    public Reader(Mailbox message) {
        this.buzon = message;
    }


    @Override
    public void run() {

        for (String latestMessage = buzon.takeMessage(); !"Finished!!!".equals(latestMessage);latestMessage = buzon.takeMessage()){
            System.out.println("El lector recibio y recogio el mensaje");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
