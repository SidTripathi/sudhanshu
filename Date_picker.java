package com.example.sid.minim;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class Date_picker extends DialogFragment {
    MainActivity mainActivity;

    public Date_picker() {
        // Required empty public constructor
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog d = null;
        mainActivity = (MainActivity)getActivity();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int mon = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);
        DatePickerDialog dp = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                Toast.makeText(getActivity(), "Selected : "+i2+"-"+(i1+1)+"-"+i, Toast.LENGTH_SHORT).show();
                mainActivity.open_date_picker(i2+"-"+(i1+1)+"-"+i);
            }
        },year,mon,date);

        d = dp;
        return d;
    }

}
