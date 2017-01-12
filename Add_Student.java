package com.example.sid.minim;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Add_Student extends Fragment {

    EditText dat,n,m,c,s,em,rn;
    Button d,save,cancel;
    MyDb myDb;
    MainActivity mainActivity;
    //Cursor cur;
    //SimpleCursorAdapter ca;
    //MyDb myDb;

    public Add_Student() {
        // Required empty public constructor
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
       View view= inflater.inflate(R.layout.fragment_add__student, container, false);
        dat = (EditText)view.findViewById(R.id.dat);
        n = (EditText)view.findViewById(R.id.name);
        rn = (EditText)view.findViewById(R.id.rollno);
        m = (EditText)view.findViewById(R.id.mobile);
        em = (EditText)view.findViewById(R.id.email);
        c = (EditText)view.findViewById(R.id.course);
        s = (EditText)view.findViewById(R.id.subject);
        //Bundle b = getArguments();
        //String da = b.getString("da");
        //dat.setText(da);
        d = (Button)view.findViewById(R.id.dateb);
        save = (Button)view.findViewById(R.id.save);
        cancel = (Button)view.findViewById(R.id.cancel);
        mainActivity = (MainActivity)getActivity();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( n.getText().toString().length()>0 && rn.getText().toString().length()>0 &&
                        m.getText().toString().length()>0 && em.getText().toString().length()>0 &&
                        c.getText().toString().length()>0 && s.getText().toString().length()>0 && dat.getText().toString().length()>0)
                {
                    Toast.makeText(getActivity(),"Data saved successfully.", Toast.LENGTH_LONG).show();


                    String sname = n.getText().toString();
                    String scourse = c.getText().toString();
                    String ssubject = s.getText().toString();
                    String rollno = rn.getText().toString();
                    String smail = em.getText().toString();
                    String smobile = m.getText().toString();
                    String sdate = dat.getText().toString();
                    myDb.insert(rollno,sname,smobile,smail,scourse,ssubject,sdate);
                    Toast.makeText(getActivity(), "Inserted successfully", Toast.LENGTH_SHORT).show();
                    rn.setText("");
                    rn.requestFocus();
                    n.setText("");
                    m.setText("");
                    em.setText("");
                    c.setText("");
                    s.setText("");
                    dat.setText("");
                }
                else
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setIcon(R.drawable.alert);
                    alert.setTitle("Invalid !");
                    alert.setMessage("Enter valid details.");
                    alert.setCancelable(false);
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.cancel();

                        }
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivity.home_screen();
            }
        });

        mainActivity = (MainActivity)getActivity();
        /*d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mainActivity.open_date_picker();
            }
        });*/
        return view;
    }
    public void getdate(String date)
    {
        //Toast.makeText(getActivity(), "Selected : "+date, Toast.LENGTH_SHORT).show();
        dat.setText(date);
    }
}



