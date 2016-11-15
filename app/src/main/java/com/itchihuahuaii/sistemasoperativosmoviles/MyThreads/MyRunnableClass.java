package com.itchihuahuaii.sistemasoperativosmoviles.MyThreads;

import android.util.Log;

/**
 * Created by usuario1 on 11/12/2016.
 */
public class MyRunnableClass implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 100; i < 110; i++){
                Thread.sleep(1000);
                Log.e ("t1:<<runnable>>", "Hilo numero 1: " + i);
            }
        } catch (InterruptedException e) {
            Log.e ("t1:<<runnable>>", e.getMessage() );
        }
    }//run
}//
