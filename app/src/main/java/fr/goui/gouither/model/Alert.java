package fr.goui.gouither.model;

import java.net.URI;
import java.util.List;

/**
 * The alerts represent the severe weather warnings issued for the requested location by a
 * governmental authority.
 */
public class Alert {

    /**
     * A detailed description of the alert.
     */
    private String description;

    /**
     * The UNIX time at which the alert will expire. (Some alerts sources, unfortunately,
     * do not define expiration time, and in these cases this parameter will not be defined.)
     */
    private long expires;

    /**
     * An array of strings representing the names of the regions covered by this weather alert.
     */
    private List<String> regions;

    /**
     * The severity of the weather alert. Will take one of the following values:
     * "advisory"      * (an individual should be aware of potentially severe weather),
     * "watch" (an individual should prepare for potentially severe weather),
     * or "warning" (an individual should take immediate action to protect themselves and others from potentially severe weather).
     */
    private String severity;

    /**
     * The UNIX time at which the alert was issued.
     */
    private long time;

    /**
     * A brief description of the alert.
     */
    private String title;

    /**
     * An HTTP(S) URI that one may refer to for detailed information about the alert.
     */
    private URI uri;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getExpires() {
        return expires;
    }

    public void setExpires(long expires) {
        this.expires = expires;
    }

    public List<String> getRegions() {
        return regions;
    }

    public void setRegions(List<String> regions) {
        this.regions = regions;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
