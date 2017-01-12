package com.example.sid.minim;


import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Register extends Fragment {
    Button reg,login;
    AlertDialog.Builder alert;
    EditText eno,ename,email,epwd,ecpwd,ephint;
    MainActivity mainActivity;

    public Register() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        reg = (Button) view.findViewById(R.id.reg);
        login = (Button) view.findViewById(R.id.lin);
        eno = (EditText) view.findViewById(R.id.eno);
        //eno1 = eno.getText().toString().length();
        ename = (EditText) view.findViewById(R.id.ename);
        //ename1 = ename.getText().toString().length();
        email = (EditText) view.findViewById(R.id.email);
        //email1 = email.getText().toString().length();
        epwd = (EditText) view.findViewById(R.id.epwd);
        //epwd1 = epwd.getText().toString().length();
        ecpwd = (EditText) view.findViewById(R.id.ecpwd);
        //ecpwd1 = ecpwd.getText().toString().length();
        ephint = (EditText) view.findViewById(R.id.ephint);
        //ephint1 = ephint.getText().toString().length();
        mainActivity = (MainActivity) getActivity();
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (eno.getText().toString().length() > 0 && ename.getText().toString().length() > 0 &&
                        epwd.getText().toString().length() > 0 && email.getText().toString().length() > 0 &&
                        ecpwd.getText().toString().length() > 0 && ephint.getText().toString().length() > 0) {
                    if (epwd.getText().toString().equals(ecpwd.getText().toString())) {
                        SharedPreferences sp = getActivity().getSharedPreferences("Emp_details", 0);
                        SharedPreferences.Editor se = sp.edit();
                        se.putString("Emp_name", ename.getText().toString());
                        se.putString("Emp_num", eno.getText().toString());
                        se.putString("Emp_pwd", epwd.getText().toString());
                        se.putString("Emp_cpwd", ecpwd.getText().toString());
                        se.putString("Emp_mail", email.getText().toString());
                        se.putString("Emp_phint", ephint.getText().toString());
                        se.commit();
                        if (se.commit()) {
                            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                            alert.setIcon(R.drawable.alert);
                            alert.setTitle("Registration Status !");
                            alert.setMessage(ename.getText().toString() + " , you registered successfully.");
                            alert.setCancelable(false);
                            alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });

                            AlertDialog alertDialog = alert.create();
                            alertDialog.show();
                            eno.setText("");
                            ename.setText("");
                            email.setText("");
                            epwd.setText("");
                            ecpwd.setText("");
                            ephint.setText("");

                        }
                    } else {
                        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                        //alert.setIcon("@drawable/doctor");
                        alert.setTitle("Invalid!");
                        alert.setMessage("Confirm password not matched with the password. ");
                        alert.setCancelable(false);
                        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.cancel();

                            }
                        });

                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();
                        epwd.requestFocus();
                    }
                } else {

                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    //alert.setIcon("@drawable/doctor");
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
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eno.getText().toString().length() > 0 && ename.getText().toString().length() > 0 &&
                        epwd.getText().toString().length() > 0 && email.getText().toString().length() > 0 &&
                        ecpwd.getText().toString().length() > 0 && ephint.getText().toString().length() > 0) {

                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setIcon(R.drawable.alert);
                    alert.setTitle("Confirmation");
                    alert.setMessage("Do you want to go away from this page?");
                    alert.setCancelable(false);
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            mainActivity.open_login();
                            eno.setText("");
                            ename.setText("");
                            email.setText("");
                            epwd.setText("");
                            ecpwd.setText("");
                            ephint.setText("");

                        }
                    });
                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            dialogInterface.cancel();
                        }
                    });

                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                } else {
                    mainActivity.open_login();
                }

            }
        });
        return view;
    }

}
