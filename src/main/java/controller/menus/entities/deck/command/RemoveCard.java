package controller.menus.entities.deck.command;

import com.beust.jcommander.Parameter;
import controller.menus.Command;

public class RemoveCard extends Command {
    /* Static Fields */
    private static final String name = "deck rm-card";

    /* Instance Fields */
    @Parameter(names = {"-c", "--card"}, description = "name of card which you want to remove from deck", required = true)
    private String cardName;

    @Parameter(names = {"-d", "--deck"}, description = "name of deck which you want to remove card from", required = true)
    private String deckName;

    @Parameter(names = {"-s", "--side"}, description = "if you want to remove from side deck set this", arity = 0)
    private boolean side;

    /* Getters */
    public String getCardName() {
        return cardName;
    }

    public String getDeckName() {
        return deckName;
    }

    public boolean isSide() {
        return side;
    }

    @Override
    protected String getName() {
        return name;
    }
}
