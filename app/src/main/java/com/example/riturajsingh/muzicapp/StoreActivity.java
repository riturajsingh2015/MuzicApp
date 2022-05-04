package com.example.riturajsingh.muzicapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        // Store Activity uses 20 Songs from the SongList class to fill it's ListView
        final ArrayList<Song> songList = new SongList(this).SongList20Songs();

        SongAdapterForStore listItemAdapterForStoreActivity = new SongAdapterForStore(this, songList);

        ListView mainActivity_SongListView = findViewById(R.id.store_activity_listview);

        mainActivity_SongListView.setAdapter(listItemAdapterForStoreActivity);

    }

}
