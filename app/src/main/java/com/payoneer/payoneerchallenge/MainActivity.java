package com.payoneer.payoneerchallenge;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.payoneer.payoneerchallenge.databinding.ActivityMainBinding;
import dagger.hilt.android.AndroidEntryPoint;
import java.util.HashSet;
import java.util.Set;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        appBarConfiguration = new AppBarConfiguration.Builder(getTopLevelDestinations())
                .build();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        assert navHostFragment != null;
        navController = navHostFragment.getNavController();

        setupActionBar();
    }

    private void setupActionBar() {
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }

    private Set<Integer> getTopLevelDestinations() {
        Set<Integer> topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.dest_homeFragment);
        return topLevelDestinations;
    }
}