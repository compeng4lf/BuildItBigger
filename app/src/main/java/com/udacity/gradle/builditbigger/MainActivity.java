package com.udacity.gradle.builditbigger;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.android.jokeslib.FetchJoke;


public class MainActivity extends AppCompatActivity {

    public String fetchedJoke = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {

        FetchJoke fetchJoke = new FetchJoke();

        //Step 1 - Create Toast with Java Library
        //Toast.makeText(this, fetchJoke.fetchJoke(), Toast.LENGTH_SHORT).show();

        //Step 2 - Create Android Library and pass joke from Java Library
        //Intent intent = new Intent(this, TellJokeActivity.class);
        //intent.putExtra("Joke", fetchJoke.fetchJoke());
        //startActivity(intent);

        //Step 3 - Run AsyncTask to fetch joke using cloud
        new EndpointAsyncTask().execute(this);



    }


}
