package com.example.androiduiexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView contextText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toolbar

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Drawer

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        // Context Menu TextView

        contextText = findViewById(R.id.contextText);

        registerForContextMenu(contextText);

        // Navigation Drawer Click Events

        navigationView.setNavigationItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.home) {

                Toast.makeText(MainActivity.this,
                        "Home Selected", Toast.LENGTH_SHORT).show();
            }

            else if (id == R.id.profile) {

                Toast.makeText(MainActivity.this,
                        "Profile Selected", Toast.LENGTH_SHORT).show();
            }

            else if (id == R.id.settings) {

                Toast.makeText(MainActivity.this,
                        "Settings Selected", Toast.LENGTH_SHORT).show();
            }

            drawerLayout.closeDrawers();

            return true;
        });
    }

    // Create Context Menu

    @Override
    public void onCreateContextMenu(ContextMenu menu,
                                    View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    // Context Menu Click

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.edit) {

            Toast.makeText(this,
                    "Edit Selected",
                    Toast.LENGTH_SHORT).show();
        }

        else if (id == R.id.delete) {

            Toast.makeText(this,
                    "Nazish Shahzadi",
                    Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}
