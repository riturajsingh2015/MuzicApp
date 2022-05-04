package com.example.riturajsingh.muzicapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rituraj Singh on 12/6/2017.
 */

public class SongAdapterForMain extends ArrayAdapter<Song> {
    private Song mItemGot; //// Member variable to store Song
    private Context mContext; ///Member variable to Store Context //////

    SongAdapterForMain(Activity context, ArrayList<Song> songsList) {
        super(context, 0, songsList); ///intialize adapter using super class constructor
        this.mContext = context;///Intialize context
    }

    @NonNull
    @Override////////we overide getView which returns a listview item
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /////Get the ListView which we want to fill
        View listItemView = convertView;

        //if null then inflate layout///////////
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.main_activity_listview_item, parent, false);

        mItemGot = getItem(position);///Get Item One after another according to order of the Songs in ArrayList

        ///Get & Set ListView's TextViews with Corresponding Texts and Depicted below////////
        TextView songName = listItemView.findViewById(R.id.main_activity_song_name);
        songName.setText(mItemGot.getmSongNameAsString());

        TextView albumName = listItemView.findViewById(R.id.main_activity_album_name);
        albumName.setText(mItemGot.getmAlbumNameAsString());

        Button playButton = listItemView.findViewById(R.id.main_activity_play_button);// Get the PlayButton
        playButton.setTag(position); // Set Tag on the Button
        ///Set OnClickListener on it
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //////Start Now Playing Activity using Ex-Intent & Position of Clicked Button /////////////////
                Intent AudioPlayingIntent = new Intent(mContext, NowPlayingActivity.class);
                int clickedButtonPosition = (Integer) view.getTag();
                AudioPlayingIntent.setData(Uri.parse(Integer.toString(clickedButtonPosition)));///Set Data with Clicked button Position
                mContext.startActivity(AudioPlayingIntent);

            }
        });

        return listItemView;

    }

}
