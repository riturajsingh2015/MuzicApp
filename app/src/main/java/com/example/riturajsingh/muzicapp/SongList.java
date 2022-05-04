package com.example.riturajsingh.muzicapp;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Rituraj Singh on 12/6/2017.
 */

public class SongList {

    private Context mContext;////used to store Context which is passed onto Song Class while Creating Song Objects

    public SongList(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<Song> SongListFiveSongs() {

        ArrayList<Song> songList = new ArrayList<>();

        ////////////List Consists of Only 5 Songs/////////
        songList.add(new Song(mContext, R.string.song1_name, R.string.song1_artist_name, R.string.song1_album_name, R.string.song1_length, R.string.song1_playlist, R.raw.song1));
        songList.add(new Song(mContext, R.string.song2_name, R.string.song2_artist_name, R.string.song2_album_name, R.string.song2_length, R.string.song2_playlist, R.raw.song2));
        songList.add(new Song(mContext, R.string.song3_name, R.string.song3_artist_name, R.string.song3_album_name, R.string.song3_length, R.string.song3_playlist, R.raw.song3));
        songList.add(new Song(mContext, R.string.song4_name, R.string.song4_artist_name, R.string.song4_album_name, R.string.song4_length, R.string.song4_playlist, R.raw.song4));
        songList.add(new Song(mContext, R.string.song5_name, R.string.song5_artist_name, R.string.song5_album_name, R.string.song5_length, R.string.song5_playlist, R.raw.song5));

        return songList;
    }

    public ArrayList<Song> SongList20Songs() {

        ArrayList<Song> songList = new ArrayList<>();

        ////////////List Consists of Only 20 Songs/////////
        songList.add(new Song(mContext, R.string.ss_song1_name, R.string.ss_song1_album_name));
        songList.add(new Song(mContext, R.string.ss_song2_name, R.string.ss_song2_album_name));
        songList.add(new Song(mContext, R.string.ss_song3_name, R.string.ss_song3_album_name));
        songList.add(new Song(mContext, R.string.ss_song4_name, R.string.ss_song4_album_name));
        songList.add(new Song(mContext, R.string.ss_song5_name, R.string.ss_song5_album_name));
        songList.add(new Song(mContext, R.string.ss_song6_name, R.string.ss_song6_album_name));
        songList.add(new Song(mContext, R.string.ss_song7_name, R.string.ss_song7_album_name));
        songList.add(new Song(mContext, R.string.ss_song8_name, R.string.ss_song8_album_name));
        songList.add(new Song(mContext, R.string.ss_song9_name, R.string.ss_song9_album_name));
        songList.add(new Song(mContext, R.string.ss_song10_name, R.string.ss_song10_album_name));
        songList.add(new Song(mContext, R.string.ss_song11_name, R.string.ss_song11_album_name));
        songList.add(new Song(mContext, R.string.ss_song12_name, R.string.ss_song12_album_name));
        songList.add(new Song(mContext, R.string.ss_song13_name, R.string.ss_song13_album_name));
        songList.add(new Song(mContext, R.string.ss_song14_name, R.string.ss_song14_album_name));
        songList.add(new Song(mContext, R.string.ss_song15_name, R.string.ss_song15_album_name));
        songList.add(new Song(mContext, R.string.ss_song16_name, R.string.ss_song16_album_name));
        songList.add(new Song(mContext, R.string.ss_song17_name, R.string.ss_song17_album_name));
        songList.add(new Song(mContext, R.string.ss_song18_name, R.string.ss_song18_album_name));
        songList.add(new Song(mContext, R.string.ss_song19_name, R.string.ss_song19_album_name));
        songList.add(new Song(mContext, R.string.ss_song20_name, R.string.ss_song20_album_name));

        return songList;
    }


}
