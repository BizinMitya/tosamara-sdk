package com.github.useful_solutions.tosamara_sdk.calculate;

public class DistanceInfo {

    private double distance;
    private boolean crowflight;// true, если расстояние посчитано по прямой

    public DistanceInfo(double distance, boolean crowflight) {
        this.distance = distance;
        this.crowflight = crowflight;
    }

    public double getDistance() {
        return distance;
    }

    public boolean isCrowflight() {
        return crowflight;
    }

}
