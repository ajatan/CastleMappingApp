package com.example.castlemappingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.castlemappingapp.ui.dashboard.DashboardFragment;
import com.example.castlemappingapp.ui.home.HomeFragment;
import com.example.castlemappingapp.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        エラーのもと
//        fabのクリックイベントを作ろうと思ったけれど、エラーが出てきた
//        FloatingActionButton fab = findViewById(R.id.Pfab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplication(), MapPointEdit.class);
//                startActivity(intent);
//            }
//        });



        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.map)
                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);





        BottomNavigationView bottomNav = findViewById(R.id.nav_view);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }


    private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();

                            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                    selectedFragment).commit();

                            break;
                        case R.id.nav_public:
                            selectedFragment = new DashboardFragment();

                            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                    selectedFragment).commit();

                            break;
                        case R.id.nav_favorite:
                            selectedFragment = new NotificationsFragment();

                            getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                    selectedFragment).commit();

                            break;
                        case R.id.nav_map:
                            Intent intent = new Intent(getApplication(), MapsActivity.class);
                            startActivity(intent);



                            break;
                    }

                    return true;
                }
            };
}