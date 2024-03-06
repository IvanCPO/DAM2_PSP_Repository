package org.a22ivancp.UD4.exer8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String country;
        String dateString;
        while (true){
            System.out.println("Este programa recoge de Wikipedia API articulos " +
                    "dependiendo del pais y de la fecha del articulo");
            System.out.println("Por favor, introduce el pais (dos letras):");
            country = sc.nextLine();
            System.out.println("Introduce la fecha (YYYY/MM/DD):");
            dateString = sc.nextLine();
            if (country.length()!= 2 && dateString.length()!=10){
                System.err.println("El formato no es correcto. Vuelva a empazar cumpliendo las normas.");
            }else break;
        }

        try {
            URL url = new URL("https://wikimedia.org/api/rest_v1/metrics/"+
                    "pageviews/top-per-country/"+country.toUpperCase()+"/all-access/"+
                    dateString);
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(
                    new InputStreamReader( is )
            );

            String total="";
            String line;
            while((line=br.readLine())!=null)
                total+=line;
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.setPrettyPrinting().create();
            PrintWriter pw = new PrintWriter("result.json");
            pw.flush();
            Object o = gson.fromJson(total,Object.class);
            String value = gson.toJson(o);
            pw.println(value);
            pw.flush();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
