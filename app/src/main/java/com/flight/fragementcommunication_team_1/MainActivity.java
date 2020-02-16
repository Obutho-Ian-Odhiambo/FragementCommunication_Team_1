package com.flight.fragementcommunication_team_1;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements Fragement_One.OnFragmentInteractionListener, Fragement_two.OnFragmentInteractionListener{

    private static final String BLUE_TAG = "blue";
    private static final String GREEN_TAG = "green";

    Fragement_One FragmentOne;
    Fragement_two FragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // add fragments
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentOne = (Fragement_One) fragmentManager.findFragmentByTag(BLUE_TAG);
        if (FragmentOne == null) {
            FragmentOne = new Fragement_One();
            fragmentManager.beginTransaction().add(R.id.blue_fragment_container, FragmentOne, BLUE_TAG).commit();
        }

        FragmentTwo = (Fragement_two) fragmentManager.findFragmentByTag(GREEN_TAG);
        if (FragmentTwo == null) {
            FragmentTwo = new Fragement_two();
            fragmentManager.beginTransaction().add(R.id.green_fragment_container, FragmentTwo, GREEN_TAG).commit();
        }


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

    // The Activity handles receiving a message from one Fragment
    // and passing it on to the other Fragment
    public void messageFromFragmentOne(String message) {
        FragmentOne.youveGotMail(message);
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }
}
