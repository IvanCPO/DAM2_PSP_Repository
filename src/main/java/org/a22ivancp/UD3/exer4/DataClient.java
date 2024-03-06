package org.a22ivancp.UD3.exer4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class DataClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.21.0.5",57327);
        Scanner sc = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        System.out.println(input.readLine());
        String mensaje = sc.nextLine();
        output.println("E");
        output.println(mensaje);
        System.out.println(input.readLine());

    }
}
