package model.database.DeckDB;

public class DeckDBException extends Exception {
    public DeckDBException(String msg) {
        super(msg);
    }
}

class DeckDoesNotExists extends DeckDBException {
    public DeckDoesNotExists(int deckId) {
        super(String.format("deck with id = (%d) doesn't exist", deckId));
    }
}
