package controller.menus.entities.deck.command;

import com.beust.jcommander.Parameter;
import controller.menus.Command;

public class AddCard extends Command {
    /* Static Fields */
    private static final String name = "deck add-card";

    /* Instance Fields */
    @Parameter(names = {"-c", "--card"}, description = "name of card which you want to add to deck", required = true)
    private String cardName;

    @Parameter(names = {"-d", "--deck"}, description = "name of deck which you want to add card to it", required = true)
    private String deckName;

    @Parameter(names = {"-s", "--side"}, description = "if you want to add to side deck set this", arity = 0)
    private boolean side;

    /* Getters */

    @Override
    protected String getName() {
        return name;
    }
}
