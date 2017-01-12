package com.example.sid.minim;


import android.content.DialogInterface;
import android.os.Bundle;
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
public class Search extends Fragment {
    Button sn,sm;
    EditText sne,sme;
    MainActivity mainActivity;

    public Search() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_search, container, false);

        sn = (Button)view.findViewById(R.id.sea_name);
        sm = (Button)view.findViewById(R.id.sea_mob);
        sne = (EditText)view.findViewById(R.id.search_name);
        sme = (EditText)view.findViewById(R.id.search_mobile);
        mainActivity = (MainActivity)getActivity();
        sn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sne.getText().toString().length() <= 0) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                    alert.setIcon(R.drawable.alert);
                    alert.setTitle("Invalid!");
                    alert.setMessage("Enter valid name.");
                    alert.setCancelable(false);
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                            sne.requestFocus();
                        }
                    });
                    AlertDialog alertDialog = alert.create();
                    alertDialog.show();
                } else {

                    mainActivity.search_by_name(sne.getText().toString());
                    sne.setText("");
                    sne.requestFocus();
                    Toast.makeText(getActivity(), sne.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        sm.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      if (sme.getText().toString().length() <= 9) {
                                          AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                                          alert.setIcon(R.drawable.alert);
                                          alert.setTitle("Invalid!");
                                          alert.setMessage("Mobile number should be 10 digits.");
                                          alert.setCancelable(false);
                                          alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                              @Override
                                              public void onClick(DialogInterface dialogInterface, int i) {
                                                  dialogInterface.cancel();
                                                  sme.requestFocus();

                                              }
                                          });

                                          AlertDialog alertDialog = alert.create();
                                          alertDialog.show();
                                      }
                                      else {

                                          mainActivity.search_by_mobile(sme.getText().toString());
                                          sme.setText("");
                                          sme.requestFocus();
                                      }
                                  }
                              });
        return view;

    }

}
