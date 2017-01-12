package com.example.sid.minim;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Forget_pwd extends Fragment {
    EditText et1;

    public Forget_pwd() {
        // Required empty public constructor
    }

    public Dialog onCreateDialog( Bundle savedInstanceState)


    {
        // Inflate the layout for this fragment
        Dialog d = null;
        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setIcon(R.drawable.alert);
        alert.setTitle("Forget Password");
        View view =getActivity().getLayoutInflater().inflate(R.layout.fragment_forget_pwd, null);
        View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_forget_pwd, null);
        et1 = (EditText) v.findViewById(R.id.email);
        alert.setView(v);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(), et1.getText() + " requested password.", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = alert.create();
        alertDialog.show();
        d = alertDialog;
        return d;
    }

    public void show(FragmentManager supportFragmentManager, Object o) {
    }
}
