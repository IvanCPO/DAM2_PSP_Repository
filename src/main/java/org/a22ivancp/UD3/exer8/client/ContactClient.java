package org.a22ivancp.UD3.exer8.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Scanner;

public class ContactClient {
    private final Scanner sc = new Scanner(System.in);
    //server port
    final int PORT = 50437;
    InetAddress IP;
    //buffer to store the messages
    byte[] buffer = new byte[1024];
    DatagramSocket SERVER;
    DatagramPacket PACKET;

    public static void main(String[] args) {
        new ContactClient();
    }

    ContactClient(){
        try {
            IP = InetAddress.getByName("localhost");
            //Creates the UDP socket
            SERVER = new DatagramSocket();
            saludo();

//            while (true) {
//
//
//
//            }
        } catch(UnknownHostException e){
            throw new RuntimeException(e);
        } catch(SocketException e){
            throw new RuntimeException(e);
        } catch(UnsupportedEncodingException e){
            throw new RuntimeException(e);
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private void saludo() throws IOException {
        String init = "CONNECT";
        buffer = init.getBytes();
        PACKET = new DatagramPacket(buffer,buffer.length,IP,PORT);

        SERVER.send(PACKET);
        SERVER.receive(PACKET);

        String message = new
                String(PACKET.getData(),0,PACKET.getLength(),"UTF-8");
        System.out.println(message);
    }
}

