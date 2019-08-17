package com.android.jokeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TellJokeActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "Joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tell_joke);

        TextView tvJokeDisplay = (TextView) findViewById(R.id.tv_JokeDisplay);

        String JokefromIntent = null;

        Intent intent = getIntent();
        JokefromIntent = intent.getStringExtra(JOKE_KEY);

        if (JokefromIntent != null){
            tvJokeDisplay.setText(JokefromIntent);
        }
        else{
            tvJokeDisplay.setText("We could not find the joke.  That is definitely not funny!");
        }
    }
}
