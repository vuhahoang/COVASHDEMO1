package com.example.covash_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import org.eazegraph.lib.charts.BarChart;
import org.eazegraph.lib.charts.StackedBarChart;
import org.eazegraph.lib.models.BarModel;
import org.eazegraph.lib.models.StackedBarModel;

public class homepage extends AppCompatActivity {

    MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        //Khai báo
        bottomNavigation = (MeowBottomNavigation) findViewById(R.id.bottom_navigation);

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

    private void loadfragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }
}