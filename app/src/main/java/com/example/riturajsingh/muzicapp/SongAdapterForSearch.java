package com.example.riturajsingh.muzicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rituraj Singh on 12/9/2017.
 */
//////////////  Source - StackOverFlow //////////////////////
public class SongAdapterForSearch extends BaseAdapter implements Filterable {
    private Context mC;///Member Variable For Context
    private ArrayList<Song> mSongList;////Member Variable For SongList
    private CustomFilter mFilter;////Member Variable For Custom Filter
    private ArrayList<Song> mFilterList;//Member Variable For Filtered List

    ////////Constructor //////////
    public SongAdapterForSearch(Context ctx, ArrayList<Song> songList) {
        this.mC = ctx;
        this.mSongList = songList;
        this.mFilterList = songList;
    }

    ////////Following are the overridden Methods of BaseAdapter ////////////////
    @Override
    public int getCount() {
        return mSongList.size();
    }

    @Override
    public Song getItem(int pos) {
        return mSongList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return mSongList.indexOf(getItem(pos));
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mC.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.store_activity_listview_item, null);
        }

        ///////////Get & Set ListView items   ////////////////
        Song mItemGot = mSongList.get(pos);
        TextView songName = convertView.findViewById(R.id.store_activity_song_name);
        songName.setText(mItemGot.getmSongNameAsString());

        TextView albumName = convertView.findViewById(R.id.store_activity_album_name);
        albumName.setText(mItemGot.getmAlbumNameAsString());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new CustomFilter();
        }
        return mFilter;
    }

    //INNER CLASS ////Create a Custom Filter for input text////////////
    class CustomFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            /////if input is not null and is >0 in length , then create new Filter Result object which contains text same as that in SongList Nmae variable ///////
            if (constraint != null && constraint.length() > 0) {
                //CONSTARINT TO UPPER
                constraint = constraint.toString().toUpperCase();
                ArrayList<Song> filters = new ArrayList<>();
                //get specific items
                for (int i = 0; i < mFilterList.size(); i++) {
                    ////if the input text is contained in the song name then add that Song to filter list to be displayed later on
                    if (mFilterList.get(i).getmSongNameAsString().toUpperCase().contains(constraint)) {
                        filters.add(mFilterList.get(i));
                    }
                }
                results.count = filters.size();
                results.values = filters;
            } else  ///////just make result set same as songList
            {
                results.values = mSongList;
                results.count = mSongList.size();
            }

            return results;
        }

        @SuppressWarnings("unchecked")
////////Casting Filter Result to ArrayList is an Unchecked Exception.//////
        @Override//////////publish result  and notify to listview
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mSongList = (ArrayList<Song>) results.values;
            notifyDataSetChanged();
        }
    }
}
