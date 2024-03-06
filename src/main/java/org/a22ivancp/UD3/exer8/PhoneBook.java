package org.a22ivancp.UD3.exer8;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private static PhoneBook instance;
    private List<Contact> book;

    private PhoneBook (){
        book = new ArrayList<>();
    }
    public static PhoneBook newInstance(){
        if (instance==null){
            synchronized (PhoneBook.class){
                if (instance==null){
                    instance = new PhoneBook();
                }
            }
        }
        return instance;
    }

    public void addContact(Contact c){
        book.add(c);
    }

    public Contact findContact(String name){
        Contact contact = null;
        for (Contact cont: book) {
            if (cont.getNameUser().equals(name)){
                contact= cont;
                break;
            }
        }
        return contact;
    }
}
