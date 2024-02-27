package com.chirag.food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.chirag.food.chefFoodPanel.ChefHomeFragment;
import com.chirag.food.chefFoodPanel.ChefOrderfragment;
import com.chirag.food.chefFoodPanel.ChefPendingOrderFragment;
import com.chirag.food.chefFoodPanel.ChefProfileFragment;
import com.chirag.food.customerFoodPanel.CustomerHomeFragment;
import com.chirag.food.customerFoodPanel.CustomerTrackFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ChefFoodPanel_BottomNavigation extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

   // Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // toolbar =findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        setContentView(R.layout.activity_chef_food_panel_bottom_navigation);
        BottomNavigationView navigationView =findViewById(R.id.chef_bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);
        String name=getIntent().getStringExtra("PAGE");
        if(name!=null){
            if(name.equalsIgnoreCase("Orderpage")){
                loadcheffragment(new ChefHomeFragment());
            }else if (name.equalsIgnoreCase("Confirmpage")){
                loadcheffragment(new ChefOrderfragment());

            }else if (name.equalsIgnoreCase("AcceptOrderpage")){
                loadcheffragment(new ChefOrderfragment());

            }else if (name.equalsIgnoreCase("Deliverepage")){
                loadcheffragment(new ChefOrderfragment());
            }else{
                loadcheffragment(new ChefHomeFragment());
            }

        }


    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.logout);
        return true;
    } */

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment =null;
        if (item.getItemId() == R.id.chefHome) {
            fragment = new ChefHomeFragment();
        } else if (item.getItemId() == R.id.PendingOrders) {
            fragment = new ChefPendingOrderFragment();
        } else if (item.getItemId() == R.id.Orders) {
            fragment = new ChefOrderfragment();
        } else if (item.getItemId() == R.id.chefProfile) {
            fragment = new ChefProfileFragment();
        }
        return loadcheffragment(fragment);
    }

    private boolean loadcheffragment(Fragment fragment) {
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container ,fragment).commit();
            return true;
        }
        return false;
    }
}