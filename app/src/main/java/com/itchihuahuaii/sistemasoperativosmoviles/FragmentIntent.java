package com.itchihuahuaii.sistemasoperativosmoviles;

import android.app.Dialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FragmentIntent extends Fragment {


    public FragmentIntent() {

    }

    Button telefono, busqueda;
    String msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intent, container, false);
        telefono = (Button) view.findViewById(R.id.telefono);
        busqueda = (Button)view.findViewById(R.id.busqueda_web);
        telefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myPhoneNumberUri = "tel:6145132222";
                Intent myActivity2 = new Intent(Intent.ACTION_DIAL,
                        Uri.parse(myPhoneNumberUri));
                startActivity(myActivity2);
            }
        });
        busqueda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,
                        "android intents");
                startActivity(intent);
            }
        });


        return view;
    }

}
