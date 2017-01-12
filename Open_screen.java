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
public class Open_screen extends Fragment {

    Button login, reg;
    MainActivity mainActivity;

    public Open_screen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_open_screen, container, false);
        login = (Button) view.findViewById(R.id.login);
        reg = (Button) view.findViewById(R.id.register);
        mainActivity = (MainActivity) getActivity();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.open_login();

            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.open_registration();
            }
        });
        return view;
    }
}

