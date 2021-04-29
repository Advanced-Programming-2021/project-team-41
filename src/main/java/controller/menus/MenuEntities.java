package controller.menus;

import java.util.ArrayList;

public enum MenuEntities {
    LOGIN_REGISTER("Login"),
    MAIN("Main"),
    DUEL("Duel"),
    DECK("Deck"),
    SCOREBOARD("Scoreboard"),
    PROFILE("Profile"),
    SHOP("Shop"),
    IMPORT_EXPORT("Import/Export"),
    GLOBAL("");

    private final String name;

    /* Constructor */
    MenuEntities(String name) {
        this.name = name;
    }

    /* Getters And Setters */
    public String getName() {
        return name;
    }

    public static ArrayList<String> getAllMenusName() {
        ArrayList<String> allMenusName = new ArrayList<>();
        for (MenuEntities menuEntity : MenuEntities.values()) {
            if (menuEntity != MenuEntities.GLOBAL) allMenusName.add(menuEntity.getName());
        }
        return allMenusName;
    }
}
