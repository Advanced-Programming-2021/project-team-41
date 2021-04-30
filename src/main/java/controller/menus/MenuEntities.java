package controller.menus;

import controller.AppStatus;

public enum MenuEntities {
    LOGIN_REGISTER("Login", AppStatus.LOGIN_REGISTER),
    MAIN("Main", AppStatus.MAIN),
    DUEL("Duel", AppStatus.DUEL),
    DECK("Deck", AppStatus.DECK),
    SCOREBOARD("Scoreboard", AppStatus.SCOREBOARD),
    PROFILE("Profile", AppStatus.PROFILE),
    SHOP("Shop", AppStatus.SHOP),
    IMPORT_EXPORT("Import/Export", AppStatus.IMPORT_EXPORT),
    GLOBAL("", null);

    private final String name;
    private final AppStatus appStatus;

    /* Constructor */
    MenuEntities(String name, AppStatus appStatus) {
        this.name = name;
        this.appStatus = appStatus;
    }

    /* Getters And Setters */
    public String getName() {
        return name;
    }

    public AppStatus getAppStatus() {
        return appStatus;
    }

    public static MenuEntities getMenuByName(String name) {
        for (MenuEntities menuEntity : MenuEntities.values()) {
            if (menuEntity.getName().equals(name)) return menuEntity;
        }
        return null;
    }
}
