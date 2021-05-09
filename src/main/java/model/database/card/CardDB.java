package model.database.card;

import model.database.DataBase;
import model.database.deck.DeckDB;
import model.database.deck.DeckDBException;
import model.database.user.UserDB;
import model.database.user.UserDBException;

import java.util.ArrayList;
import java.util.Dictionary;

public class CardDB {
    /* Static Fields */
    private static final DataBase dataBase = DataBase.getInstance();

    /* Static methods */
    public static int countCardById(int cardId) {
        return dataBase.getCount(String.format(Queries.GET_CARD_BY_ID.getQuery(), cardId));
    }

    public static void addCardToDeck(int deckId, int cardId, boolean isSide) throws DeckDBException, CardDoesNotExists {
        DeckDB.deckIdExistsInDatabase(deckId);
        cardIdExistsInDatabase(cardId);
        String mainOrSide = isSide ? "side" : "main";
        dataBase.exeUpdate(String.format(Queries.INSERT_CARD_TO_DECK.getQuery(), deckId, cardId, mainOrSide));
    }

    public static void removeCardFromDeck(int deckId, int cardId, boolean isSide) throws DeckDBException, CardDoesNotExists {
        DeckDB.deckIdExistsInDatabase(deckId);
        cardIdExistsInDatabase(cardId);
        String mainOrSide = isSide ? "side" : "main";
        dataBase.exeUpdate(String.format(Queries.DELETE_CARD_FROM_DECK.getQuery(), deckId, cardId, mainOrSide));
    }
    private static ArrayList<Dictionary<String,String>> getAllCardsOfUser(int userId) throws UserDBException {
        UserDB.userIdExistsInDatabase(userId);
        return dataBase.getResult(String.format(Queries.GET_CARD_OFF_USER.getQuery(), userId));
    }

    public static void cardIdExistsInDatabase(int cardId) throws CardDoesNotExists {
        if (countCardById(cardId) <= 0) throw new CardDoesNotExists(cardId);
    }
}
