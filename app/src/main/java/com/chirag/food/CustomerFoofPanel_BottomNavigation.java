package com.chirag.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.chirag.food.customerFoodPanel.CustomerCartFragmnet;
import com.chirag.food.customerFoodPanel.CustomerHomeFragment;
import com.chirag.food.customerFoodPanel.CustomerOrderFragment;
import com.chirag.food.customerFoodPanel.CustomerProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class CustomerFoofPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_foof_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.cust_Home) {
            fragment = new CustomerHomeFragment();
        } else if (item.getItemId() == R.id.cart) {
            fragment = new CustomerCartFragmnet();
        } else if (item.getItemId() == R.id.cust_profile) {
            fragment = new CustomerProfileFragment();
        } else if (item.getItemId() == R.id.Cust_order) {
            fragment = new CustomerCartFragmnet();
        }else if (item.getItemId() == R.id.cart) {
            fragment = new CustomerOrderFragment();
        }

        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {

        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }
}