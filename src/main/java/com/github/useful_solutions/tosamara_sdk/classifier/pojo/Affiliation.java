package com.github.useful_solutions.tosamara_sdk.classifier.pojo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public enum Affiliation {

    MUNICIPAL("Городской муниципальный маршрут"),
    COMMERCIAL("Городской коммерческий маршрут"),
    SUBURBAN("Пригородный маршрут"),
    SEASON("Сезонный (дачный) маршрут"),
    SPECIAL("Специальный маршрут"),
    INTERURBAN("Междугородний маршрут");

    private String description;

    Affiliation(String description) {
        this.description = description;
    }

    @Nullable
    public static Affiliation convert(String description) {
        return Stream.of(Affiliation.values())
                .filter(tt -> tt.description.equals(description))
                .findFirst().orElse(null);
    }

    public static String convert(@NotNull Affiliation affiliation) {
        return affiliation.description;
    }

}
