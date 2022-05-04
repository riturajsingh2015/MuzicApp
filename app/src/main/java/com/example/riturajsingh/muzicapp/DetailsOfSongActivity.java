package com.example.riturajsingh.muzicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsOfSongActivity extends AppCompatActivity {

    private ArrayList<Song> mSongList = new SongList(this).SongListFiveSongs();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_song);

        ////Get Intent from Now Playing Activity & then fill TextView's with Corresponding details of the Song ////////////////////
        Intent songDetailIntent = getIntent();
        int songDetailId = Integer.parseInt(songDetailIntent.getDataString());

        TextView songName = findViewById(R.id.songs_detail_song_name);
        songName.setText(mSongList.get(songDetailId).getmSongNameAsString());

        TextView albumName = findViewById(R.id.songs_detail_album_name);
        albumName.setText(mSongList.get(songDetailId).getmAlbumNameAsString());

        TextView artistName = findViewById(R.id.songs_detail_artist_name);
        artistName.setText(mSongList.get(songDetailId).getmArtistNameAsString());

        TextView songLength = findViewById(R.id.songs_detail_length);
        songLength.setText(mSongList.get(songDetailId).getmLengthAsString());

        TextView songPlaylist = findViewById(R.id.songs_detail_playlist);
        songPlaylist.setText(mSongList.get(songDetailId).getmPlayListAsString());

///Get Store and Home Buttons and set OnClickListeners on them redirecting them to corrspoding activities using Explicit Intents
        Button homeButton = findViewById(R.id.detail_home_button);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToDetailsOfSong = new Intent(DetailsOfSongActivity.this, MainActivity.class);
                startActivity(goToDetailsOfSong);
            }
        });

        Button storeButton = findViewById(R.id.detail_store_button);
        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToStore = new Intent(DetailsOfSongActivity.this, StoreActivity.class);
                startActivity(goToStore);
            }
        });

    }

}
