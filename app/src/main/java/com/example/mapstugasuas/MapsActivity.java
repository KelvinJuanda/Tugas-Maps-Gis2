package com.example.mapstugasuas;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

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

        // Add a marker in Bina Mulia Palu and move the camera
        LatLng BinaMuliaPalu = new LatLng(-0.885486, 119.875653);
        LatLng PangkalanTniAngkatanLautPalu = new LatLng(-0.872050, 119.875074);

        //custome size marker
        int tinggi = 50;
        int lebar = 50;
        BitmapDrawable bitmapStart = (BitmapDrawable)getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_standard_color_18);
        BitmapDrawable bitmapDes = (BitmapDrawable)getResources().getDrawable(com.google.android.gms.base.R.drawable.googleg_disabled_color_18);
        Bitmap s = bitmapStart.getBitmap();
        Bitmap d = bitmapDes.getBitmap();
        Bitmap markerStart = Bitmap.createScaledBitmap(s, lebar, tinggi, false);
        Bitmap markerDes = Bitmap.createScaledBitmap(d, lebar, tinggi, false);

        //add marker to map
        mMap.addMarker(new MarkerOptions().position(BinaMuliaPalu).title("Marker in STMIK Bina Mulia Palu")
                        .snippet("ini kampus saya")
                .icon(BitmapDescriptorFactory.fromBitmap(markerStart)));
        mMap.addMarker(new MarkerOptions().position(PangkalanTniAngkatanLautPalu).title("mark in Pangkalan Tni Angkatan Laut Palu")
                        .snippet("ini rumah saya")
                                .icon(BitmapDescriptorFactory.fromBitmap(markerDes)));

        mMap.addPolyline(new PolylineOptions().add(
                BinaMuliaPalu,
                        new LatLng(-0.885486, 119.875653),
                        new LatLng(-0.885486, 119.875653),
                        new LatLng(-0.885486, 119.875653),
                        new LatLng(-0.885140, 119.875723),
                        new LatLng(-0.884620, 119.875801),
                        new LatLng(-0.884387, 119.875914),
                        new LatLng(-0.883687, 119.876032),
                        new LatLng(-0.883151, 119.876129),
                        new LatLng(-0.882473, 119.876250),
                        new LatLng(-0.882086, 119.876319),
                        new LatLng(-0.881885, 119.876391),
                        new LatLng(-0.881628, 119.876552),
                        new LatLng(-0.881172, 119.876067),
                        new LatLng(-0.880829, 119.875651),
                        new LatLng(-0.880620, 119.874626),
                        new LatLng(-0.880448, 119.873797),
                        new LatLng(-0.880333, 119.872665),
                        new LatLng(-0.880011, 119.872676),
                        new LatLng(-0.879381, 119.872826),
                        new LatLng(-0.878496, 119.873100),
                        new LatLng(-0.877708, 119.873349),
                        new LatLng(-0.877021, 119.873558),
                        new LatLng(-0.876222, 119.873775),
                        new LatLng(-0.875501, 119.873992),
                        new LatLng(-0.874915, 119.874160),
                        new LatLng(-0.874188, 119.874396),
                        new LatLng(-0.873804, 119.874506),
                        new LatLng(-0.873313, 119.874645),
                        new LatLng(-0.872924, 119.874750),
                        new LatLng(-0.872291, 119.874948),
                        new LatLng(-0.872050, 119.875074),
                        PangkalanTniAngkatanLautPalu
                ).width(10)
                        .color(Color.BLUE)
        );

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BinaMuliaPalu, 14.5f ));
    }
}