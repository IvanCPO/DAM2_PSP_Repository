package org.a22ivancp.UD3.exer6;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket client;
    private DataInputStream in;
    private DataOutputStream out;
    public static void main(String[] args) {
        new Client();
    }

    Client(){
        try {
            client = new Socket("127.0.0.1",50437);
            in = new DataInputStream(client.getInputStream());
            out = new DataOutputStream(client.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.println(in.readUTF());
            String serverTalk;
            while((serverTalk = in.readUTF())!=null){
                System.out.println(serverTalk);
                String value = sc.nextLine();
                out.writeUTF(value);
                System.out.println(in.readUTF());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
