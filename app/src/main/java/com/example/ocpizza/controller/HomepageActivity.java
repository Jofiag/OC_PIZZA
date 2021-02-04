package com.example.ocpizza.controller;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ocpizza.R;
import com.example.ocpizza.fragment.RestaurantListViewFragment;
import com.example.ocpizza.fragment.RestaurantMapViewFragment;
import com.example.ocpizza.fragment.WorkmateListViewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomepageActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        setReferences();
        attachNewFragment(new RestaurantMapViewFragment()); // Showing the RestaurantMapViewFragment when first start the activity
        setBottomNavigationView();
    }

    private void setReferences() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
    }

    @SuppressLint("NonConstantResourceId")
    private void setBottomNavigationView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            switch (id){
                case R.id.restaurant_map_view_item:
                    attachNewFragment(new RestaurantMapViewFragment());
                    return true;
                case R.id.restaurant_list_view_item:
                    attachNewFragment(new RestaurantListViewFragment());
                    return true;
                case R.id.workmate_list_view_item:
                    attachNewFragment(new WorkmateListViewFragment());
                    return true;
            }

            return false;
        });
    }

    private void attachNewFragment(Fragment newFragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragment_container_homepage_activity, newFragment)
                .commit();
    }
}