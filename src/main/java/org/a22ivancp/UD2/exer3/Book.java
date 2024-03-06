package org.a22ivancp.UD2.exer3;

public class Book {
    private final String name;
    private boolean used;

    public Book(String name) {
        this.name = name;
        used = false;
    }

    public boolean getUsed(){
        return used;
    }
    synchronized public void restBook(int rest){
        try {
            Thread.sleep(rest);
            used = true;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
