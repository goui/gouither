package fr.goui.gouither.model;

/**
 * A data point object contains various properties, each representing the average (unless otherwise specified)
 * of a particular weather phenomenon occurring during a period of time: an instant in the case of currently,
 * a minute for minutely, an hour for hourly, and a day for daily.
 */
public class DataPoint {

    /**
     * The apparent (or “feels like”) temperature in degrees Fahrenheit.
     */
    private float apparentTemperature;

    /**
     * The maximum value of apparentTemperature during a given day.
     */
    private float apparentTemperatureMax;

    /**
     * The UNIX time of when apparentTemperatureMax occurs during a given day.
     */
    private float apparentTemperatureMaxTime;

    /**
     * The minimum value of apparentTemperature during a given day.
     */
    private float apparentTemperatureMin;

    /**
     * The UNIX time of when apparentTemperatureMin occurs during a given day.
     */
    private float apparentTemperatureMinTime;

    /**
     * The percentage of sky occluded by clouds, between 0 and 1, inclusive.
     */
    private float cloudCover;

    /**
     * The dew point in degrees Fahrenheit.
     */
    private float dewPoint;

    /**
     * The relative humidity, between 0 and 1, inclusive.
     */
    private float humidity;

    /**
     * A machine-readable text summary of this data point, suitable for selecting an icon for display.
     * If defined, this property will have one of the following values: clear-day, clear-night, rain,
     * snow, sleet, wind, fog, cloudy, partly-cloudy-day, or partly-cloudy-night.
     * (Developers should ensure that a sensible default is defined, as additional values, such as hail,
     * thunderstorm, or tornado, may be defined in the future.)
     */
    private String icon;

    /**
     * The fractional part of the lunation number during the given day: a value of 0 corresponds to
     * a new moon, 0.25 to a first quarter moon, 0.5 to a full moon, and 0.75 to a last quarter moon.
     * (The ranges in between these represent waxing crescent, waxing gibbous, waning gibbous,
     * and waning crescent moons, respectively.)
     */
    private float moonPhase;

    /**
     * The approximate direction of the nearest storm in degrees, with true north at 0° and
     * progressing clockwise. (If nearestStormDistance is zero, then this value will not be defined.)
     */
    private float nearestStormBearing;

    /**
     * The approximate distance to the nearest storm in miles. (A storm distance of 0 doesn’t
     * necessarily refer to a storm at the requested location, but rather a storm in the vicinity
     * of that location.)
     */
    private float nearestStormDistance;

    /**
     * The columnar density of total atmospheric ozone at the given time in Dobson units.
     */
    private float ozone;

    /**
     * The amount of snowfall accumulation expected to occur, in inches.
     * (If no snowfall is expected, this property will not be defined.)
     */
    private float precipAccumulation;

    /**
     * The intensity (in inches of liquid water per hour) of precipitation occurring at the given time.
     * This value is conditional on probability (that is, assuming any precipitation occurs at all)
     * for minutely data points, and unconditional otherwise.
     */
    private float precipIntensity;

    /**
     * The maximum value of precipIntensity during a given day.
     */
    private float precipIntensityMax;

    /**
     * The UNIX time of when precipIntensityMax occurs during a given day.
     */
    private long precipIntensityMaxTime;

    /**
     * The probability of precipitation occurring, between 0 and 1, inclusive.
     */
    private float precipProbability;

    /**
     * The type of precipitation occurring at the given time. If defined, this property will have
     * one of the following values: "rain", "snow", or "sleet" (which refers to each of freezing rain,
     * ice pellets, and “wintery mix”). (If precipIntensity is zero, then this property will not be defined.)
     */
    private String precipType;

    /**
     * The sea-level air pressure in millibars.
     */
    private double pressure;

    /**
     * A human-readable text summary of this data point.
     * (This property has millions of possible values, so don’t use it for automated purposes:
     * use the icon property, instead!)
     */
    private String summary;

