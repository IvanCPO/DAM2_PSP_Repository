package org.a22ivancp.UD2.exer7;

public class Balloon {
    static int count = 0;
    State state;
    int id;

    Balloon(){
        state=State.ESPERANDO;
        count++;
        id=count;
    }

    public void blow(){
        state = State.HINCHANDO;
    }
    public void burst(){
        state = State.EXPLOTADO;
    }
    public void prick(){
        state = State.PINCHADO;
    }
}
