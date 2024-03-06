package org.a22ivancp.UD2.exer6;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rm = new Random();
        Estanco est = new Estanco();
        Estanquero jefe = new Estanquero("Xavi", rm, est);
        String[] nombres = new String[]{"Melendi", "Melenedi", "El Gemelos"};
        Material[] mat = new Material[]{Material.TABACO,Material.PAPEL,Material.CERILLA};
        for (int i = 0; i < 3; i++) {
            new Thread(new Fumador(nombres[i],mat[i],est,rm)).start();
        }
        new Thread(jefe).start();
    }
}
