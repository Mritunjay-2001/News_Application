package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.newsapp.Fragments.Account;
import com.example.newsapp.Fragments.Home;
import com.example.newsapp.Fragments.Notification;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {
    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bnView = findViewById(R.id.bnView);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if(id==R.id.home){
                    loadFrag(new Home(),false);
//                    getSupportActionBar().hide();


                }else if(id==R.id.notification){

                    loadFrag(new Notification(),false);


                }else if(id==R.id.account){

                    loadFrag(new Account(),false);

                }
                return true;
            }
        });

        bnView.setSelectedItemId(R.id.home);

    }


    @SuppressLint("SuspiciousIndentation")
    public void loadFrag(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(flag) {
            ft.add(R.id.frame_layout, fragment);
            fm.popBackStack();
        }else
            ft.replace(R.id.frame_layout,fragment);
        ft.addToBackStack(null);
        ft.commit();

    }

}