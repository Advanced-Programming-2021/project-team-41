package model.database.deck;

import model.database.DataBase;
import model.database.user.UserDB;
import model.database.user.UserDBException;

import java.util.*;
import java.util.stream.Collectors;

public class DeckDB {
    /* Static Fields */
    private static final DataBase dataBase = DataBase.getInstance();

    public static int countDeckById(int deckId) {
        return dataBase.getCount(String.format(Queries.GET_DECK_BY_ID.getQuery(), deckId));
    }

    public static int insertDeck(String deckName) {
        dataBase.exeUpdate(String.format(Queries.INSERT_DECK.getQuery(), deckName));
        return dataBase.getGenerateKey();
    }

    public static void insertUserDeck(int userId, int deckId) throws UserDBException {
        UserDB.userIdExistsInDatabase(userId);
        dataBase.exeUpdate(String.format(Queries.INSERT_USER_DECK.getQuery(), userId, deckId));
    }

    public static void removeDeck(int userId, int deckId) throws UserDBException, DeckDoesNotExists {
        UserDB.userIdExistsInDatabase(userId);
        deckIdExistsInDatabase(deckId);
        dataBase.exeUpdate(String.format(Queries.DELETE_USER_DECK.getQuery(), userId, deckId));
        dataBase.exeUpdate(String.format(Queries.DELETE_CARD_DECK.getQuery(), deckId));
        dataBase.exeUpdate(String.format(Queries.DELETE_DECK.getQuery(), deckId));
    }

    public static ArrayList<Dictionary<String, String>> getAllUserDeck(int userId) {
        return dataBase.getResult(String.format(Queries.GET_ALL_USER_DECK.getQuery(), userId));
    }

    public static List<Integer> getDeckMainCards(int deckId) throws DeckDoesNotExists {
        deckIdExistsInDatabase(deckId);
        String cards = dataBase.getResult(String.format(Queries.GET_DECK_MAIN_CARDS.getQuery(), deckId)).get(0).get("cards");
        return Arrays.stream(cards.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static List<Integer> getDeckSideCards(int deckId) throws DeckDoesNotExists {
        deckIdExistsInDatabase(deckId);
        String cards = dataBase.getResult(String.format(Queries.GET_DECK_SIDE_CARDS.getQuery(), deckId)).get(0).get("cards");
        return Arrays.stream(cards.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }


    public static void deckIdExistsInDatabase(int deckId) throws DeckDoesNotExists {
        if (countDeckById(deckId) <= 0) throw new DeckDoesNotExists(deckId);
    }
}
