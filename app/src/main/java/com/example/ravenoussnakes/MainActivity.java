package com.example.ravenoussnakes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting all views
        Toolbar mainToolbar = findViewById(R.id.main_toolbar);
        Button gameButton = findViewById(R.id.button_game);
        Button statsButton = findViewById(R.id.button_stats);
        Button profileButton = findViewById(R.id.button_profile);

        // setting up toolbar for app
        setSupportActionBar(mainToolbar);

        // setting up navigation between fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_frag_container, GameFragment.class, null)
                .setReorderingAllowed(true)
                .addToBackStack("Game")
                .commit();


        // navigate to Game Fragment
        gameButton.setOnClickListener( button -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_frag_container, GameFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("Game")
                    .commit();
        } );

        // navigate to Stats Fragment
        statsButton.setOnClickListener( button -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_frag_container, StatsFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("Stats")
                    .commit();
        } );

        // navigate to Profile Fragment
        profileButton.setOnClickListener( button -> {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_frag_container, ProfileFragment.class, null)
                    .setReorderingAllowed(true)
                    .addToBackStack("Profile")
                    .commit();
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
}