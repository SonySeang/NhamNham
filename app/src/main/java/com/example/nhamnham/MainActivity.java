package com.example.nhamnham;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.nhamnham.fragments.HomeFragment;
import com.example.nhamnham.fragments.SearchFragment;
import com.example.nhamnham.fragments.OrderFragment;
import com.example.nhamnham.fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                loadFragment(new HomeFragment());
            } else if (id == R.id.nav_search) {
                loadFragment(new SearchFragment());
            } else if (id == R.id.nav_order) {
                loadFragment(new OrderFragment());
            } else if (id == R.id.nav_profile) {
                loadFragment(new ProfileFragment());
            } else {
                return false;
            }
            return true;
        });

        // Load default fragment
        loadFragment(new HomeFragment());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment) // <-- This should be your container
                .commit();
    }
}