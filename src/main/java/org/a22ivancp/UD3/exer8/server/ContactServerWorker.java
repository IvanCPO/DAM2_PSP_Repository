package org.a22ivancp.UD3.exer8.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ContactServerWorker implements Runnable{
    DatagramSocket socket;
    DatagramPacket packet;
    InetAddress client;
    int port;

    public ContactServerWorker(DatagramSocket socket, DatagramPacket packet) {
        this.socket = socket;
        this.packet = packet;
        client = packet.getAddress();
        port = packet.getPort();
    }

    @Override
    public void run() {
        startWork();

    }

    private void startWork() {
        try {
            String message = new String(packet.getData(),0,packet.getLength(),"UTF-8");
            System.out.println(message);
            message = "connect";
            packet.setData(message.getBytes());
            packet = new DatagramPacket(packet.getData(), packet.getData().length, client, port);
            socket.send(packet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
