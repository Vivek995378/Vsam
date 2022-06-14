package com.app.vsam.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import com.app.vsam.R;
import com.app.vsam.adapters.PostImageAdapter;
import com.app.vsam.models.PostData;

public class SearchFragment extends Fragment {

    RecyclerView recyclerView;
    GoogleMap mGoogleMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        //Initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map);

        //Async map
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull @NotNull GoogleMap googleMap) {
                //When map is ready
                mGoogleMap = googleMap;
                MapStyleOptions mapStyleOptions = MapStyleOptions.loadRawResourceStyle(getActivity(), R.raw.style_map1);
                mGoogleMap.setMapStyle(mapStyleOptions);
                googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(@NonNull @NotNull LatLng latLng) {
                        //when click on map initializing marker option
                        MarkerOptions markerOptions = new MarkerOptions();
                        //setting position of marker
                        markerOptions.position(latLng);     //latLng - Latitude/Longitude
                        //set title of marker
                        markerOptions.title(latLng.latitude + " : " + latLng.longitude);
                        //remove all markers
                        googleMap.clear();
                        //Animating to zoom the marker
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom( latLng , 10));
                        //Add marker on map
                        googleMap.addMarker(markerOptions);

                    }
                });

            }
        });

        recyclerView = view.findViewById(R.id.recyclerView3);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3 , StaggeredGridLayoutManager.VERTICAL));
        init();

        return view;
    }

    private void init() {

        List<PostData> postData = new ArrayList<>();

        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));
        postData.add(new PostData(R.drawable.pic));
        postData.add(new PostData(R.drawable.picc));
        postData.add(new PostData(R.drawable.piccc));
        postData.add(new PostData(R.drawable.picccc));
        postData.add(new PostData(R.drawable.piccccc));

        recyclerView.setAdapter(new PostImageAdapter(getActivity() , postData));

    }

}
