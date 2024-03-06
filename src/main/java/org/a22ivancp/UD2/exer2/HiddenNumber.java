package org.a22ivancp.UD2.exer2;

public class HiddenNumber {
    int number;
    boolean end;

    public HiddenNumber(int number) {
        this.number = number;
        end = false;
    }

    public int numberGuess(int num){
        if (number == num){
            end = true;
            return 1;
        }
        if (end)
            return -1;
        return 0;
    }
}
