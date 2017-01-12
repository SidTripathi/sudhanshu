package com.example.sid.minim;


import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Db_result_search_by_name extends Fragment {

    MyDb myDb;
    Cursor cursor;
    EditText name_search;
    SimpleCursorAdapter ca;
    ListView lv;
    MainActivity mainActivity;
    public Db_result_search_by_name() {
        // Required empty public constructor
    }
    public void result(String name)
    {
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
        View view = inflater.inflate(R.layout.fragment_db_result_search_by_name, container, false);
        lv = (ListView)view.findViewById(R.id.lv);
        mainActivity = (MainActivity)getActivity();

        Bundle b = getArguments();
        String nam = b.getString("n");
        if(nam!=null) {
            cursor = myDb.getByname(nam.toLowerCase());
            //Toast.makeText(getActivity(),"welcome "+nam, Toast.LENGTH_SHORT).show();

            //step-2 establish link between cursor and cursor adapter
            if(cursor!=null) {

                ca = new SimpleCursorAdapter(getActivity(), R.layout.row, cursor, new String[]{"_id", "sname", "smobile", "semail", "scourse", "ssubject"},
                        new int[]{R.id.id1, R.id.name, R.id.mobile, R.id.email, R.id.course, R.id.subject});
            }
            else
            {
                Toast.makeText(getActivity(), "No data found", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                alert.setIcon(R.drawable.alert);
                alert.setTitle("Invalid!");
                alert.setMessage("No data found with the name "+nam);
                alert.setCancelable(false);
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mainActivity.open_search();
                    }
                });
                AlertDialog alertDialog = alert.create();
                alertDialog.show();
            }
            //ste-3 establish link between cursor and listview
        }
        else
        {
            Toast.makeText(getActivity(), "no value", Toast.LENGTH_LONG).show();
        }
        lv.setAdapter(ca);
        return view;
    }

}
