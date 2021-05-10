package model.user;

import model.card.Card;
import model.database.card.CardDB;
import model.database.deck.DeckDB;
import model.database.deck.DeckDBException;
import model.database.user.UserDB;
import model.database.user.UserDBException;

import java.util.Dictionary;
import java.util.HashSet;
import java.util.Optional;

public class UserLoader {
    public static User loadUser(String username, String password) throws UsernameAndPasswordDidNotMatch, UserDBException, DeckDBException, CardNotFindInUsersCard, CanNotFindActiveDeckInDecks {
        HashSet<Card> userCards;
        Dictionary<String, String> userInfo;
        User user;
        if (UserDB.countUserByUsername(username) <= 0) throw new UsernameAndPasswordDidNotMatch();
        userInfo = UserDB.getUser(username);
        if (!userInfo.get("password").equals(password)) throw new UsernameAndPasswordDidNotMatch();
        // Create user
        user = new User(Integer.parseInt(userInfo.get("id")), username, password, userInfo.get("nickname"),
                Integer.parseInt(userInfo.get("score")), Integer.parseInt(userInfo.get("money")));

        // Now load
        userCards = loadUserCards(Integer.parseInt(userInfo.get("id")));
        loadDecks(user, userCards, user.getId());
        setActiveDeck(user, userInfo.get("active_deck"));
        return user;
    }

    public static void setActiveDeck(User user, String activeDeckId) throws CanNotFindActiveDeckInDecks {
        if (!activeDeckId.equals("")) {
            Optional<Deck> opt = user.getDecks().stream().
                    filter(deck -> deck.getId() == Integer.parseInt(activeDeckId)).findFirst();
            if (!opt.isPresent()) throw new CanNotFindActiveDeckInDecks();
            user.setActiveDeck(opt.get());
        }
    }

    public static void loadDecks(User user, HashSet<Card> userCards, int userId) throws DeckDBException, CardNotFindInUsersCard {
        for (Dictionary<String, String> deckInfo : DeckDB.getAllUserDeck(userId)) {
            HashSet<Card> used = new HashSet<>(), main = new HashSet<>(), side = new HashSet<>();
            for (Integer cardId : DeckDB.getDeckMainCards(Integer.parseInt(deckInfo.get("id")))) {
                addCardToDeck(used, userCards, cardId, main);
            }
            for (Integer cardId : DeckDB.getDeckSideCards(Integer.parseInt(deckInfo.get("id")))) {
                addCardToDeck(used, userCards, cardId, side);
            }
            user.getDecks().add(new Deck(Integer.parseInt(deckInfo.get("id")), user, deckInfo.get("name"), main, side));
        }
    }

    public static void addCardToDeck(HashSet<Card> used, HashSet<Card> userCards, int cardId, HashSet<Card> mainOrSide) throws CardNotFindInUsersCard {
        Card currentSelected;
        Optional<Card> opt = userCards.stream().filter(card -> card.getId() == cardId &&
                !used.contains(card)).findFirst();
        if (!opt.isPresent()) throw new CardNotFindInUsersCard();
        currentSelected = opt.get();
        used.add(currentSelected);
        mainOrSide.add(currentSelected);
    }

    public static HashSet<Card> loadUserCards(int userId) throws UserDBException {
        HashSet<Card> loadedCards = new HashSet<>();

        for (Dictionary<String, String> card : CardDB.getAllCardsOfUser(userId)) {
            loadedCards.add(new Card(Integer.parseInt(card.get("id")),
                    card.get("name"),
                    card.get("type"),
                    Integer.parseInt(card.get("level")), card.get("attribute"),
                    card.get("monster_type"), card.get("card_type"),
                    Integer.parseInt(card.get("attack")),
                    Integer.parseInt(card.get("defence")),
                    card.get("property"),
                    card.get("status"),
                    card.get("description"),
                    Integer.parseInt(card.get("price"))));
        }
        return loadedCards;
    }
}
