package org.a22ivancp.UD2.exer3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("Alan"));
        students.add(new Student("Angel"));
        students.add(new Student("Vlad"));
        students.add(new Student("Ivan"));


        List<Book> books = new ArrayList<>();
        books.add(new Book("Como me volvi delegado. DIARIO VLAD"));
        books.add(new Book("Tecnicas de Ligar. PASOS DE BARNEY STINSON"));
        books.add(new Book("Como me volvi famoso en la musica. BIBLIOGRAFIA MELENDI"));
        books.add(new Book("La mascara de una sonrisa. DIARIO IVAN"));
        books.add(new Book("El coach no juega. AUTOAYUDA ANGEL"));
        books.add(new Book("El robo perfecto. La Kanoa de Santiaguesa"));
    }
}
