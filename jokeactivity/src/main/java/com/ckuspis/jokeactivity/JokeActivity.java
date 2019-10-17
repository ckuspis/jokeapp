package com.ckuspis.jokeactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView thejoke = (TextView) findViewById(R.id.tv_joke);
        Intent intent = getIntent();
        thejoke.setText(intent.getStringExtra("jokeText"));
    }
}
