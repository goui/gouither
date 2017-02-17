package fr.goui.gouither.model;

import java.util.List;

/**
 * A data block object represents the various weather phenomena occurring over a period of time.
 */
public class DataBlock {

    /**
     * An array of data points, ordered by time, which together describe the weather conditions at
     * the requested location over time.
     */
    private List<DataPoint> data;

    /**
     * A human-readable summary of this data block.
     */
    private String summary;

    /**
     * A machine-readable text summary of this data block. (May take on the same values as the
     * icon property of data points.)
     */
    private String icon;

    public List<DataPoint> getData() {
        return data;
    }

    public void setData(List<DataPoint> data) {
        this.data = data;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
