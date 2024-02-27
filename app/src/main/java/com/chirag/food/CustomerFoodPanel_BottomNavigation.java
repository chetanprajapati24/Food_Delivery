package com.chirag.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.chirag.food.customerFoodPanel.CustomerCartFragmnet;
import com.chirag.food.customerFoodPanel.CustomerHomeFragment;
import com.chirag.food.customerFoodPanel.CustomerOrderFragment;
import com.chirag.food.customerFoodPanel.CustomerProfileFragment;
import com.chirag.food.customerFoodPanel.CustomerTrackFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class CustomerFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_food_panel_bottom_navigation);
        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        String name = getIntent().getStringExtra("PAGE");
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        if(name!=null)
        {
            if(name.equalsIgnoreCase("Homepage")){
                loadcheffragment(new CustomerHomeFragment());
            }else if (name.equalsIgnoreCase("Preparingpage")){
                loadcheffragment(new CustomerTrackFragment());

            }else if (name.equalsIgnoreCase("DeliveryOrderpage")){
                loadcheffragment(new CustomerTrackFragment());

            }else if (name.equalsIgnoreCase("Thankyoupage")){
                loadcheffragment(new CustomerHomeFragment());
            }else{
                loadcheffragment(new CustomerHomeFragment());
            }

        }

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
            fragment = new CustomerOrderFragment();
        }else if (item.getItemId() == R.id.track) {
            fragment = new CustomerTrackFragment();
        }else if (item.getItemId() == R.id.cust_Home) {
            fragment = new CustomerHomeFragment();
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