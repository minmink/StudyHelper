package edu.skku.finalproject.studyhelper;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLngBounds.Builder builder = LatLngBounds.builder();
        LatLng[] latLngs = {new LatLng(37.588212, 126.994176), new LatLng(37.588484, 126.997738), new LatLng(37.586988, 126.997877), new LatLng(37.584199, 126.996493)};
        for (int idx = 0; idx < 4; idx++) {

            MarkerOptions makerOptions = new MarkerOptions();
            makerOptions
                    .position(latLngs[idx])
                    .title("마커" + idx);

            mMap.addMarker(makerOptions);
            builder.include(latLngs[idx]);
        }

        LatLngBounds bounds = builder.build();
        mMap.addMarker(new MarkerOptions().position(bounds.getCenter())
                .title("중앙"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bounds.getCenter()));
    }


}

