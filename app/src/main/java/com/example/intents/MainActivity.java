package com.example.intents;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final int requestedCode = 1;
    private static final String stringKey = "textView key";
    private final static String TAG = "lifeCycle demonstration";
    private FloatingActionButton fab;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "MainActivity onCreate");

        textView = findViewById(R.id.textView);
        textView.append("\n" + "onCreate");

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, requestedCode);
            }
        });

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




        if (savedInstanceState != null){
            
            Log.d(TAG, "bundle не null");
            textView.append("\n" + "bundle не null");
        }

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "MainActivity onSaveInstState");

        textView.append("\n" + "onSaveInstanceState");
        outState.putString(stringKey, textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String restoredState = savedInstanceState.getString(stringKey);

        Log.d(TAG, "MainActivity onRestoreInstState " + restoredState);
        textView.append("\n" + "onRestoreInstanceState");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "MainActivity onRestart");
        textView.append("\n" + "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "MainActivity onResume");
        textView.append("\n" + "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity onPause");
        textView.append("\n" + "onPause");

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "MainActivity onPostResume");
        textView.append("\n" + "onPostResume");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, "MainActivity onPostCreate");
        textView.append("\n" + "onPostCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "MainActivity onStart");
        textView.append("\n" + "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity onStop");
        textView.append("\n" + "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity onDestroy");
        textView.append("\n" + "onDestroy");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == MainActivity.requestedCode){
            Toast.makeText(this, "Result from SecondActivity " + resultCode, Toast.LENGTH_LONG).show();
        }
        textView.append("\n" + "onActivityResult");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyDown " + keyCode);
        if (keyCode == KeyEvent.KEYCODE_SPACE){
            Log.d(TAG, "space");
        }
        textView.append("\n" + "onKeyDown");
        event.startTracking();
        return true;

    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        Log.d(TAG, "onKeyLongPress " + keyCode);
        textView.append("\n" + "onKeyLongPress");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed");
        textView.append("\n" + "onBackPressed");
        super.onBackPressed();
    }


}