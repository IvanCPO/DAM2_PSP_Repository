package org.a22ivancp.UD3.exer5;

import java.io.IOException;
import java.net.ServerSocket;

public class SquareServer {
    public static void main(String[] args) {
        new SquareServer();
    }
    private ServerSocket server;
    private SquareServer() {
        begin();
    }
    private void begin(){
        try {
            server = new ServerSocket(50437);
            System.out.println("Preparado");
            while (true) {
                new Thread(new SquareClientHandler(server.accept())).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
