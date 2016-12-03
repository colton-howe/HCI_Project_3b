package com.firstdemo.a100520095.lab8;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ShowLocation extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private ArrayList<Marker> markers = new ArrayList<>();
    private ArrayList<Buildings> locations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_activity);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }
        ArrayList<Notes> UA = new ArrayList<>();
        ArrayList<Notes> UB = new ArrayList<>();
        ArrayList<Notes> ERC = new ArrayList<>();
        ArrayList<Notes> LIB = new ArrayList<>();
        UA.add(new Notes("Test Message","Admin","Wednesday, November 30th, 7:46 PM", "Message to show an example of how they could look"));
        locations.add(new Buildings("Science Building", "UA", UA));
        locations.add(new Buildings("Science Building", "UB", UB));
        locations.add(new Buildings("Science Building", "ERC", ERC));
        locations.add(new Buildings("Science Building", "LIB", LIB));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng school = new LatLng(43.9454, -78.8964);
        LatLng UA = new LatLng(43.944520, -78.896459);
        LatLng UB = new LatLng(43.945181, -78.896088);
        LatLng ERC = new LatLng(43.945595, -78.896298);
        LatLng LIB = new LatLng(43.945850, -78.897202);
        googleMap.setOnMarkerClickListener(this);

        markers.add(googleMap.addMarker(new MarkerOptions().position(UA)
                                                           .title("Science Building (UA)")
                                                           .snippet("UA")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.note_small))));
        markers.add(googleMap.addMarker(new MarkerOptions().position(UB)
                                                           .title("Business/IT Building (UB)")
                                                           .snippet("UB")
        .icon(BitmapDescriptorFactory.fromResource(R.drawable.note_small))));
        markers.add(googleMap.addMarker(new MarkerOptions().position(ERC)
                                                           .title("Energy Systems and Nuclear Science Research Center (ERC)")
                                                           .snippet("ERC")
                                                           .icon(BitmapDescriptorFactory.fromResource(R.drawable.note_small))));
        markers.add(googleMap.addMarker(new MarkerOptions().position(LIB)
                                                           .title("Campus Library (LIB)")
                                                           .snippet("LIB")
                                                           .icon(BitmapDescriptorFactory.fromResource(R.drawable.note_small))));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(school, 16));
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        if (markers.contains(marker)) {
            Intent intent = new Intent(this, LocationInfo.class);

            if(marker.getSnippet().equals("UA"))
                intent.putExtra("location", locations.get(0));
            else if (marker.getSnippet().equals("UB"))
                intent.putExtra("location", locations.get(1));
            else if (marker.getSnippet().equals("ERC"))
                intent.putExtra("location", locations.get(2));
            else if (marker.getSnippet().equals("LIB"))
                intent.putExtra("location", locations.get(3));

            startActivity(intent);
            return true;
        } else {
            return false;
        }
    }
}
