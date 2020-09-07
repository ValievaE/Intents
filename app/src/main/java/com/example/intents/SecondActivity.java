package com.example.intents;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private final static String TAG = "lifeCycle demonstration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Second Activity onResume");
        setResult(1);
    }
}