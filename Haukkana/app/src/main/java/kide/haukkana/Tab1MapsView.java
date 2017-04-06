package kide.haukkana;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Debug;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


/**
 * Created by Jammu on 22.3.2017.
 */

public class Tab1MapsView extends Fragment  {
    private GoogleMap googleMap;
    MapView mMapView;

    ArrayList<Integer> storeID = new ArrayList<>();
    ArrayList<String> storeName = new ArrayList<>();
    ArrayList<Double> storeLan = new ArrayList<>();
    ArrayList<Double> storeLon = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1mapsview, container, false);

        mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        testDataPushes();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);


                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
                    // Show rationale and request permission.
                    mMap.setMyLocationEnabled(true);

                }

                // For dropping a marker at a point on the Map
                LatLng oulu = new LatLng(65.012360, 25.468160);

                for(int i = 0; i < storeID.size();i++)
                {
                    double distanceToMarker = 0;

                    LatLng Test = new LatLng(storeLan.get(i), storeLon.get(i));



                    googleMap.addMarker(new MarkerOptions().position(Test).title(storeName.get(i)).snippet("Test"));
                }



                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(oulu).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });


        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    public void testDataPushes(){
        storeID.add(0);
        storeName.add("Prisma Limingantulli");
        storeLan.add(64.994249);
        storeLon.add(25.461760);
        storeID.add(1);
        storeName.add("Oulu");
        storeLan.add(65.012360);
        storeLon.add(25.468160);
        storeID.add(2);
        storeName.add("Jammun kämppä :D");
        storeLan.add(64.997768);
        storeLon.add(25.517576);

    }
}
