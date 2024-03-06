package org.a22ivancp.UD2.exer3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student {
    public Random rm;
    private String name;
    private List<Book> list_books;

    public Student(String name) {
        this.name = name;
        rm = new Random();
        list_books = new ArrayList<>();
    }

    public void addBook(Book book){
        list_books.add(book);
    }

    public void startBooks(){
        for (Book book: list_books ) {
            readBook(book);
        }
    }
    synchronized private void readBook(Book book){


        finishBook(book);
    }

    private void finishBook(Book book){
        System.out.println(name+ " ha leido el libro "+book);
        list_books.remove(book);
        book.restBook(rm.nextInt(100, 201));
    }
}
