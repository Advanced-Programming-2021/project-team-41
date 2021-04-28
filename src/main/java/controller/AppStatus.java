package controller;

public enum AppStatus {
    LOGIN_REGISTER, MAIN, DUEL, DECK, SCOREBOARD, PROFILE, SHOP, IMPORT_EXPORT, EXIT;

    //Hierarchy of menus
    public static AppStatus getUpperState(AppStatus appStatus) {
        if (appStatus == DUEL || appStatus == DECK || appStatus == SCOREBOARD || appStatus == PROFILE ||
                appStatus == SHOP || appStatus == IMPORT_EXPORT) {
            return MAIN;
        }
        if (appStatus == MAIN) return LOGIN_REGISTER;
        return EXIT;
    }
}
