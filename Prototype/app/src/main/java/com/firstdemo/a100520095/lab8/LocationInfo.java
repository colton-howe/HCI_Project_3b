package com.firstdemo.a100520095.lab8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_info);
        Intent intent = getIntent();
        Buildings notes = intent.getParcelableExtra("location");

        TextView title = (TextView)findViewById(R.id.lblBuilding);
        title.setText(notes.getName());

        TextView description = (TextView)findViewById(R.id.lblDescription);
        description.setText(notes.getDescription());

        ListView lv = (ListView)findViewById(R.id.listNotes);
        ArrayAdapter<Notes> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notes.getNotes());
        lv.setAdapter(adapter);
    }
}
