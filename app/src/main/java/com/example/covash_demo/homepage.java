package com.example.covash_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.navigation.NavigationView;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.StackedBarChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.StackedBarModel;

public class homepage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    MeowBottomNavigation bottomNavigation;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Khai báo
        bottomNavigation = (MeowBottomNavigation) findViewById(R.id.bottom_navigation);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navimenu);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        //Thêm menu icon
        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_map));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_new));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.ic_person));


        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
               switch (item.getId()) {
                   case 1:
                       fragment = new DashboardFragment();
                       break;
                   case 2:
                       fragment = new MapFragment();
                       break;
                   case 3:
                       fragment = new newsFragment();
                       break;
                   case 4:
                       fragment = new infoFragment();
                       break;
               }
               loadfragment(fragment);

            }
        });

      bottomNavigation.setCount(1,"1");
      bottomNavigation.show(1,true);

      bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
          @Override
          public void onClickItem(MeowBottomNavigation.Model item) {
//              Toast.makeText(getApplicationContext(),"you clicked" + item.getId(),Toast.LENGTH_SHORT).show();
          }
      });

      bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
          @Override
          public void onReselectItem(MeowBottomNavigation.Model item) {
//              Toast.makeText(getApplicationContext(),"you reselect" + item.getId(),Toast.LENGTH_SHORT).show();
          }
      });
    }
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }



    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        if(item.getItemId() == R.id.nav_home){
            fragment = new DashboardFragment();
            bottomNavigation.show(1,true);
        }else if(item.getItemId() == R.id.nav_map){
            fragment = new MapFragment();
            bottomNavigation.setCount(1,"1");
            bottomNavigation.show(2,true);
        }else if(item.getItemId() == R.id.nav_news){
            fragment = new newsFragment();
            bottomNavigation.show(3,true);
        }
        else if(item.getItemId() == R.id.nav_info){
            fragment = new infoFragment();
            bottomNavigation.show(4,true);
        }else if(item.getItemId() == R.id.nav_logout){
            Intent i = new Intent(homepage.this,loginform.class);
            startActivity(i);
        }

        loadfragment(fragment);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void loadfragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }
}