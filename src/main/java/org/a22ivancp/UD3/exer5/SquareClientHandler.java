package org.a22ivancp.UD3.exer5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SquareClientHandler implements Runnable {
    Socket client;
    PrintWriter out;
    BufferedReader in;

    public SquareClientHandler(Socket socket) {
        this.client = socket;

    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("Introduce un numero entero para darte el cuadrado:");
            int value = Integer.parseInt(in.readLine());
            int res = squareValue(value);
            out.println("El resultado es:\t"+res);
            in.close();
            out.close();
            client.close();

        }catch (IOException e) {
            System.err.println("El cliente se ha desconectado antes de finalizar la tarea. Deshabilitando "+Thread.currentThread().getName());
        }

    }

    private int squareValue(int value) {
        return (value*value);
    }
}
