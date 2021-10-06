package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_NAME, "In onCreate()");
        Button mainButton = (Button) findViewById(R.id.main_button);
    }

    public void onMainClicked(View view) {
        Intent intent = new Intent(this, ListItemsActivity.class);
        startActivityForResult(intent, 10);
    }

    public void onActivityResult(int requestCode, int responseCode, Intent data) {
        super.onActivityResult(requestCode, responseCode, data);
        if ((requestCode == 10) && (responseCode == Activity.RESULT_OK)) {
            Log.i(ACTIVITY_NAME, "Returned to MainActivity.onActivityResult");
            String messagePassed = data.getStringExtra("Response");
            Toast toast = Toast.makeText(this , messagePassed, Toast.LENGTH_LONG); //this is the ListActivity
            toast.show(); //display your message box
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}