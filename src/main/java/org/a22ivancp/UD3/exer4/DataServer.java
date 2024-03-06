package org.a22ivancp.UD3.exer4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DataServer {
    private static final int VALUE_PORT = 50437;

    public static void main(String[] args) {
        try (ServerSocket listener = new ServerSocket(VALUE_PORT,5)){
            System.out.println("The server is running");
            Socket socket = listener.accept();

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            output.println("Este servidor te cifra una palabra que escribas a continuación en el código de Polybius:");
            // Leer mensaje del cliente
            String mensajeCliente = input.readLine();
            String cifrado = encriptar(mensajeCliente);
            output.println("El mensaje cifrado es: " + cifrado);
            socket.close();
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String encriptar(String mensajeCliente) {
        String[][] cif = {{"A","B","C","D","E","F"},
                {"G","H","I","J","K","L"},
                {"M","N","O","P","Q","R"},
                {"S","T","U","V","W","X"},
                {"Y","Z","0","1","2","3"},
                {"4","5","6","7","8","9"}};
        String res="";
        for (int i = 0; i < mensajeCliente.length(); i++) {
            boolean check = false;
            String l = mensajeCliente.toUpperCase().charAt(i)+"";
            for (int j = 0; j < cif.length; j++) {
                if (check)
                    break;
                for (int k = 0; k < cif[0].length; k++) {
                    if (cif[j][k].equals(l)){
                        res+=(j+1)+""+(k+1)+" ";
                        check= true;
                        break;
                    }
                }
            }
            if (!check)
                res+="   ";
        }

        return res;
    }
}
