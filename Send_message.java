package com.example.sid.minim;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Send_message extends Fragment {
    Button s,c;
    EditText t,sub,mes;

    public Send_message() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_send_message, container, false);

        s = (Button)view.findViewById(R.id.send);
        c = (Button)view.findViewById(R.id.close);
        t=(EditText)view.findViewById(R.id.to);
        sub = (EditText)view.findViewById(R.id.subject);
        mes = (EditText)view.findViewById(R.id.message);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity=(MainActivity)getActivity();
                mainActivity.home_screen();
                t.setText("");
                sub.setText("");
                mes.setText("");

            }
        });
        return view;
    }

}
