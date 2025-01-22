package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv = findViewById(R.id.bottomNavigationView);
        bnv.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            if (item.getItemId() == R.id.home) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.favourite) {
                selectedFragment = new FavouriteFragment(); // Replace with your FavouriteFragment
            } else if (item.getItemId() == R.id.messages) {
                selectedFragment = new MessageFragment();
            } else if (item.getItemId() == R.id.account) {
                selectedFragment = new AccountFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, selectedFragment).commit();
            return true;
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
    }
}