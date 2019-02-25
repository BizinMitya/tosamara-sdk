package com.github.useful_solutions.api.record.pojo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum TransportType {

    bus,
    metro,
    tram,
    trolleybus,
    railway,
    riverfleet;

    private static final String BUS = "Автобус";
    private static final String TRAM = "Трамвай";
    private static final String TROLLEYBUS = "Троллейбус";
    private static final String METRO = "Метро";
    private static final String RAILWAY = "Железная дорога";
    private static final String RIVERFLEET = "Речной транспорт";

    @Nullable
    @SuppressWarnings("Duplicates")
    public static TransportType convert(String transportType) {
        switch (transportType) {
            case BUS:
                return bus;
            case TRAM:
                return tram;
            case TROLLEYBUS:
                return trolleybus;
            case METRO:
                return metro;
            case RAILWAY:
                return railway;
            case RIVERFLEET:
                return riverfleet;
            default:
                return null;
        }
    }

    @NotNull
    @SuppressWarnings("Duplicates")
    public static String convert(TransportType transportType) {
        switch (transportType) {
            case bus:
                return BUS;
            case tram:
                return TRAM;
            case trolleybus:
                return TROLLEYBUS;
            case metro:
                return METRO;
            case railway:
                return RAILWAY;
            case riverfleet:
                return RIVERFLEET;
            default:
                return null;
        }
    }

}
