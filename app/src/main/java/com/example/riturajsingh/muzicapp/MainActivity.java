package com.example.riturajsingh.muzicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////we first make a list of 5 songs using SongList class for our MainActivity ///////////
        final ArrayList<Song> songList = new SongList(this).SongListFiveSongs();

        ////This is Custom Adapter for Main accepting the context and the ArrayList of Songs
        SongAdapterForMain listItemAdapterForMainActivity = new SongAdapterForMain(this, songList);

        ///Get the ListView from Main's Layout
        ListView mainActivity_SongListView = findViewById(R.id.main_activity_list_view);

        //Set the Adapter on this ListView
        mainActivity_SongListView.setAdapter(listItemAdapterForMainActivity);

        ///Get Store and Search Buttons and set OnClickListeners on them redirecting them to corrspoding activities using Explicit Intents
        Button storeButton = findViewById(R.id.main_activity_store_button);
        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToStore = new Intent(MainActivity.this, StoreActivity.class);
                startActivity(goToStore);
            }
        });

        Button searchButton = findViewById(R.id.main_activity_search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToSearch = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(goToSearch);
            }
        });

    }

}
