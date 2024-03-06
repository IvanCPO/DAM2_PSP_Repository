package org.a22ivancp.UD3.exer3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Cual es la pelicula que quieres encontrar?????");
        String name = sc.nextLine();
//        &apikey=de94855e

        String atr = "?t="+name.replace(" ","+")+"&apikey=de94855e";
        URL url = new URL("https://www.omdbapi.com/"+atr);

        System.out.println("URL: "+url.toString());
        System.out.println("Protocol: "+url.getProtocol());
        System.out.println("Host Name: "+url.getHost());
        System.out.println("Port Number: "+url.getPort());
        System.out.println("Default Port Number: "+url.getDefaultPort());
        System.out.println("Query String: "+url.getQuery());
        System.out.println("Path: "+url.getPath());
        System.out.println("File: "+url.getFile());

        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String value;
        while ((value = br.readLine())!= null)
            System.out.println(value);

    }
}
