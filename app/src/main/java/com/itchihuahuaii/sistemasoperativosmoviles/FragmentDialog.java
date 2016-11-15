package com.itchihuahuaii.sistemasoperativosmoviles;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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


public class FragmentDialog extends Fragment {


    public FragmentDialog() {

    }

    Button alert, customAlert;
    String msg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        alert = (Button) view.findViewById(R.id.btn_alert);
        customAlert = (Button) view.findViewById(R.id.btn_custom_dialog);

        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMyAlertDialog((MainActivity) getContext());
            }
        });
        customAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialogBox();
            }
        });
        return view;
    }


    private void showMyAlertDialog(MainActivity mainActivity) {
        new AlertDialog.Builder(mainActivity)
                .setTitle("Terminator")
                .setMessage("Are you sure that you want to quit?")
                .setIcon(R.drawable.ic_menu_gallery)
                // set three option buttons
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                // actions serving "YES" button go here
                                msg = "YES " + Integer.toString(whichButton);
                                //txtMsg.setText(msg);
                            }
                        })
                .setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                                // actions serving "CANCEL" button go here
                                msg = "CANCEL " + Integer.toString(whichButton);
                                //txtMsg.setText(msg);
                            }// OnClick
                        })// setNeutralButton
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // actions serving "NO" button go here
                        msg = "NO " + Integer.toString(whichButton);
                        //txtMsg.setText(msg);
                    }
                })// setNegativeButton
                .create()
                .show();
    }//

    private void showCustomDialogBox() {
        final Dialog customDialog = new Dialog(getContext());
        customDialog.setTitle("Titulo del dialogo");
            // match customDialog with custom dialog layout
        customDialog.setContentView(R.layout.custom_dialog_layout);
        ((TextView) customDialog.findViewById(R.id.sd_textView1))
                .setText("\nMessage line1\nMessage line2\n"
                        + "Dismiss: Back btn, Close, or touch outside");
        final EditText sd_txtInputData = (EditText) customDialog
                .findViewById(R.id.sd_editText1);
        ((Button) customDialog.findViewById(R.id.sd_btnClose))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customDialog.dismiss();
                    }
                });
        customDialog.show();
    }

}
