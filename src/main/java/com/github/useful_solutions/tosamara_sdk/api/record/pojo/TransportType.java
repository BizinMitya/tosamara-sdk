package com.github.useful_solutions.tosamara_sdk.api.record.pojo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public enum TransportType {

    BUS("Автобус"),
    METRO("Метро"),
    TRAM("Трамвай"),
    TROLLEYBUS("Троллейбус"),
    RAILWAY("Железная дорога"),
    RIVER_FLEET("Речной транспорт");

    private String name;

    TransportType(String name) {
        this.name = name;
    }

    @Nullable
    public static TransportType convert(String name) {
        return Stream.of(TransportType.values())
                .filter(tt -> tt.name.equals(name))
                .findFirst().orElse(null);
    }

    public static String convert(@NotNull TransportType transportType) {
        return transportType.name;
    }

}
