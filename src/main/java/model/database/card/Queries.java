package model.database.card;

public enum Queries {
    INSERT_CARD_TO_DECK("INSERT INTO `deck_card` (`deck_id`, `card_id`, `section`) VALUES (%d, %d, '%s')"),
    DELETE_CARD_FROM_DECK("DELETE FROM `deck_card` WHERE `deck_id` == %d AND `card_id` == %d AND `section` == '%s'"),
    GET_CARD_BY_ID("SELECT * FROM `card` WHERE `id` == %d"),
    GET_CARD_OFF_USER("SELECT * FROM `user_card`, `card` WHERE `user_card`.`user_id` == %d AND `user_card`.card_id == `card`.id");
    private final String query;

    Queries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
