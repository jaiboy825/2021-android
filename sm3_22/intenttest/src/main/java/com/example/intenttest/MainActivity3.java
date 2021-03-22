package com.example.intenttest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {
    Button MapBtn, BrowserBtn, CallBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        MapBtn = findViewById(R.id.mapBtn);
        BrowserBtn = findViewById(R.id.browserBtn);
        CallBtn = findViewById(R.id.callBtn);

        MapBtn.setOnClickListener(this);
        BrowserBtn.setOnClickListener(this);
        CallBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == MapBtn) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.3739224.127.1410424"));
            startActivity(intent);
        } else if (v == BrowserBtn) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
            startActivity(intent);
        } else if (v == CallBtn) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:031-114"));
            startActivity(intent);
        }
    }
}