package model.user;

import model.card.Card;
import model.database.deck.DeckDB;
import model.database.user.UserDB;
import model.database.user.UserDBException;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User {
    /* Instance Fields */
    private final int id;
    private final String username;
    private String password;
    private String nickName;
    private final HashSet<Card> cards;
    private final HashSet<Deck> decks;
    private Deck activeDeck;
    private int score = 0;
    private final Wallet wallet;

    /* Constructor */
    public User(String username, String password, String nickname) throws Exception {
        // Validation
        if (UserDB.countUserByUsername(username) >= 1)
            throw new UsernameAlreadyExists(username);
        if (UserDB.countUserByNickname(nickname) >= 1)
            throw new NicknameAlreadyExists(nickname);

        Validator.usernameValid(username);
        Validator.passValid(password);
        Validator.nicknameValid(nickname);

        // Initialization
        this.username = username;
        this.nickName = nickname;
        this.password = password;
        this.wallet = new Wallet(this);
        this.cards = new HashSet<>();
        this.decks = new HashSet<>();

        // Insertion
        this.id = UserDB.insertUser(username, nickname, password, score, wallet.getAmount());
    }

    public User(int id, String username, String password, String nickName, int score, int money) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.score = score;
        this.wallet = new Wallet(this, money);
        this.cards = new HashSet<>();
        this.decks = new HashSet<>();
    }

    /* Getters And Setters */
    public void setActiveDeck(Deck activeDeck) {
        this.activeDeck = activeDeck;
    }

    public int getId() {
        return id;
    }

    public HashSet<Deck> getDecks() {
        return decks;
    }

    public HashSet<Card> getCards() {
        return cards;
    }

    public Deck getActiveDeck() {
        return activeDeck;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) throws UserDBException {
        UserDB.updateScore(this.id, score);
        this.score = score;
    }

    public Wallet getWallet() {
        return wallet;
    }

    /* Instance Methods */
    public void changePassword(String currentPassword, String newPassword) throws Exception {
        Validator.passValid(newPassword);
        if (!this.password.equals(currentPassword)) throw new InvalidCurrentPassword();
        if (this.password.equals(newPassword)) throw new RepeatedPassword();
        this.password = newPassword;
    }

    public void changeNickname(String newNickname) throws Exception {
        Validator.nicknameValid(newNickname);
        if (UserDB.countUserByNickname(nickName) >= 1) throw new NicknameAlreadyExists(nickName);
        this.nickName = newNickname;
    }

    public Deck getDeckByName(String deckName) {
        Stream<Deck> stream = this.getDecks().stream().filter(h -> h.getName().equals(deckName));
        if (!stream.findFirst().isPresent()) return null;
        return stream.findFirst().get();
    }

    public HashSet<Card> getCardsByName(String cardName) {
        return this.getCards().stream().filter(h -> h.getName().equals(cardName)).collect(Collectors.toCollection(HashSet::new));
    }

    public void addNewDeck(String deckName) throws Exception {
        Deck newDeck = new Deck(this, deckName);
        this.getDecks().add(newDeck);
        DeckDB.insertUserDeck(this.id, newDeck.getId());
    }

    public void removeDeck(String deckName) throws Exception {
        Deck selectedDeck = getDeckByName(deckName);
        if (selectedDeck == null) throw new DeckDoesNotExists(deckName);
        DeckDB.removeDeck(this.id, selectedDeck.getId());
        this.getDecks().remove(selectedDeck);
    }

    public void setAsActiveDeck(String deckName) throws Exception {
        Deck selectedDeck = getDeckByName(deckName);
        if (selectedDeck == null) throw new DeckDoesNotExists(deckName);
        this.activeDeck = selectedDeck;
    }

    public void addToUserCard(Card card) {
        this.getCards().add(card);
    }
}
