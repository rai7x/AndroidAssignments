package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button loginButton = (Button) findViewById(R.id.login_button);
        loadUserData();
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

    public void onLoginClicked(View view) {
        saveUserData();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void saveUserData() {

        String file_name = getString(R.string.preference_name);
        SharedPreferences mPrefs = getSharedPreferences(file_name, MODE_PRIVATE);

        SharedPreferences.Editor myEditor = mPrefs.edit();
        myEditor.clear();
        String email_key  = getString(R.string.key_email);
        String new_email_entered = ((EditText) findViewById(R.id.login_email))
                .getText().toString();
        myEditor.putString(email_key, new_email_entered);
        myEditor.commit();
    }

    private void loadUserData() {

        String file_name = getString(R.string.preference_name);
        SharedPreferences myPrefs = getSharedPreferences(file_name, MODE_PRIVATE);

        String email_key = getString(R.string.key_email);
        String new_email_value = myPrefs.getString(email_key, " ");
        ((EditText) findViewById(R.id.login_email)).setText(new_email_value);

        String gender_key = getString(R.string.key_gender);
    }

}