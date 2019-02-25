package com.github.useful_solutions.classifier.pojo;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum Affiliation {

    municipal,
    commercial,
    suburban,
    season,
    special,
    interurban;

    private static final String MUNICIPAL = "Городской муниципальный маршрут";
    private static final String COMMERCIAL = "Городской коммерческий маршрут";
    private static final String SUBURBAN = "Пригородный маршрут";
    private static final String SEASON = "Сезонный (дачный) маршрут";
    private static final String SPECIAL = "Специальный маршрут";
    private static final String INTERURBAN = "Междугородний маршрут";

    @Nullable
    @SuppressWarnings("Duplicates")
    public static Affiliation convert(String affiliation) {
        switch (affiliation) {
            case MUNICIPAL:
                return municipal;
            case COMMERCIAL:
                return commercial;
            case SUBURBAN:
                return suburban;
            case SEASON:
                return season;
            case SPECIAL:
                return special;
            case INTERURBAN:
                return interurban;
            default:
                return null;
        }
    }

    @NotNull
    @SuppressWarnings("Duplicates")
    public static String convert(Affiliation affiliation) {
        switch (affiliation) {
            case municipal:
                return MUNICIPAL;
            case commercial:
                return COMMERCIAL;
            case suburban:
                return SUBURBAN;
            case season:
                return SEASON;
            case special:
                return SPECIAL;
            case interurban:
                return INTERURBAN;
            default:
                return null;
        }
    }

}
