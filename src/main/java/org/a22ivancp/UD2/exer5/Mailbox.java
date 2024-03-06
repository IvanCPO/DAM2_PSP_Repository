package org.a22ivancp.UD2.exer5;

public class Mailbox {
    String message;
    boolean empty;

    public Mailbox() {
        empty = true;
    }

    public synchronized void putMessage(String message){
        while (!empty){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }

    public synchronized String takeMessage(){
        while (empty){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        empty = true;
        notifyAll();
        return this.message;
    }

}
