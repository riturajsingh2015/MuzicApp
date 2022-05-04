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
////////////Class is similar to SongAdapterMain , Difference is here we use Buy Button which redirects to Payment Activity//////////
public class SongAdapterForStore extends ArrayAdapter<Song> {

    private Song mItemGot;//// Member variable to store Song
    private Context mContext;///Member variable to Store Context //////

    SongAdapterForStore(Activity context, ArrayList<Song> songsList) {
        super(context, 0, songsList);///intialize adapter using super class constructor
        this.mContext = context;///Intialize context

    }

    @NonNull
    @Override///////we overide getView which returns a listview item
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /////Get the ListView which we want to fill
        View listItemView = convertView;

        //if null then inflate layout///////////
        if (listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.store_activity_listview_item, parent, false);

        mItemGot = getItem(position);////Get Item One after another according to order of the Songs in ArrayList

        ///Get & Set ListView's TextViews with Corresponding Texts and Depicted below////////
        TextView songName = listItemView.findViewById(R.id.store_activity_song_name);
        songName.setText(mItemGot.getmSongNameAsString());

        TextView albumName = listItemView.findViewById(R.id.store_activity_album_name);
        albumName.setText(mItemGot.getmAlbumNameAsString());

        Button buyButton = listItemView.findViewById(R.id.store_activity_buy_button);// Get the BuyButton
        buyButton.setTag(position);// Set Tag on the Button
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {///Set OnClickListener on it
                //////Redirect to Payment Activity Using clickedButtonPosition & Ex- Intent/////////////////
                Intent AudioPlayingIntent = new Intent(mContext, PaymentActivity.class);
                int clickedButtonPosition = (Integer) view.getTag();
                AudioPlayingIntent.setData(Uri.parse(Integer.toString(clickedButtonPosition)));
                mContext.startActivity(AudioPlayingIntent);

            }
        });

        return listItemView;

    }

}
