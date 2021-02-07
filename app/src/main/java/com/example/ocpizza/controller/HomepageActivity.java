package com.example.ocpizza.controller;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

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
import com.example.ocpizza.util.Constants;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

public class HomepageActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Toolbar myToolbar;
    private DrawerLayout myDrawerLayout;
    private NavigationView myNavigationView;
    private MaterialSearchView materialSearchView;

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

        setMaterialSearchView();
    }

    private void setReferences() {
        bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        myToolbar = findViewById(R.id.my_toolbar);
        myDrawerLayout = findViewById(R.id.my_drawer);
        myNavigationView = findViewById(R.id.my_navigation_view);
        materialSearchView = findViewById(R.id.my_material_search_view);
    }

    @SuppressLint("NonConstantResourceId")
    private void setBottomNavigationView(){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int id = item.getItemId();

            switch (id){
                case R.id.restaurant_map_view_item:
                    myToolbar.setTitle(Constants.IM_HUNGRY_TITLE_TEXT);
                    attachNewFragment(new RestaurantMapViewFragment());
                    return true;
                case R.id.restaurant_list_view_item:
                    myToolbar.setTitle(Constants.IM_HUNGRY_TITLE_TEXT);
                    attachNewFragment(new RestaurantListViewFragment());
                    return true;
                case R.id.workmate_list_view_item:
                    myToolbar.setTitle(Constants.AVAILABLE_WORKMATES_TITLE_TEXT);
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


    @Override
    //Make sure we close the DrawerLayout when the user click on back button
    public void onBackPressed() {
        if (myDrawerLayout.isOpen())
            myDrawerLayout.closeDrawers();
        else
            super.onBackPressed();
    }

    private String getRestaurantNameSearchedByUser(){
        String restaurantName = "";

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction()))
            restaurantName = intent.getStringExtra(SearchManager.QUERY);

        return restaurantName;
    }

    private void doMyResearch(String restaurantName){

    }

    private void setMaterialSearchView(){
        String[] array = new String[]{"Hello", "How", "Are", "You", "Today"};

        //materialSearchView.closeSearch();
        materialSearchView.setSuggestions(array);
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //search the query that the user enter to search
                materialSearchView.setVisibility(View.VISIBLE);
                doMyResearch(getRestaurantNameSearchedByUser());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Make changes in realtime
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_view_menu, menu);

        MenuItem item = menu.findItem(R.id.search_item);
        materialSearchView.setMenuItem(item);

        return true;
    }
}