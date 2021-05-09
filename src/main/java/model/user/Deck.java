package model.user;

import model.card.Card;
import model.database.card.CardDB;
import model.database.deck.DeckDB;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Deck {
    /* Static Fields */
    private static final int MAIN_MIN = 40;
    private static final int MAIN_MAX = 60;
    private static final int SIDE_MIN = 0;
    private static final int SIDE_MAX = 15;
    private static final int LIMIT_CARD = 3;

    /* Instance Fields */
    private final int id;
    private final User user;
    private final String name;
    private final Set<Card> main;
    private final Set<Card> side;
    private boolean isValid = false;

    /* Constructor */
    Deck(User user, String name) throws Exception {
        Validator.deckNameValid(name);
        if (user.getDeckByName(name) != null) throw new DeckAlreadyExists(name);
        this.user = user;
        this.name = name;
        this.id = DeckDB.insertDeck(name);
        this.side = new HashSet<>();
        this.main = new HashSet<>();
    }

    Deck(int id, User user, String name, Set<Card> main, Set<Card> side) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.main = main;
        this.side = side;
        this.checkValid();
    }

    /* Getters And Setters */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /* Instance Methods */
    public void addCardToDeck(String cardName, boolean isSide) throws Exception {
        Card card = cardNotInDeck(this.user.getCardsByName(cardName));
        if (card == null) throw new DeckAddCard(cardName);
        if (isFull(isSide)) throw new DeckIsFull(isSide);
        if (numberOfCardInMain(cardName) + numberOfCardInSide(cardName) >= LIMIT_CARD)
            throw new AllowedCardInDeckExceed(cardName, this.getName());
        if (isSide) side.add(card);
        else main.add(card);
        checkValid();
        CardDB.addCardToDeck(this.getId(), card.getId(), isSide);
    }

    private void checkValid() {
        if (this.isValid) return;
        this.isValid = main.size() >= MAIN_MIN && side.size() >= SIDE_MIN;
    }

    public void removeCardFromDeck(String cardName, boolean isSide) throws Exception {
        int number = isSide ? numberOfCardInSide(cardName) : numberOfCardInMain(cardName);
        if (number == 0) throw new CardDoesNotExistsInDeck(cardName,isSide);
        Card card = getCardInDeck(cardName, isSide);
        if (isSide) this.side.remove(card);
        else this.main.remove(card);
        CardDB.removeCardFromDeck(this.getId(), card.getId(), isSide);
    }

    public Card getCardInDeck(String cardName, boolean isSide) {
        Set<Card> cards = isSide ? this.side : this.main;
        Stream<Card> res = cards.stream().filter(h -> h.getName().equals(cardName));
        if (!res.findFirst().isPresent()) return null;
        return res.findFirst().get();
    }

    private int numberOfCardInMain(String cardName) {
        return (int) (main.stream().filter(h -> h.getName().equals(cardName)).count());
    }

    private int numberOfCardInSide(String cardName) {

        return (int) side.stream().filter(h -> h.getName().equals(cardName)).count();
    }

    private boolean isFull(boolean isSide) {
        return (isSide && side.size() >= SIDE_MAX) || (!isSide && side.size() >= MAIN_MAX);
    }

    private Card cardNotInDeck(HashSet<Card> cards) {
        for (Card card : cards) {
            if (!main.contains(card) && !side.contains(card)) return card;
        }
        return null;
    }

    @Override
    public String toString() {
        String format = "%s: main deck %d, side deck %d, %s";
        return String.format(format, this.name, this.main.size(), this.side.size());
    }
}
