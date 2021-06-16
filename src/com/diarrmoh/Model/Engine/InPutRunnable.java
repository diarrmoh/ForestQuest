package com.diarrmoh.Model.Engine;

import com.diarrmoh.Model.Engine.InPut.InPut;

public class InPutRunnable implements Runnable {


    private volatile InPut inPut;
    private volatile int sleep = 0; // La variable indique le temps d'endormissement en millisecondes. 0 signifie qu'il n'est pas nécéssaire de s'endormir.

    public InPutRunnable(InPut inPut) {
        this.inPut = inPut;
    }
// On utilise également "volatile" car la variable dois être lue par deux threads différents.
// De même, on utilise un int pour que les affectations soient atomiques (ce ne serait pas forcément le cas avec un long de 64 bits)

    public void inPutSleep(int sleep) {
        this.sleep = sleep;
    }



    @Override
    public void run() {

        while (true){
            if( this.sleep > 0) { // Si il faut s'endormir
                try {
                    Thread.sleep((long) this.sleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.sleep = 0; // On remet à 0 pour indiquer qu'il n'est plus nécessaire de dormir
            }



        }

    }
}
