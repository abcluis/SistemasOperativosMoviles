package com.itchihuahuaii.sistemasoperativosmoviles;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentFont extends Fragment {

    public FragmentFont() {
        // Required empty public constructor
    }

    TextView ejemplo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_font, container, false);
        ejemplo =(TextView)view.findViewById(R.id.ejemplo_font);
        Typeface tipo = Typeface.createFromAsset(getContext().getAssets(),"NITEMARE.TTF");
        ejemplo.setTypeface(tipo);
        return view;
    }

}
