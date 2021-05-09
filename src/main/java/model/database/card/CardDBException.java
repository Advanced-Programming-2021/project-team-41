package model.database.card;

public class CardDBException extends Exception {
    public CardDBException(String msg) {
        super(msg);
    }
}

class CardDoesNotExists extends CardDBException {
    public CardDoesNotExists(int cardId) {
        super(String.format("card with id = (%d) doesn't exist", cardId));
    }
}
