package com.example.ass2androidnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void course(View view) {
        Intent intent = new Intent(this,MainKhoaHoc.class);
        startActivity(intent);
    }

    public void maps(View view) {
        Intent intent = new Intent(this,MainMap.class);
        startActivity(intent);
    }

    public void news(View view) {
        Intent intent = new Intent(this,MainNews.class);
        startActivity(intent);
    }
    public void social(View view) {
        Intent intent = new Intent(this,facebookLogin.class);
        startActivity(intent);
    }
}