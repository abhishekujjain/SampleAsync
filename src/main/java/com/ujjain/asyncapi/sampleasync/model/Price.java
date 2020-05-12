package com.ujjain.asyncapi.sampleasync.model;

/**
 * Created by abhishekujjain on 10/05/20.
 */
public class Price  {

    private String range;
    private Integer min;
    private Integer max;

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "Price{" +
                "range='" + range + '\'' +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
