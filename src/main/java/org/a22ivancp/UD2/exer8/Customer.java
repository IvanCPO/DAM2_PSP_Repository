package org.a22ivancp.UD2.exer8;

public class Customer implements Runnable {
    private static int cont = 0;
    private final String name;
    private final TakeANumber takeANumber;

    public Customer(TakeANumber number) {
        this.takeANumber = number;
        cont++;
        name= "Customer Nº"+cont;
    }

    public String getNameCustomer() {
        return name;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(20000, 40000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
