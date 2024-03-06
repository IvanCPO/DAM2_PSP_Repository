package org.a22ivancp.UD3.exer8;

public class Contact {
    private String nameUser;
    private int telephoneNumber;

    public Contact(String nameUser, int telephoneNumber) {
        this.nameUser = nameUser;
        this.telephoneNumber = telephoneNumber;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "CONTACT: "+nameUser.toUpperCase()+"\tNUMBER: "+telephoneNumber;
    }
}
