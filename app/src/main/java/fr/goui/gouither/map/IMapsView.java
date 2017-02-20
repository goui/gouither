package fr.goui.gouither.map;

import com.google.android.gms.maps.model.LatLng;

import fr.goui.gouither.IView;
import fr.goui.gouither.model.WeatherResult;

/**
 * View interface for the map.
 */
interface IMapsView extends IView {

    /**
     * Clears existing markers.
     */
    void clearMarkers();

    /**
     * Adds a marker at the specific location.
     */
    void addMarker(LatLng latLng);

    /**
     * Moves camera to the specific location.
     *
     * @param latLng
     */
    void moveCameraTo(LatLng latLng);

    /**
     * Hides the text displayed at the application launch.
     */
    void hidePreviewText();

    /**
     * Shows the temperature.
     *
     * @param temperature the temperature
     */
    void setTemperature(int temperature);

    /**
     * Shows the humidity percentage.
     *
     * @param humidity the humidity percentage
     */
    void setHumidity(int humidity);

    /**
     * Shows the precipitation probability percentage.
     *
     * @param precipitationProbability the precipitation probability percentage
     */
    void setPrecipitationProbability(int precipitationProbability);

    /**
     * Shows the wind speed.
     *
     * @param windSpeed the wind speed
     */
    void setWindSpeed(float windSpeed);

    /**
     * Shows the cloud cover percentage.
     *
     * @param cloudCover the cloud cover percentage
     */
    void setCloudCover(int cloudCover);
}
