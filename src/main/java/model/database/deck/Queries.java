package model.database.deck;

public enum Queries {
    INSERT_DECK("INSERT INTO deck (`name`) VALUES ('%s')"),
    INSERT_USER_DECK("INSERT INTO `user_deck` (`user_id`, `deck_id`) VALUES (%d, %d)"),
    GET_DECK_BY_ID("SELECT * FROM `deck` WHERE `id` == %d"),
    DELETE_DECK("DELETE FROM `deck` WHERE `id` == %d"),
    DELETE_USER_DECK("DELETE FROM `user_deck` WHERE `user_id` == %d AND `deck_id` == %d"),
    DELETE_CARD_DECK("DELETE FROM `deck_card` WHERE `deck_id` == %d");

    private final String query;

    Queries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
