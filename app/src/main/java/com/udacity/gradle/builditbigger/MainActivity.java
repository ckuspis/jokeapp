package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.Toast;

import com.ckuspis.jokeactivity.JokeActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void tellJoke(final View view) {

        Toast.makeText(view.getContext(), "getting jokes", Toast.LENGTH_SHORT).show();

        AsyncJoke getJoke = new AsyncJoke(this, new JokeResponseListener<String>() {
            @Override
            public void onSuccess(String object) {
                Intent createJokeActivity = new Intent(view.getContext(), JokeActivity.class);
                createJokeActivity.putExtra("JOKE", object);
                startActivity(createJokeActivity);
            }

            @Override
            public void onFailure(Exception exception) {
                Toast.makeText(view.getContext(),exception.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        getJoke.execute();

       //Toast.makeText(this, "Fetching joke from server...", Toast.LENGTH_SHORT).show();
    }



}
