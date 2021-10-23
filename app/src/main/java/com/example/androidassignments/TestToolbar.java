package com.example.androidassignments;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.androidassignments.databinding.ActivityTestToolbarBinding;

public class TestToolbar extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityTestToolbarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTestToolbarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test_toolbar);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello World", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_test_toolbar);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public boolean onCreateOptionsMenu (Menu m) {
        getMenuInflater().inflate(R.menu.toolbar_menu, m );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi) {
        int id = mi.getItemId();
        Toast toast;
        String text;
        int duration = Toast.LENGTH_SHORT;

        switch(id) {
            case R.id.action_one:
                text = "You selected item 1";
                Log.d("Toolbar", text);
                Snackbar.make(findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.action_two:
                AlertDialog.Builder builder = new AlertDialog.Builder(TestToolbar.this);
                builder.setTitle(R.string.some_title);
                // Add the buttons
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        finish();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                // Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.action_three:
                AlertDialog.Builder builder2 = new AlertDialog.Builder(TestToolbar.this);

                builder2.setMessage(R.string.dialog_message_2)
                        .setTitle(R.string.dialog_title_2);

                LayoutInflater inflater = TestToolbar.this.getLayoutInflater();
                builder2.setView(inflater.inflate(R.layout.custom, null));

                builder2.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // Send the positive button event back to the host activity
                    }
                });

                AlertDialog dialog2 = builder2.create();
                dialog2.show();
                break;
            case R.id.about:
                text = "Version 1.0, by Dennis Au";
                Log.d("Toolbar", text);
                toast = Toast.makeText(TestToolbar.this , text, duration); //this is the ListActivity
                toast.show(); //display your message box
                break;
        }
        return true;
    }
}