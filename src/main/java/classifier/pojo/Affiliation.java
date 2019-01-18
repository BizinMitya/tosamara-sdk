package classifier.pojo;

public enum Affiliation {

    municipal,
    commercial,
    suburban,
    season,
    special,
    interurban;

    private static final String MUNICIPAL = "Городской муниципальный маршрут";// проверено
    private static final String COMMERCIAL = "Городской коммерческий маршрут";// проверено
    private static final String SUBURBAN = "Пригородный маршрут";// проверено
    private static final String SEASON = "Сезонный (дачный) маршрут";// проверено
    private static final String SPECIAL = "Специальный маршрут";// проверено
    private static final String INTERURBAN = "Междугородний маршрут";//TODO: проверить

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

}
