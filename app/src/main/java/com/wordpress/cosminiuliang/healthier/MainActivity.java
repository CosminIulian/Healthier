package com.wordpress.cosminiuliang.healthier;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        // initial color for nav (home color)
        bottomNav.setItemBackgroundResource(R.color.home_nav);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();


            bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            bottomNav.setItemBackgroundResource(R.color.home_nav);
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_list:
                            bottomNav.setItemBackgroundResource(R.color.list_nav);
                            selectedFragment = new GoToListFragment();
                            break;
                        case R.id.nav_calc:
                            bottomNav.setItemBackgroundResource(R.color.calc_nav);
                            selectedFragment = new CalculatorFragment();
                            break;
                        case R.id.nav_info:
                            bottomNav.setItemBackgroundResource(R.color.info_nav);
                            selectedFragment = new InformationFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            });
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_author) {
            Intent intent = new Intent(getApplicationContext(), AuthorDetails.class);
            this.startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
