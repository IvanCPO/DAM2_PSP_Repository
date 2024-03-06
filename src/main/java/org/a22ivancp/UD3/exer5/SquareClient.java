package org.a22ivancp.UD3.exer5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SquareClient {
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public static void main(String[] args) {
        new SquareClient();
    }

    public SquareClient() {
        begin();
    }
    private void begin(){
        try {
            this.clientSocket = new Socket("127.0.0.1",50437);
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            work();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void work() throws IOException {
        System.out.println(in.readLine());
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        out.println(value);
        System.out.println(in.readLine());
        if (value!=0)
            begin();
    }
}
