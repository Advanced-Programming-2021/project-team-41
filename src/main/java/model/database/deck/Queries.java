package model.database.deck;

public enum Queries {
    INSERT_DECK("INSERT INTO deck (`name`) VALUES ('%s')"),
    INSERT_USER_DECK("INSERT INTO `user_deck` (`user_id`, `deck_id`) VALUES (%d, %d)"),
    GET_DECK_BY_ID("SELECT * FROM `deck` WHERE `id` == %d"),
    DELETE_DECK("DELETE FROM `deck` WHERE `id` == %d"),
    DELETE_USER_DECK("DELETE FROM `user_deck` WHERE `user_id` == %d AND `deck_id` == %d"),
    DELETE_CARD_DECK("DELETE FROM `deck_card` WHERE `deck_id` == %d"),
    GET_ALL_USER_DECK("SELECT `deck`.`id` as id, name FROM `user_deck`, `deck` WHERE `user_deck`.`user_id` = %d AND `deck`.`id` = `user_deck`.`deck_id`"),
    GET_DECK_MAIN_CARDS("SELECT GROUP_CONCAT(card_id) as 'cards' FROM deck_card WHERE deck_id = %d AND section == 'main' GROUP BY deck_id"),
    GET_DECK_SIDE_CARDS("SELECT GROUP_CONCAT(card_id) as 'cards' FROM deck_card WHERE deck_id = %d AND section == 'side' GROUP BY deck_id");

    private final String query;

    Queries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
