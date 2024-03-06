package org.a22ivancp.UD3.exer8.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ContactServer {
    public static void main(String[] args) {
        final int PORT = 50437;
        byte[] buffer= new byte[1024];

        try {
            System.out.println("UDP server started.......");
            DatagramSocket socket = new DatagramSocket(PORT);
            while (true){
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                new Thread(new ContactServerWorker(socket,packet)).start();
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
