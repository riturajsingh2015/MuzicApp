package com.example.riturajsingh.muzicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    /////////Make ArrayList of 20 Songs  for our Search Activity can Search 20 Songs //////////////////////
    private ArrayList<Song> mSongList = new SongList(this).SongList20Songs();
    private ListView mSearchListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //// Get ListView of Search Activity ///////////
        mSearchListView = findViewById(R.id.search_activity_listview);
        ////Crate Song Adapter for  Search Activity //////////
        final SongAdapterForSearch searchAdapter = new SongAdapterForSearch(SearchActivity.this, mSongList);

        //// Get SearchView of Search Activity ///////////
        SearchView searchView = findViewById(R.id.search_activity_searchview);
        /////////Set Query Text Listener on it //////
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override ////Filter Results on Text Change
            public boolean onQueryTextChange(String s) {
                searchAdapter.getFilter().filter(s);
                mSearchListView.setAdapter(searchAdapter);
                return false;
            }
        });

        //////Get Home Button and Set OnClickListener on it to redirect it to Main Activity ///////
        Button homeButton = findViewById(R.id.search_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToMain = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(goToMain);
            }
        });

    }

}
