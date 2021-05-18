package view.deckmenu;

import model.user.Deck;

import java.util.HashSet;

public class DeckView {
    /* Static methods */
    public static void showAllDecks(Deck activeDeck, HashSet<Deck> otherDecks) {
        String formattedOutput = "Decks:\nActive deck:\n%sOther decks:\n%s";
        StringBuilder stringBuilder = new StringBuilder();
        for (Deck otherDeck : otherDecks) {
            stringBuilder.append(otherDecks);
        }
        System.out.printf(formattedOutput, activeDeck, stringBuilder);
    }

    public static void showResult(String res) {
        System.out.println(res);
    }
}
