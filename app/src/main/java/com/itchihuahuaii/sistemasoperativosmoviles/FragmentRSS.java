package com.itchihuahuaii.sistemasoperativosmoviles;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class FragmentRSS extends Fragment {

    ArrayAdapter<String> adapterMainSubjects;
    ListView myMainListView;
    Context context;
    SingleItem selectedNewsItem;
    // hard-coding main NEWS categories (TODO: use a resource file)
    String[][] myUrlCaptionMenu = {
            {"http://www.npr.org/rss/rss.php?id=1001", "Top Stories"},
            {"http://www.npr.org/rss/rss.php?id=1003", "U.S. News"},
            {"http://www.npr.org/rss/rss.php?id=1004", "World News"},
            {"http://www.npr.org/rss/rss.php?id=1006", "Business"},
            {"http://www.npr.org/rss/rss.php?id=1007", "Health & Science"},
            {"http://www.npr.org/rss/rss.php?id=1008", "Arts & Entertainment"},
            {"http://www.npr.org/rss/rss.php?id=1012", "Politics & Society"},
            {"http://www.npr.org/rss/rss.php?id=1021", "People & Places"},
            {"http://www.npr.org/rss/rss.php?id=1057", "Opinion"}
    };
    //define convenient URL and CAPTIONs arrays
    String[] myUrlCaption = new String[myUrlCaptionMenu.length];
    String[] myUrlAddress = new String[myUrlCaptionMenu.length];

    public FragmentRSS() {

    }

    Button telefono, busqueda;
    String msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rss, container, false);

        for (int i = 0; i < myUrlAddress.length; i++) {
            myUrlAddress[i] = myUrlCaptionMenu[i][0];
            myUrlCaption[i] = myUrlCaptionMenu[i][1];
        }
        context = getActivity().getApplicationContext();
// user will tap on a ListView’s row to request category’s headlines
        myMainListView = (ListView) view.findViewById(R.id.listView);
        myMainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> _av, View _v,
                                    int _index, long _id) {
                String urlAddress = myUrlAddress[_index];
                String urlCaption = myUrlCaption[_index];
//create an Intent to talk to activity: ShowHeadlines
                Intent callShowHeadlines = new Intent(getContext(),
                        ShowHeadlines.class);
                Bundle myData = new Bundle();
                myData.putString("urlAddress", urlAddress);
                myData.putString("urlCaption", urlCaption);
                callShowHeadlines.putExtras(myData);
                getContext().startActivity(callShowHeadlines);
            }
        });
// fill up the Main-GUI’s ListView with main news categories
        adapterMainSubjects = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,myUrlCaption);
        //android's default myUrlCaption);
        myMainListView.setAdapter(adapterMainSubjects);


    // method returns a value such as "Monday Apr 7, 2014"


    return view;
}
    public static String niceDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("EE MMM d, yyyy ", Locale.US);
        return sdf.format(new Date());
    }

}
