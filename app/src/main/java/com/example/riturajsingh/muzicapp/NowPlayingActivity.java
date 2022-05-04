package com.example.riturajsingh.muzicapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    private ArrayList<Song> mSongList = new SongList(this).SongListFiveSongs();
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        /////get the Intent from MainActivity/////////
        Intent ButtonClickIntent = getIntent();
        final int positionOfButtonClicked = Integer.parseInt(ButtonClickIntent.getDataString());////Prase it to int since it was sent as String

        //////Set TextViews in NowPlaying Activity with corresponding text using positionOfButtonClicked
        TextView songName = findViewById(R.id.now_playing_song_name);
        songName.setText(mSongList.get(positionOfButtonClicked).getmSongNameAsString());
        TextView albumName = findViewById(R.id.now_playing_album_name);
        albumName.setText(mSongList.get(positionOfButtonClicked).getmAlbumNameAsString());
        TextView artistName = findViewById(R.id.now_playing_artist_name);
        artistName.setText(mSongList.get(positionOfButtonClicked).getmArtistNameAsString());

        //////To start playing song use positionOfButtonClicked to get corresponding Resource Id of the Song
        int AudioResId = mSongList.get(positionOfButtonClicked).getmSongResId();
        releaseMediaPlayer();
        mMediaPlayer = MediaPlayer.create(NowPlayingActivity.this, AudioResId);
        mMediaPlayer.start();
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                releaseMediaPlayer();
            }
        });

        ///Get Store and Search Buttons and set OnClickListeners on them redirecting them to corrspoding activities using Explicit Intents
        Button storeButton = findViewById(R.id.now_playing_store_button);
        storeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToStore = new Intent(NowPlayingActivity.this, StoreActivity.class);
                startActivity(goToStore);
            }
        });

        ////////Also send Data of positionOfButtonClicked to Detail Activity also/////////////
        Button songDeatilsButton = findViewById(R.id.now_playing_details_button);
        songDeatilsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToDetailsOfSong = new Intent(NowPlayingActivity.this, DetailsOfSongActivity.class);
                goToDetailsOfSong.setData(Uri.parse(Integer.toString(positionOfButtonClicked)));
                startActivity(goToDetailsOfSong);
            }
        });

    }

    ///////      Source- Github     ///////////////////
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }

}
