package com.dilshan.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.dilshan.bottomnavigation.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction homeTrans = getSupportFragmentManager().beginTransaction();
        homeTrans.replace(R.id.content,new HomeFragment());
        homeTrans.commit();

        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.home:
                        transaction.replace(R.id.content, new HomeFragment());
                        break;
                    case R.id.search:
                        transaction.replace(R.id.content, new SearchFragment());
                        break;
                    case R.id.cart:
                        transaction.replace(R.id.content, new CartFragment());
                        break;
                    case R.id.settings:
                        transaction.replace(R.id.content, new SettingsFragment());
                        break;
                }
                transaction.commit();
                return true;
            }
        });
    }
}