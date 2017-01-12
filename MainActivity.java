package com.example.sid.minim;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Open_screen open_screen = new Open_screen();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1, open_screen);
        fragmentTransaction.commit();

    }

    public void open_search() {
        Search search = new Search();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container1, search);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void db_res() {
        Db_result db_result = new Db_result();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container1, db_result);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void add_student() {
        Add_Student add_student = new Add_Student();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container1, add_student);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void search_by_name(String n) {
        Db_result_search_by_name db_result_search_by_name = new Db_result_search_by_name();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Bundle b = new Bundle();
        b.putString("n", n);
        Toast.makeText(MainActivity.this, "Hello " + n, Toast.LENGTH_SHORT).show();
        db_result_search_by_name.setArguments(b);
        ft.replace(R.id.container1, db_result_search_by_name);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void search_by_mobile(String mobile) {
        Db_result_search_by_mobile db_result_search_by_mobile = new Db_result_search_by_mobile();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Bundle b = new Bundle();
        b.putString("mobile", mobile);
        Toast.makeText(MainActivity.this, "Hello" + mobile, Toast.LENGTH_SHORT).show();
        db_result_search_by_mobile.setArguments(b);
        ft.replace(R.id.container1, db_result_search_by_mobile);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void open_first_screen() {
        Open_screen open_screen = new Open_screen();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container1, open_screen);
        ft.commit();
    }

   public void open_forget_password() {
        Forget_pwd fp = new Forget_pwd();
        fp.show(getSupportFragmentManager(), null);

    }

    public void open_date_picker(String da)
     {
         Date_picker dp = new Date_picker();
         Bundle b = new Bundle();
         b.putString("da",da);
         Add_Student add = new Add_Student();
         add.setArguments(b);
         dp.show(getSupportFragmentManager(),null);
     }
    public void open_login() {
        Login login = new Login();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container1, login);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void send_sms() {
        Send_message send_message = new Send_message();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container1, send_message);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void open_registration() {
        Register register = new Register();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container1, register);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void home_screen() {
        Home_screen home_screen = new Home_screen();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container1, home_screen);
        ft.addToBackStack(null);
        ft.commit();
    }

}

