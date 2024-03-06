package org.a22ivancp.UD2.exer6;

import java.util.ArrayList;
import java.util.List;

public class Estanco {
    private boolean empty;
    private List<Material> items;

    public Estanco() {
        empty = true;
        items = new ArrayList<>();
    }

    public synchronized void putItems(List<Material> items) throws InterruptedException {
        while(!empty){
            wait();
        }
        this.items=items;
        empty = false;
        System.out.println("Se han metido cositas gente.");
        notifyAll();
    }

    public synchronized void takeItems(Material m) throws InterruptedException {
        while (empty){
            wait();
        }

        if (canSmoke(m)){
            items.clear();
            empty = true;
            notifyAll();
        }
    }

    private boolean canSmoke(Material m) {
        boolean res = true;
        for (Material item: items ) {
            if (m.getName().equals(item.getName()))
                res = false;
        }
        return res;
    }
}
