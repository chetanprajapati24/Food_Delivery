package com.chirag.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;


import com.chirag.food.deliveryFoodPanel.DeliveryPendingOrdersFragment;
import com.chirag.food.deliveryFoodPanel.DeliveryShippingOrdersFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class DeliveryFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_food_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.delivery_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        if (item.getItemId() == R.id.shiporders) {
            fragment = new DeliveryShippingOrdersFragment();
        } else if (item.getItemId() == R.id.pendingorders) {
            fragment = new DeliveryPendingOrdersFragment();
        }

        return loaddeliveryfragment(fragment);
    }

    private boolean loaddeliveryfragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
        return false;
    }
}