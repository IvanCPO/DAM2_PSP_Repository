package org.a22ivancp.UD3.exer6;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(50437);
            System.out.println("Inicializado Server...");
            while(true)
                new Thread(new ClientHandler(socket.accept())).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
