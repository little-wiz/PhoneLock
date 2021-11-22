package com.wizard.phonelock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Gib Access", Toast.LENGTH_SHORT).show();
        startService(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS)
        .setPackage(getPackageName()));
    }
}