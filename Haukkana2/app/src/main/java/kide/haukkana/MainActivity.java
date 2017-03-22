package kide.haukkana;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView2);
        mapFragment.getMapAsync(this);


    }

    public void mapsViewButtonClick(View view) {

    }

    public void listViewButtonClick(View view) {
        Intent intent = new Intent(this,ListViewActivity.class);
        startActivity(intent);

    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);


        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
            // Show rationale and request permission.
            mMap.setMyLocationEnabled(true);

        }

        mMap.setMyLocationEnabled(true);
        // Add a marker in Sydney and move the camera
        LatLng oulu = new LatLng(65.0126, 25.4715);
        mMap.addMarker(new MarkerOptions().position(oulu).title("Marker in Oulu"));

        LocationManager locMan = (LocationManager)this.getSystemService(Context.LOCATION_SERVICE);

        Criteria crit = new Criteria();

        Location loc = locMan.getLastKnownLocation(locMan.getBestProvider(crit, false));

        CameraPosition camPos = new CameraPosition.Builder()

                .target(new LatLng(loc.getLatitude(), loc.getLongitude()))

                .zoom(12.8f)

                .build();

        CameraUpdate camUpdate = CameraUpdateFactory.newCameraPosition(camPos);

        mMap.moveCamera(camUpdate);

    }


}
