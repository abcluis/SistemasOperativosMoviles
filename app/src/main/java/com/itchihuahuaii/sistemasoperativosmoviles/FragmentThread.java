package com.itchihuahuaii.sistemasoperativosmoviles;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.itchihuahuaii.sistemasoperativosmoviles.MyThreads.MyRunnableClass;
import com.itchihuahuaii.sistemasoperativosmoviles.MyThreads.MyThread;


public class FragmentThread extends Fragment {


    public FragmentThread() {

    }

    Button telefono, busqueda;
    String msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thread, container, false);
        Runnable myRunnable1 = new MyRunnableClass();
        Thread t1 = new Thread(myRunnable1);
        t1.start();
        MyThread t2 = new MyThread();
        t2.start();


        return view;
    }

}