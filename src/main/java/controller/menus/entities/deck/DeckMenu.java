package controller.menus.entities.deck;

import controller.AppStatus;
import controller.menus.Commands;
import controller.menus.Menu;
import controller.menus.MenuEntities;
import controller.menus.entities.deck.command.AddCard;
import controller.menus.entities.deck.command.DeckShow;
import controller.menus.entities.deck.command.RemoveCard;
import model.user.Deck;
import model.user.User;

import java.util.ArrayList;

public class DeckMenu extends Menu {
    /* Static Methods */
    public static void run() {
        String enterCommand;
        MenuEntities menu = MenuEntities.DECK;

        while (controller.getStatus() == AppStatus.DECK) {
            enterCommand = controller.scanner.nextLine().trim();
            Commands command = Commands.validCommands(enterCommand, menu);

            // Control flow of app
            if (command == Commands.DECK_CREATE_NEW_DECK)
                createNewDeck(Commands.getGroups(enterCommand, command.getRegex()));
            else if (command == Commands.DECK_DELETE_DECK)
                deleteDeck(Commands.getGroups(enterCommand, command.getRegex()));
            else if (command == Commands.DECK_SET_AS_ACTIVE)
                setAsActiveDeck(Commands.getGroups(enterCommand, command.getRegex()));
            else if (command == Commands.DECK_ADD_CARD_TO_DECK) {
                AddCard addCard = new AddCard();
                if (addCard.parse(Commands.getArgs(command, enterCommand))) addCardToDeck(addCard);
            } else if (command == Commands.DECK_REMOVE_CARD_FROM_DECK) {
                RemoveCard removeCard = new RemoveCard();
                if (removeCard.parse(Commands.getArgs(command, enterCommand))) removeCardFromDeck(removeCard);
            } else if (command == Commands.DECK_SHOW_ALL_DECKS) showAllDecks();
            else if (command == Commands.DECK_SHOW_DECK) {
                DeckShow deckShow = new DeckShow();
                if (deckShow.parse(Commands.getArgs(command, enterCommand))) showDeck(deckShow);
            } else if (command == Commands.DECK_SHOW_ALL_CARDS) showAllCards();
            else globalCommands(enterCommand, menu);
        }
    }


    private static void createNewDeck(ArrayList<String> captured) {
        User user = controller.getUser();
        String deckName = captured.get(0);
        try {
            user.addNewDeck(deckName);
            System.out.println("deck created successfully!");//TODO: Send this to view
        } catch (Exception e) {
            System.out.println(e.getMessage());//TODO: Send this to view
        }
    }

    private static void deleteDeck(ArrayList<String> captured) {
        User user = controller.getUser();
        String deckName = captured.get(0);
        try {
            user.removeDeck(deckName);
            System.out.println("deck deleted successfully!");//TODO: Send this to view
        } catch (Exception e) {
            System.out.println(e.getMessage());//TODO: Send this to view
        }
    }

    private static void setAsActiveDeck(ArrayList<String> captured) {
        User user = controller.getUser();
        String deckName = captured.get(0);
        try {
            user.setAsActiveDeck(deckName);
            System.out.println("deck activated successfully!");//TODO: Send this to view
        } catch (Exception e) {
            System.out.println(e.getMessage());//TODO: Send this to view
        }
    }

    private static void addCardToDeck(AddCard addCard) {
        User user = controller.getUser();
        Deck selectedDeck;
        try {
            user.assertDeckExist(addCard.getDeckName());
            selectedDeck = user.getDeckByName(addCard.getDeckName());
            selectedDeck.addCardToDeck(addCard.getCardName(), addCard.isSide());
            System.out.println("card added to deck successfully");//TODO: Send this to view
        } catch (Exception e) {
            System.out.println(e.getMessage());//TODO: Send this to view
        }
    }

    private static void removeCardFromDeck(RemoveCard removeCard) {
        User user = controller.getUser();
        Deck selectedDeck;
        try {
            user.assertDeckExist(removeCard.getDeckName());
            selectedDeck = user.getDeckByName(removeCard.getDeckName());
            selectedDeck.removeCardFromDeck(removeCard.getCardName(), removeCard.isSide());
            System.out.println("card removed form deck successfully");//TODO: Send this to view
        } catch (Exception e) {
            System.out.println(e.getMessage());//TODO: Send this to view
        }
    }

    private static void showAllDecks() {
        System.out.println("in show all deck");
        //TODO: show all decks of user
    }

    private static void showDeck(DeckShow deckShow) {
        System.out.println("In deck show");
        //TODO: show main or side deck
    }

    private static void showAllCards() {
        System.out.println("In show all card");
        //TODO: show all cards of user
    }
}
