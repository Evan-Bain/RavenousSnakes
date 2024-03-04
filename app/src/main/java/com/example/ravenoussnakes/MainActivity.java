package com.example.ravenoussnakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;
import android.os.Bundle;
import android.view.Menu;

import com.example.ravenoussnakes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // create NavController for fragments
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_container);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();

        // set up NavGraph for fragments
        NavGraph navGraph = navController.getNavInflater().inflate(R.navigation.nav_graph);
        navController.setGraph(navGraph);

        // navigate to Game Fragment when game button pressed
        binding.buttonGame.setOnClickListener(view ->
                navController.navigate(R.id.gameFragment)
        );

        // navigate to Stats Fragment when stats button pressed
        binding.buttonStats.setOnClickListener(view ->
                navController.navigate(R.id.statsFragment)
        );

        // navigate to Profile Fragment when profile button pressed
        binding.buttonProfile.setOnClickListener(view ->
                navController.navigate(R.id.profileFragment)
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}