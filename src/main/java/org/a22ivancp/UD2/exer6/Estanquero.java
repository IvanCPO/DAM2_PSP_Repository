package org.a22ivancp.UD2.exer6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estanquero implements Runnable{
    private String name;
    private Random rm;
    private final Material[] options = new Material[]{
            Material.TABACO,Material.PAPEL,Material.CERILLA};
    private List<Material> items;
    private Estanco estanco;

    public Estanquero(String name, Random rm, Estanco estanco) {
        this.name = name;
        this.rm = rm;
        this.estanco = estanco;
        items = new ArrayList<>();
    }

    private void generateItems(){
        int pos;
        for (int i = 0; i < 2; ) {
            pos = rm.nextInt(3);

            if (items.isEmpty() ||
                    !items.get(0).getName().equals(options[pos].getName())){
                items.add(options[pos]);
                i++;
            }
        }
    }

    @Override
    public void run() {
        while(true)
            try {
            Thread.sleep(rm.nextInt(700));
            generateItems();
            estanco.putItems(items);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