    /**
     * The UNIX time of when the sun will rise during a given day.
     */
    private long sunriseTime;

    /**
     * The UNIX time of when the sun will set during a given day.
     */
    private long sunsetTime;

    /**
     * The air temperature in degrees Fahrenheit.
     */
    private float temperature;

    /**
     * The maximum value of temperature during a given day.
     */
    private float temperatureMax;

    /**
     * The UNIX time of when temperatureMax occurs during a given day.
     */
    private long temperatureMaxTime;

    /**
     * The minimum value of temperature during a given day.
     */
    private float temperatureMin;

    /**
     * The UNIX time of when temperatureMin occurs during a given day.
     */
    private long temperatureMinTime;

    /**
     * The UNIX time at which this data point begins. minutely data point are always aligned to
     * the top of the minute, hourly data point objects to the top of the hour, and daily data point
     * objects to midnight of the day, all according to the local time zone.
     */
    private long time;

    /**
     * The average visibility in miles, capped at 10 miles.
     */
    private float visibility;

    /**
     * The direction that the wind is coming from in degrees, with true north at 0° and progressing
     * clockwise. (If windSpeed is zero, then this value will not be defined.)
     */
    private float windBearing;

    /**
     * The wind speed in miles per hour.
     */
    private float windSpeed;

    public float getApparentTemperature() {
        return apparentTemperature;
    }

    public void setApparentTemperature(float apparentTemperature) {
        this.apparentTemperature = apparentTemperature;
    }

    public float getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    public void setApparentTemperatureMax(float apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    public float getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    public void setApparentTemperatureMaxTime(float apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    public float getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    public void setApparentTemperatureMin(float apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    public float getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    public void setApparentTemperatureMinTime(float apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public float getCloudCover() {
        return cloudCover;
    }

    public void setCloudCover(float cloudCover) {
        this.cloudCover = cloudCover;
    }

    public float getDewPoint() {
        return dewPoint;
    }

    public void setDewPoint(float dewPoint) {
        this.dewPoint = dewPoint;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(float moonPhase) {
        this.moonPhase = moonPhase;
    }

    public float getNearestStormBearing() {
        return nearestStormBearing;
    }

    public void setNearestStormBearing(float nearestStormBearing) {
        this.nearestStormBearing = nearestStormBearing;
    }

    public float getNearestStormDistance() {
        return nearestStormDistance;
    }

    public void setNearestStormDistance(float nearestStormDistance) {
        this.nearestStormDistance = nearestStormDistance;
    }

    public float getOzone() {
        return ozone;
    }

    public void setOzone(float ozone) {
        this.ozone = ozone;
    }

    public float getPrecipAccumulation() {
        return precipAccumulation;
    }

    public void setPrecipAccumulation(float precipAccumulation) {
        this.precipAccumulation = precipAccumulation;
    }

    public float getPrecipIntensity() {
        return precipIntensity;
    }

    public void setPrecipIntensity(float precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    public float getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    public void setPrecipIntensityMax(float precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    public long getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    public void setPrecipIntensityMaxTime(long precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    public float getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(float precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getPrecipType() {
        return precipType;
    }

    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public long getSunriseTime() {
        return sunriseTime;
    }

    public void setSunriseTime(long sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    public long getSunsetTime() {
        return sunsetTime;
    }

    public void setSunsetTime(long sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperatureMax() {
        return temperatureMax;
    }

    public void setTemperatureMax(float temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    public long getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    public void setTemperatureMaxTime(long temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    public float getTemperatureMin() {
        return temperatureMin;
    }

    public void setTemperatureMin(float temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    public long getTemperatureMinTime() {
        return temperatureMinTime;
    }

    public void setTemperatureMinTime(long temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public float getVisibility() {
        return visibility;
    }

    public void setVisibility(float visibility) {
        this.visibility = visibility;
    }

    public float getWindBearing() {
        return windBearing;
    }

    public void setWindBearing(float windBearing) {
        this.windBearing = windBearing;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }
}
