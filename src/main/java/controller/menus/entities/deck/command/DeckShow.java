package controller.menus.entities.deck.command;

import com.beust.jcommander.Parameter;
import controller.menus.Command;

public class DeckShow extends Command {
    /* Static Fields */
    private static final String name = "deck show";

    /* Instance Fields */
    @Parameter(names = {"-d", "--deck"}, description = "name of deck which you want to show", required = true)
    private String deckName;

    @Parameter(names = {"-s", "--side"}, description = "if you want to show side deck set this", arity = 0)
    private boolean side;

    /* Getters */
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
