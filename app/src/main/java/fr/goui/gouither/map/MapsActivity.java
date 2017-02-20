package fr.goui.gouither.map;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.goui.gouither.R;

/**
 * Displays the Google maps V2 view.
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, IMapsView {

    private GoogleMap mMap;

    /**
     * Associated presenter.
     */
    private IMapsPresenter mPresenter;

    @BindView(R.id.forecast_preview_text_view)
    TextView mForecastPreviewTextView;

    @BindView(R.id.forecast_progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.forecast_temperature_text_view)
    TextView mTemperatureTextView;

    @BindView(R.id.forecast_humidity_text_view)
    TextView mHumidityTextView;

    @BindView(R.id.forecast_precipitation_probability_text_view)
    TextView mPrecipitationTextView;

    @BindView(R.id.forecast_wind_speed_text_view)
    TextView mWindSpeedTextView;

    @BindView(R.id.forecast_cloud_cover_text_view)
    TextView mCloudCoverTextView;

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
        mMap.getUiSettings().setMapToolbarEnabled(false);
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mPresenter.onMapClick(latLng);
            }
        });
    }

    @Override
    public void clearMarkers() {
        mMap.clear();
    }

    @Override
    public void addMarker(LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng).title(latLng.latitude + ", " + latLng.longitude));
    }

    @Override
    public void moveCameraTo(LatLng latLng) {
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hidePreviewText() {
        mForecastPreviewTextView.setVisibility(View.GONE);
    }

    @Override
    public void setTemperature(int temperature) {
        mTemperatureTextView.setText(String.format(getString(R.string.deg_celcius_placeholder), temperature));
    }

    @Override
    public void setHumidity(int humidity) {
        mHumidityTextView.setText(String.format(getString(R.string.percentage_placeholder), humidity));
    }

    @Override
    public void setPrecipitationProbability(int precipitationProbability) {
        mPrecipitationTextView.setText(String.format(getString(R.string.percentage_placeholder), precipitationProbability));
    }

    @Override
    public void setWindSpeed(float windSpeed) {
        mWindSpeedTextView.setText(String.format(getString(R.string.km_h_placeholder), windSpeed));
    }

    @Override
    public void setCloudCover(int cloudCover) {
        mCloudCoverTextView.setText(String.format(getString(R.string.percentage_placeholder), cloudCover));
    }
}
