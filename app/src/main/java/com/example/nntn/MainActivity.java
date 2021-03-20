package com.example.nntn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void ame_btn(View v) {
Intent intent = new Intent(this, Menu_select.class);
startActivity(intent);
}

public void juice_btn(View v) {
        Intent intent = new Intent(this, Menu_select.class);
        startActivity(intent);
    }

    public void latte_btn(View v) {
        Intent intent = new Intent(this, Menu_select.class);
        startActivity(intent);
    }
    public void aid_btn(View v) {
        Intent intent = new Intent(this, Menu_select.class);
        startActivity(intent);
    }
    public void tea_btn(View v) {
        Intent intent = new Intent(this, Menu_select.class);
        startActivity(intent);
    }
    public void smuth_btn(View v) {
        Intent intent = new Intent(this, Menu_select.class);
        startActivity(intent);
    }
    public void call_btn(View v) {
        Intent intent = new Intent(this, sms.class);
        startActivity(intent);
    }
}
