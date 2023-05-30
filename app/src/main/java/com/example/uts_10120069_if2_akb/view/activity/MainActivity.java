package com.example.uts_10120069_if2_akb.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.uts_10120069_if2_akb.R;
import com.example.uts_10120069_if2_akb.view.fragments.infoFragment;
import com.example.uts_10120069_if2_akb.view.fragments.listFragment;
import com.example.uts_10120069_if2_akb.view.fragments.profileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * NAMA    : Rendy Agustin
 * NIM     : 10120069
 * Kelas   : IF-2
 * MatKul  : Aplikasi Komputasi Bergerak
 */


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.body_container, new listFragment()).commit();
        navigationView.setSelectedItemId(R.id.list);

//        getFragmentPage(new listFragment());

        navigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()){
                case R.id.list:
                    fragment = new listFragment();
                    break;
                case R.id.profile:
                    fragment = new profileFragment();
                    break;
                case R.id.info:
                    fragment = new infoFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.body_container, fragment).commit();
            return true;
        });

        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

    }

    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.bottomNavigationView, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}