package com.itchihuahuaii.sistemasoperativosmoviles.MyThreads;

import android.util.Log;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            for(int i=0; i<10; i++){
                Thread.sleep(1000);
                Log.e("t2:[thread]", "Hilo 2: " + i);
            }
        } catch (InterruptedException e) {
            Log.e("t2:[thread]", e.getMessage() );
        }
    }//run
}//