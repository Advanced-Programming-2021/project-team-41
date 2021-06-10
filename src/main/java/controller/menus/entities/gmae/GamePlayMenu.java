package controller.menus.entities.gmae;

import controller.AppStatus;
import controller.menus.Commands;
import controller.menus.Menu;
import controller.menus.MenuEntities;
import controller.menus.entities.gmae.phases.*;
import model.game.Game;
import model.game.PhaseStatus;
import model.game.player.Player;

import java.util.ArrayList;

public class GamePlayMenu extends Menu {
    private static Game game = Game.getInstance();

    public static void run() {

        // set number of rounds
        // the two players show each other their side deck

        // set player one (the player who won beginning game)
        // and two before start the GamePlayMenu (create GamePlayMenu)

        //TODO print draw phase
        game.getWhoseTurnItIs().getBoard().drawCard(6);
        game.getOpponent().getBoard().drawCard(5);
        game.setPhase(PhaseStatus.MAIN_1);
        //TODO print main phase 1

        String enterCommand;
        MenuEntities menu = MenuEntities.GAME;
        ArrayList<String> captured;

        while (controller.getStatus() == AppStatus.GAME) {
            enterCommand = controller.scanner.nextLine().trim();
            Commands command = Commands.validCommands(enterCommand, menu);

            if (game.isGameOver()) endGame();
            else if (command == Commands.GAME_CHANGE_PHASE) nextPhase();
            else if (game.getPhase() == PhaseStatus.DRAW)
                DrawPhase.run(game, command, Commands.getGroups(enterCommand, command.getRegex()));
            else if (game.getPhase() == PhaseStatus.STANDBY)
                StandbyPhase.run(game, command, Commands.getGroups(enterCommand, command.getRegex()));
            else if (game.getPhase() == PhaseStatus.MAIN_1)
                MainPhase1.run(game, command, Commands.getGroups(enterCommand, command.getRegex()));
            else if (game.getPhase() == PhaseStatus.BATTLE)
                BattlePhase.run(game, command, Commands.getGroups(enterCommand, command.getRegex()));
            else if (game.getPhase() == PhaseStatus.MAIN_2)
                MainPhase2.run(game, command, Commands.getGroups(enterCommand, command.getRegex()));
            else if (game.getPhase() == PhaseStatus.END)
                EndPhase.run(game, command, Commands.getGroups(enterCommand, command.getRegex()));
        }


        // set loser player as starter of new round after end of one round
        //if the previous round is draw, play beginning game
        //and then start round two
    }

    private static void nextPhase() {
        if (game.getPhase() == PhaseStatus.DRAW) {
            game.setPhase(PhaseStatus.STANDBY);
            // TODO print standby phase
        } else if (game.getPhase() == PhaseStatus.STANDBY) {
            game.setPhase(PhaseStatus.MAIN_1);
            // TODO print main phase 1
        } else if (game.getPhase() == PhaseStatus.MAIN_1) {
            game.setPhase(PhaseStatus.BATTLE);
            // TODO print battle phase
        } else if (game.getPhase() == PhaseStatus.BATTLE) {
            game.setPhase(PhaseStatus.MAIN_2);
            // TODO print main phase 2
        } else if (game.getPhase() == PhaseStatus.MAIN_2) {
            game.setPhase(PhaseStatus.END);
            // TODO print end phase
        } else if (game.getPhase() == PhaseStatus.END) {
            switchTurn();
            // TODO print its <the next player nickname>'s turn
            game.setPhase(PhaseStatus.DRAW);
            // TODO print draw phase
        }
    }

    private static void switchTurn() {
        Player whoseTurnHasDone = game.getWhoseTurnItIs();
        game.setWhoseTurnItIs(game.getOpponent());
        game.setOpponent(whoseTurnHasDone);
    }

    private static void endGame() {
        //TODO calculate the points and return to Main menu
    }

    //-------------------------------------------------



    //--------------------------------------------------
//    private void selectMonster(ArrayList<String> captured) {
//        if (/*from own*/) {
//             game.setSelectedCard((Integer.parseInt(captured.get(1))));
//        } else if (/*from opponent*/) {
//
//        }
//    }
//
//    private static void selectSpellOrTrap(ArrayList<String> captured) {
//        if (/*from own*/) {
//
//        } else if (/*from opponent*/) {
//
//        }
//    }
//
//    private static void selectField(ArrayList<String> captured) {
//        if (/*from own*/) {
//
//        } else if (/*from opponent*/) {
//
//        }
//    }
//
//    private static void selectFromHand(ArrayList<String> captured) {
//
//    }

}
