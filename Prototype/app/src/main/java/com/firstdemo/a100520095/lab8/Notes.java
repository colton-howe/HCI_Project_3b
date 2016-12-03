package com.firstdemo.a100520095.lab8;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 100520095 on 12/1/2016.
 */

public class Notes implements Parcelable {
    private String title;
    private String owner;
    private String time;
    private String message;

    @Override
    public String toString(){
        String contents = "Title: " + title +"\nAuthor: " + owner + "\nTime Posted: " + time + "\nMessage: " + message;
        return contents;
    }

    public Notes (String title, String owner, String time, String message){
        this.title = title;
        this.owner = owner;
        this.time = time;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    protected Notes(Parcel in) {
        title = in.readString();
        owner = in.readString();
        time = in.readString();
        message = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(owner);
        dest.writeString(time);
        dest.writeString(message);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Notes> CREATOR = new Parcelable.Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };
}