package com.example.riturajsingh.muzicapp;

import android.content.Context;

/**
 * Created by Rituraj Singh on 12/6/2017.
 */

public class Song {

    ////////Member Variables regarding Song/////////
    private int mSongNameResId;
    private int mArtistNameResId;
    private int mAlbumNameResId;
    private int mLengthResId;
    private int mPlayListResId;
    private int mSongResIdResId;
    /////////We use Context priorly to use getString Method//////
    private Context mContext;

    /////////Constructor 1 -used elsewhere  ///////
    public Song() {
    }

    /////////Constructor 2 - Used Priorly for Main Activity  //////////
    public Song(Context mContext, int mSongNameResId, int mArtistNameResId, int mAlbumNameResId, int mLengthResId, int mPlayListResId, int mSongResIdResId) {
        this.mContext = mContext;
        this.mSongNameResId = mSongNameResId;
        this.mArtistNameResId = mArtistNameResId;
        this.mAlbumNameResId = mAlbumNameResId;
        this.mLengthResId = mLengthResId;
        this.mPlayListResId = mPlayListResId;
        this.mSongResIdResId = mSongResIdResId;
    }

    /////////Constructor 3 - Used Priorly for Search & Store Activities //////////////////
    public Song(Context mContext, int mSongNameResId, int mAlbumNameResId) {
        this.mContext = mContext;
        this.mSongNameResId = mSongNameResId;
        this.mAlbumNameResId = mAlbumNameResId;

    }

/////////////Methods are self Explainatory ////////////////////
    ////////////We use mContext to call getString on it ///////////

    public String getmSongNameAsString() {
        return mContext.getResources().getString(mSongNameResId);
    }

    public String getmArtistNameAsString() {

        return mContext.getResources().getString(mArtistNameResId);
    }

    public String getmAlbumNameAsString() {

        return mContext.getResources().getString(mAlbumNameResId);
    }

    public String getmLengthAsString() {

        return mContext.getResources().getString(mLengthResId);
    }

    public String getmPlayListAsString() {

        return mContext.getResources().getString(mPlayListResId);
    }

    public int getmSongResId() {
        return mSongResIdResId;
    }

}
