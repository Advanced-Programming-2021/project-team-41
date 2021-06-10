package controller.menus.entities.gmae.phases;

import controller.menus.Commands;
import controller.menus.Menu;
import model.game.Game;

import java.util.ArrayList;

public class StandbyPhase extends Menu {

    public static void run(Game game, Commands command, ArrayList<String> captured) {
        // TODO print board

        // show list of card that whose turn it is can apply
        // get player selection
        // apply trap card or quick play spell card
        // apply some effective card
    }
}
