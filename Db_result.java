package com.example.sid.minim;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Db_result extends Fragment {
    MyDb myDb;
    Cursor cursor;
    SimpleCursorAdapter ca;
    ListView lv;

    public Db_result() {
        // Required empty public constructor
    }
    public void result(String name){
        Toast.makeText(getActivity(),name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new MyDb(getActivity());
        myDb.open();
    }

    @Override
    public void onDestroy() {
        myDb.close();
        super.onDestroy();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_db_result, container, false);
        lv = (ListView)view.findViewById(R.id.lv);
        cursor = myDb.queryStudent();
        //step-2 establish link between cursor and cursor adapter

        ca = new SimpleCursorAdapter(getActivity(),R.layout.row,cursor,new String[]{"_id","sname","smobile","semail","scourse","ssubject"},
                new int[]{R.id.id1,R.id.name,R.id.mobile,R.id.email,R.id.course,R.id.subject});

        //ste-3 establish link between cursor and listview

        lv.setAdapter(ca);

        return view;
    }

}
