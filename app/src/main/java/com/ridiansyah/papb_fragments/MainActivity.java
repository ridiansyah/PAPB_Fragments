package com.ridiansyah.papb_fragments;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAllFragment();
    }

    private void initializeAllFragment() {
        FirstFragment firstFragment = new FirstFragment();
        SecondFragment secondFragment = new SecondFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        int screenOrientation = getResources().getConfiguration().orientation;

        //untuk portrait
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (screenOrientation == Configuration.ORIENTATION_LANDSCAPE){
            fragmentTransaction.replace(R.id.fragment_left, firstFragment);
            fragmentTransaction.replace(R.id.fragment_right, secondFragment);
            Toast.makeText(getBaseContext(),"landscape", Toast.LENGTH_SHORT).show();
        } else {
            fragmentTransaction.add(R.id.container, firstFragment);
            Toast.makeText(getBaseContext(),"portrait", Toast.LENGTH_SHORT).show();
        }
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);
    }
}
