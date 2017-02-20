package fr.goui.gouither.map;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.goui.gouither.R;
import fr.goui.gouither.model.WeatherResult;

/**
 * Displays the Google maps V2 view.
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, IMapsView {

    private GoogleMap mMap;

    /**
     * Associated presenter.
     */
    private IMapsPresenter mPresenter;

    @BindView(R.id.forecast_preview_text_view)
    TextView mForecastPreviewTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ButterKnife.bind(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // creating the presenter
        mPresenter = new MapsPresenter();
        mPresenter.attachView(this);
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
        mMap.setOnMarkerClickListener(this);
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                // TODO clear all markers, add a new one and move to it
                addMarkerAndMove(latLng, "You clicked here!");
            }
        });
    }

    private void addMarkerAndMove(LatLng position, String message) {
        mMap.addMarker(new MarkerOptions().position(position).title(message));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(position));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        // TODO ask presenter to load information about location
        return false;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showProgressBar() {
        // TODO show progress bar
    }

    @Override
    public void hideProgressBar() {
        // TODO hide progress bar
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showResult(WeatherResult result) {
        // TODO fill in information
    }
}
