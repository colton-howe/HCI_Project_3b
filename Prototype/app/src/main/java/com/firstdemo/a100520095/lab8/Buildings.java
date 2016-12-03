package com.firstdemo.a100520095.lab8;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by 100520095 on 12/1/2016.
 */

public class Buildings implements Parcelable {
    private String name;
    private String description;
    private ArrayList<Notes> notes;

    public Buildings(String name, String description, ArrayList<Notes> notes){
        this.name = name;
        this.description = description;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Notes> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Notes> notes) {
        this.notes = notes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected Buildings(Parcel in) {
        name = in.readString();
        description = in.readString();
        if (in.readByte() == 0x01) {
            notes = new ArrayList<Notes>();
            in.readList(notes, Notes.class.getClassLoader());
        } else {
            notes = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        if (notes == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(notes);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Buildings> CREATOR = new Parcelable.Creator<Buildings>() {
        @Override
        public Buildings createFromParcel(Parcel in) {
            return new Buildings(in);
        }

        @Override
        public Buildings[] newArray(int size) {
            return new Buildings[size];
        }
    };
}