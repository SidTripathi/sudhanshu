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
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    TextView fp;
    EditText un,pw;
    Button login,cancel;
    MainActivity mainActivity;

    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        fp = (TextView)view.findViewById(R.id.fp);
        un = (EditText)view.findViewById(R.id.un);
        pw = (EditText)view.findViewById(R.id.pwd);
        login = (Button)view.findViewById(R.id.login);
        cancel = (Button)view.findViewById(R.id.cancel);
        mainActivity = (MainActivity)getActivity();
        fp.setClickable(true);
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.open_forget_password();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences sp = getActivity().getSharedPreferences("Emp_details",0);
                String email = sp.getString("Emp_mail",null);
                String pwd = sp.getString("Emp_pwd",null);
                String name = sp.getString("Emp_name",null);
                if(un.getText().toString().equals(email) && pw.getText().toString().equals(pwd))
                {
                    mainActivity.home_screen();
                    Toast.makeText(getActivity(), "Hello"+name, Toast.LENGTH_SHORT).show();
                    un.setText("");
                    pw.setText("");
                }
                else
                {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setIcon(R.drawable.alert);
                    alert.setTitle("Invalid !");
                    alert.setMessage("Username or password is incorrect.");
                    alert.setCancelable(false);
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            un.requestFocus();
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

                mainActivity.open_first_screen();
            }
        });
        return view;
    }

}




