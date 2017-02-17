package fr.goui.gouither.model;

import java.util.List;

/**
 * DTO for the request response.
 */
public class WeatherResult {

    /**
     * The requested latitude.
     */
    private double latitude;

    /**
     * The requested longitude.
     */
    private double longitude;

    /**
     * The IANA timezone name for the requested location. This is used for text summaries and for
     * determining when hourly and daily data block objects begin.
     */
    private String timezone;

    /**
     * A data point containing the current weather conditions at the requested location.
     */
    private DataPoint currently;

    /**
     * A data block containing the weather conditions minute-by-minute for the next hour.
     */
    private DataBlock minutely;

    /**
     * A data block containing the weather conditions hour-by-hour for the next two days.
     */
    private DataBlock hourly;

    /**
     * A data block containing the weather conditions day-by-day for the next week.
     */
    private DataBlock daily;

    /**
     * An alerts array, which, if present, contains any severe weather alerts pertinent to the requested location.
     */
    private List<Alert> alerts;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public DataPoint getCurrently() {
        return currently;
    }

    public void setCurrently(DataPoint currently) {
        this.currently = currently;
    }

    public DataBlock getMinutely() {
        return minutely;
    }

    public void setMinutely(DataBlock minutely) {
        this.minutely = minutely;
    }

    public DataBlock getHourly() {
        return hourly;
    }

    public void setHourly(DataBlock hourly) {
        this.hourly = hourly;
    }

    public DataBlock getDaily() {
        return daily;
    }

    public void setDaily(DataBlock daily) {
        this.daily = daily;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }
}
