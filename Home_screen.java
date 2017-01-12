package com.example.sid.minim;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_screen extends Fragment {
    Button phd,mphil,btech,mtech,vb,search,sms;
    MainActivity mainActivity;

    public Home_screen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home_screen, container, false);
        phd = (Button)view.findViewById(R.id.phd);
        btech = (Button)view.findViewById(R.id.btech);
        mtech = (Button)view.findViewById(R.id.mtech);
        mphil = (Button)view.findViewById(R.id.mphil);
        vb = (Button)view.findViewById(R.id.v);
        search = (Button)view.findViewById(R.id.s);
        sms = (Button)view.findViewById(R.id.sm);
        mainActivity = (MainActivity) getActivity();
        phd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.add_student();
            }
        });
        btech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.add_student();
            }
        });
        mphil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.add_student();
            }
        });
        mtech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.add_student();
            }
        });
        vb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.db_res();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivity.open_search();
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.send_sms();
            }
        });
        return view;
    }


}
