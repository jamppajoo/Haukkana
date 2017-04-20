package kide.haukkana;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Debug;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static android.content.Context.LOCATION_SERVICE;


/**
 * Created by Jammu on 22.3.2017.
 */

public class Tab1MapsView extends Fragment  {
    private GoogleMap googleMap;
    MapView mMapView;

    ArrayList<Integer> storeID = new ArrayList<>();
    ArrayList<String> storeName = new ArrayList<>();
    ArrayList<Double> storeLan = new ArrayList<>();
    ArrayList<Double> storeLng = new ArrayList<>();
    ArrayList<Integer> storeTypeID = new ArrayList<>();
    ArrayList<Double> storeDistance = new ArrayList<>();
    ArrayList<Marker> markers = new ArrayList<>();

    LatLng userLatLng  = new LatLng(65.012360, 25.468160);

    Location userLocation = new Location("");
    Location markerLocation = new Location("");


    double distanceToMarker;


        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1mapsview, container, false);

            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_DENIED){

                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
            }

            Toast toast = Toast.makeText(getActivity().getApplicationContext(), "Finding user location", Toast.LENGTH_LONG);
            toast.show();


            mMapView = (MapView) rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately
        testDataGet();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

            LocationManager service = (LocationManager) getActivity().getSystemService(LOCATION_SERVICE);
            Criteria criteria = new Criteria();
            String provider = service.getBestProvider(criteria, false);
            final Location location = service.getLastKnownLocation(provider);
            try{
                userLatLng = new LatLng(location.getLatitude(),location.getLongitude());
            }catch (NullPointerException e){

                Log.e("ASD", "" +e);
            }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;
                try {
                    boolean success = googleMap.setMapStyle(
                            MapStyleOptions.loadRawResourceStyle(
                                    getActivity(), R.raw.style_json));
                    if (!success) {
                        Log.e("ASD", "Style parsing failed.");
                    }
                } catch (Resources.NotFoundException e) {
                    Log.e("ASD", "Can't find style. Error: ", e);
                }

                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    mMap.setMyLocationEnabled(true);
                }
                else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    // Show rationale and request permission.
                    mMap.setMyLocationEnabled(true);

                }

                GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
                    @Override
                    public void onMyLocationChange (Location location) {
                        try {

                            userLatLng = new LatLng (location.getLatitude(), location.getLongitude());
                        }catch (NullPointerException e){}
                        for(int i = 0; i < storeID.size();i++) {

                            markerLocation.setLatitude(storeLan.get(i));
                            markerLocation.setLongitude(storeLng.get(i));
                            userLocation.setLatitude(userLatLng.latitude);
                            userLocation.setLongitude(userLatLng.longitude);

                            distanceToMarker = markerLocation.distanceTo(userLocation);

                            markers.get(i).setSnippet(String.format("%.2f", distanceToMarker / 1000) + " km");
                            //testDistancePush(storeID.get(i),distanceToMarker);
                        }

                    }
                };
                googleMap.setOnMyLocationChangeListener(myLocationChangeListener);




                // For dropping a marker at a point on the Map
                LatLng oulu = new LatLng(65.012360, 25.468160);



                for(int i = 0; i < storeID.size();i++)
                {

                    try {
                        userLocation.setLatitude(userLatLng.latitude);
                        userLocation.setLongitude(userLatLng.longitude);
                    }catch (NullPointerException e )
                    {
                        Log.e("ASD","" + e);
                    }


                    distanceToMarker = markerLocation.distanceTo(userLocation);


                    LatLng markerLatLng = new LatLng(storeLan.get(i), storeLng.get(i));

                    BitmapDescriptor markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.haukkana_ylavalikko);


                    switch (storeTypeID.get(i)){
                        case 1:
                            markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.skaupat_maps_44x50);
                            break;
                        case 2:
                            markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.kmarket_maps_44x50);
                            break;
                        case 3:
                            markerIcon = BitmapDescriptorFactory.fromResource(R.drawable.lidl_maps_44x50);
                            break;

                    }


                   Marker marker =  googleMap.addMarker(new MarkerOptions()
                           .position(markerLatLng).title(storeName.get(i))
                           .snippet(String.format("%.2f", distanceToMarker / 1000)+ " km")
                           .icon(markerIcon));
                    marker.setTag(storeID.get(i));
                    markers.add(marker);

                    googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            Intent intent1 = new Intent(getActivity().getApplicationContext(), ShopinfoActivity.class);
                            intent1.putExtra("shopID", marker.getTag().toString());
                            startActivity(intent1);
                        }
                    });

                }



                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(oulu).zoom(12).build();
                if(userLocation != null && googleMap != null)
                {
                    CameraPosition.Builder builder = new CameraPosition.Builder();
                    builder.zoom(14);
                    builder.target(userLatLng);
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(builder.build()));
                }
                else{
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                }

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

    public void testDataGet(){
        BackEndCommunication BC = new BackEndCommunication();

        storeID = BC.storeID;
        storeLng = BC.storeLng;
        storeLan = BC.storeLan;
        storeName = BC.storeName;
        storeTypeID = BC.storeTypeID;

    }
    public void testDistancePush(int ID, double distance){
        BackEndCommunication BC = new BackEndCommunication();
        BC.storeDistance.set(ID,distance);
    }
}
