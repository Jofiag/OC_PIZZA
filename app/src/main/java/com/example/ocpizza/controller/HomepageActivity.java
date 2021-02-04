package com.example.ocpizza.controller;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ocpizza.R;
import com.example.ocpizza.fragment.RestaurantListViewFragment;
import com.example.ocpizza.fragment.RestaurantMapViewFragment;
import com.example.ocpizza.fragment.WorkmateListViewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class HomepageActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Toolbar myToolbar;
    private DrawerLayout myDrawerLayout;
    private NavigationView myNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        setReferences();
        attachNewFragment(new RestaurantMapViewFragment()); // Showing the RestaurantMapViewFragment when first start the activity
        setBottomNavigationView();
        setMyToolbarAsAppBar();
        setMyDrawerLayout();
        setMyNavigationView();
    }

    private void setReferences() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        myToolbar = findViewById(R.id.my_toolbar);
        myDrawerLayout = findViewById(R.id.my_drawer);
        myNavigationView = findViewById(R.id.my_navigation_view);
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

    private void setMyToolbarAsAppBar(){
        setSupportActionBar(myToolbar);
    }

    private void setMyDrawerLayout(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(HomepageActivity.this,
                myDrawerLayout,
                myToolbar,
                R.string.open_navigation_drawer_description_text, R.string.close_navigation_drawer_description_text);

        myDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void setMyNavigationView(){
//        Drawable itemBackground = ResourcesCompat.getDrawable(getResources(), R.drawable.baseline_local_dining_24, null);
        myNavigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.your_lunch_item) {
                //Attach fragment corresponding
                myDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
            else if (id == R.id.settings_item) {
                //Attach fragment corresponding
                myDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
            else if (id == R.id.logout_item) {
                //Attach fragment corresponding
                myDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

            myDrawerLayout.closeDrawers(); // OR myDrawerLayout.closeDrawer(GravityCompat.START);

            return true;
        });
    }

    //Make sure we close the DrawerLayout when the user click on back button
    @Override
    public void onBackPressed() {
        if (myDrawerLayout.isOpen())
            myDrawerLayout.closeDrawers();
        else
            super.onBackPressed();
    }
}