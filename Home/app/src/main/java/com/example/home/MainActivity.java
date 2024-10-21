package com.example.home;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.home.fragments.ExploreFragment;
import com.example.home.fragments.HomeFragment;
import com.example.home.fragments.LibraryFragment;
import com.example.home.fragments.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ViewPager2 mainviewPager;
    ArrayList<Fragment> FragmentArrayList = new ArrayList<>();

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        mainviewPager = findViewById(R.id.main_view_pager);
        FragmentArrayList.add(new HomeFragment());
        FragmentArrayList.add(new ExploreFragment());
        FragmentArrayList.add(new LibraryFragment());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, FragmentArrayList);
        mainviewPager.setAdapter(viewPagerAdapter);

        mainviewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.nav_home);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.nav_explore);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.nav_library);
                        break;
                }

                super.onPageSelected(position);
            }
        });
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.nav_home){
                mainviewPager.setCurrentItem(0);
                }
                if (item.getItemId() == R.id.nav_explore){
                    mainviewPager.setCurrentItem(1);
                }
                if (item.getItemId() == R.id.nav_library){
                    mainviewPager.setCurrentItem(2);
                }
                return true;
            }
        });


    }
}
