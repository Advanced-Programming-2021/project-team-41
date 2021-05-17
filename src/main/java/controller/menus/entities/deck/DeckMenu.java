package controller.menus.entities.deck;

import controller.AppStatus;
import controller.menus.Commands;
import controller.menus.Menu;
import controller.menus.MenuEntities;
import controller.menus.entities.deck.command.AddCard;
import controller.menus.entities.deck.command.DeckShow;
import controller.menus.entities.deck.command.RemoveCard;
import model.user.User;

import java.util.ArrayList;

public class DeckMenu extends Menu {
    /* Static Methods */
    public static void run() {
        String enterCommand;;
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
                if (deckShow.parse(Commands.getArgs(command, enterCommand)))showDeck(deckShow);
            } else if (command == Commands.DECK_SHOW_ALL_CARDS) showAllCards();
            else globalCommands(enterCommand, menu);
        }
    }


    private static void createNewDeck(ArrayList<String> captured) {
        System.out.println("In create new deck");
        //TODO: create new deck
    }

    private static void deleteDeck(ArrayList<String> captured) {
        System.out.println("In delete deck");
        //TODO: remove deck
    }

    private static void setAsActiveDeck(ArrayList<String> captured) {
        System.out.println("In set as active");
        //TODO: set deck as active
    }

    private static void addCardToDeck(AddCard addCard) {
        System.out.println("In add card");
        //TODO: add card to main or side deck
    }

    private static void removeCardFromDeck(RemoveCard removeCard) {
        System.out.println("In remove card");
        //TODO: remove card from main or side deck
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
