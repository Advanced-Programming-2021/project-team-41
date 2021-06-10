package controller.menus.entities.gmae.phases;

import controller.menus.Commands;
import controller.menus.Menu;
import model.game.Game;

import java.util.ArrayList;

public class DrawPhase extends Menu {
    public static void run(Game game, Commands command, ArrayList<String> captured) {
        //if can not draw card player loses
        if (game.getWhoseTurnItIs().getBoard().getMainDeck().size() > 0) {
            game.getWhoseTurnItIs().getBoard().drawCard(1);
            // TODO print the name of card which is drawn
            // TODO print board in view
            // TODO apply trap card or quick play spell card (if the command is related to draw phase)
            // TODO print board in view if something was activated or changed
        }
        else game.setGameOver(true);
    }
}
