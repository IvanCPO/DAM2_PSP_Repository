package org.a22ivancp.UD3.exer6;

import java.io.*;
import java.net.Socket;
import java.util.Random;
import java.util.ResourceBundle;

public class ClientHandler implements Runnable{
    private Socket clientSocket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean win;
    private Random rm;
    private int numOp;
    private int number;
    private String explic;
    public ClientHandler(Socket accept) {
        win = false;
        rm = new Random();
        numOp = 0;
        number = 0;
        clientSocket = accept;
        try {
            in = new DataInputStream(clientSocket.getInputStream());
            out = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        try {
            resposta(10);
            takeOrder();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void takeOrder() throws IOException {
        out.writeUTF("\nSend a order:");
        opciones(in.readUTF());
    }

    private void opciones(String value) throws IOException {
        String[] res = value.split(" ");
        System.out.println(value);
        switch (res[0].toUpperCase()){
            case "NEW":
                if (numOp!=0)
                    resposta(80);
                else{
                    numOp = 10;
                    if (res.length>1){
                        numOp = Integer.parseInt(res[1]);
                    }
                    number = rm.nextInt(1,100);
                    resposta(20);
                    while (numOp >0 && !win){
                        takeOrder();
                    }
                    if (!win)
                        resposta(70);
                    resposta(11);
                }
                break;
            case "NUM":
                if (number== 0 && numOp== 0 || res.length==1){
                    resposta(80);
                }
                else{
                    if (Integer.parseInt(res[1])>number)
                        resposta(35);

                    if (Integer.parseInt(res[1])<number)
                        resposta(25);

                    if (Integer.parseInt(res[1])==number)
                        resposta(50);
                    numOp--;
                }
                break;
            case "HELP":
                resposta(40);
                break;
            case "QUIT":
                resposta(11);
                break;
            default: resposta(90);
        }
    }
    private void resposta(int num) throws IOException {

        switch (num){
            case 10:
                out.writeUTF("10 Number game server ready");
                break;
            case 11:
                out.writeUTF(explic+"\n11 BYE");
                clientSocket.close();
                in.close();
                out.close();
                break;
            case 15:
                out.writeUTF(explic+"\n15 Number game server ready");
                takeOrder();
                break;
            case 20:
                out.writeUTF("20 PLAY <"+numOp+">");
                break;
            case 25:
                out.writeUTF("25 LOW <"+numOp+">");
                break;
            case 35:
                out.writeUTF("35 HIGH <"+numOp+">");
                break;
            case 40:
                out.writeUTF("40 INFO");
                takeOrder();
                break;
            case 50:
                win = true;
                out.writeUTF("50 WIN");
                break;
            case 70:
                explic="70 LOSE <"+number+">";
                break;
            case 80:
                explic= "80 ERR";
                resposta(15);
                break;
            case 90:
                explic= "90 UNKNOWN";
                resposta(15);
                break;
        }
    }
}
