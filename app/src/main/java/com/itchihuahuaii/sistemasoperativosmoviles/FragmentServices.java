package com.itchihuahuaii.sistemasoperativosmoviles;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FragmentServices extends Fragment {

    TextView txtMsg;
    ComponentName service;
    Intent intentMyService3;
    BroadcastReceiver receiver;
    Button boton;

    public FragmentServices() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services, container, false);
        txtMsg = (TextView) view.findViewById(R.id.txtMsg);

        intentMyService3 = new Intent(getContext(), MyService3.class);
        service = getContext().startService(intentMyService3);

        txtMsg.setText("MyService3 started - (see LogCat)");
        boton = (Button)view.findViewById(R.id.btnStopService);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getContext().stopService(intentMyService3);
                    txtMsg.setText("After stoping Service: \n" + service.getClassName() );
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // register & define filter for local listener
        IntentFilter mainFilter = new IntentFilter("matos.action.GOSERVICE3");
        receiver = new MyMainLocalReceiver();
        getContext().registerReceiver(receiver, mainFilter);

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            getContext().stopService(intentMyService3);
            getContext().unregisterReceiver(receiver);
        } catch (Exception e) {
            Log.e ("MAIN3-DESTROY>>>", e.getMessage() );
        }
        Log.e ("MAIN3-DESTROY>>>" , "Adios" );
    }
    public class MyMainLocalReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context localContext, Intent callerIntent) {
            String serviceData = callerIntent.getStringExtra("service3Data");
            Log.e ("MAIN>>>", "Data received from Service3: " + serviceData);
            String now = "\nService3Data: > " + serviceData;
            txtMsg.append(now);
        }
    }//MyMainLocalReceiver
}


