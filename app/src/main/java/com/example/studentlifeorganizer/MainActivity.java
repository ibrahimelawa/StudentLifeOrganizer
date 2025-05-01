package com.example.studentlifeorganizer;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = findViewById(R.id.bottomNavigation_Student);
        fragmentManager.beginTransaction()
                .replace(R.id.flFragment_Student, new HomeFragment())
                .commit();
        bottomNavigationView.setSelectedItemId(R.id.nav_home);


        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("الرئيسية"));
        tabLayout.addTab(tabLayout.newTab().setText("تفاصيل"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override public void onTabSelected(@NonNull TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        fragmentManager.beginTransaction()
                                .replace(R.id.flFragment_Student, new HomeFragment())
                                .commit();
                        bottomNavigationView.setSelectedItemId(R.id.nav_home);
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, DetailsActivity.class));
                        tabLayout.selectTab(tabLayout.getTabAt(0));
                        bottomNavigationView.setSelectedItemId(R.id.nav_home);
                        break;
                }
            }
            @Override public void onTabUnselected(@NonNull TabLayout.Tab tab) { }
            @Override public void onTabReselected(@NonNull TabLayout.Tab tab) { }
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    tabLayout.selectTab(tabLayout.getTabAt(0));
                    break;
                case R.id.nav_tasks:
                    selectedFragment = new tasksFragment();
                    break;
                case R.id.nav_setting:
                    selectedFragment = new settingFragment();
                    break;
                case R.id.nav_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }
            if (selectedFragment != null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.flFragment_Student, selectedFragment)
                        .commit();
            }
            return true;
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment current = fragmentManager.findFragmentById(R.id.flFragment_Student);
        if (current instanceof HomeFragment) {
            tabLayout.selectTab(tabLayout.getTabAt(0));
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
        }
    }

    @Override
    public void onBackPressed() {
        Fragment current = fragmentManager.findFragmentById(R.id.flFragment_Student);
        if (!(current instanceof HomeFragment)) {
            fragmentManager.beginTransaction()
                    .replace(R.id.flFragment_Student, new HomeFragment())
                    .commit();
            bottomNavigationView.setSelectedItemId(R.id.nav_home);
            tabLayout.selectTab(tabLayout.getTabAt(0));
        } else {
            super.onBackPressed();
        }
    }
}
