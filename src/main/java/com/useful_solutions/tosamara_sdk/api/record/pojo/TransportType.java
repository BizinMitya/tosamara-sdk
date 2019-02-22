package com.useful_solutions.tosamara_sdk.api.record.pojo;

public enum TransportType {

    bus,
    metro,
    tram,
    trolleybus,
    railway, // пока не поддерживается?
    riverfleet; // пока не поддерживается?

    private static final String BUS = "Автобус";// проверено
    private static final String TRAM = "Трамвай";// проверено
    private static final String TROLLEYBUS = "Троллейбус";// проверено
    private static final String METRO = "Метро";// проверено
    private static final String RAILWAY = "Железная дорога";// проверено
    private static final String RIVERFLEET = "Речной транспорт";//TODO: проверить

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
