package model.user;

public class DeckException extends Exception {
    public DeckException(String msg) {
        super(msg);
    }
}

class DeckAlreadyExists extends DeckException {
    public DeckAlreadyExists(String deckName) {
        super(String.format("deck with name %s already exists", deckName));
    }
}

class DeckDoesNotExists extends DeckException {
    public DeckDoesNotExists(String deckName) {
        super(String.format("deck with name %s does not exist", deckName));
    }
}

class DeckAddCard extends DeckException {
    public DeckAddCard(String cardName) {
        super(String.format("card with name %s does not exist", cardName));
    }
}

class DeckIsFull extends DeckException {
    public DeckIsFull(boolean isSide) {
        super(String.format("%s deck is full", isSide ? "side" : "main"));
    }
}

class AllowedCardInDeckExceed extends DeckException {
    public AllowedCardInDeckExceed(String cardName, String deckName) {
        super(String.format("there are already three cards with name %s in deck %s", cardName, deckName));
    }
}

class CardDoesNotExistsInDeck extends DeckException {
    public CardDoesNotExistsInDeck(String cardName, boolean isSide) {
        super(String.format("card with name %s does not exist in %s deck", cardName, isSide ? "side" : "main"));
    }
}