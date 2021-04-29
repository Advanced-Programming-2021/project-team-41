package controller.menus;

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
}
