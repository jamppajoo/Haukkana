package kide.haukkana;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Jammu on 22.3.2017.
 */

public class Tab1MapsView extends Fragment implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1mapsview, container, false);

        /*SupportMapFragment mapFragment = (SupportMapFragment) findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);*/

        return rootView;
    }
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);


        } else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
            // Show rationale and request permission.
            mMap.setMyLocationEnabled(true);

        }

        mMap.setMyLocationEnabled(true);
        // Add a marker in Sydney and move the camera
        LatLng oulu = new LatLng(65.0126, 25.4715);
        mMap.addMarker(new MarkerOptions().position(oulu).title("Marker in Oulu"));
/*
        LocationManager locMan = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

        Criteria crit = new Criteria();

        Location loc = locMan.getLastKnownLocation(locMan.getBestProvider(crit, false));

        CameraPosition camPos = new CameraPosition.Builder()

                .target(new LatLng(loc.getLatitude(), loc.getLongitude()))

                .zoom(12.8f)

                .build();

        CameraUpdate camUpdate = CameraUpdateFactory.newCameraPosition(camPos);

        mMap.moveCamera(camUpdate);
*/
    }
}
