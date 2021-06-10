package controller.menus.entities.gmae.phases;

import controller.menus.Commands;
import controller.menus.Menu;
import model.card.monster.CardType;
import model.card.monster.Monster;
import model.game.Game;
import model.game.player.board.sections.CardSection;
import model.game.player.board.sections.HandSection;
import model.game.player.board.sections.monsterSection.MonsterStatus;

import java.util.ArrayList;

public class MainPhase1 extends Menu {
    public static void run(Game game, Commands command, ArrayList<String> captured) {
        if (command == Commands.GAME_SELECT_CARD) selectCard(game, captured);
        else if (command == Commands.GAME_DESELECT_CARD) deselectCard(game, captured);
        else if (command == Commands.GAME_SUMMON) {
            summon(game);
        }
    }


    /*Select*/
    private static void selectCard(Game game, ArrayList<String> captured) {
        //check that capture is one of hand or monster or spell or field zone or grave
        if (/*from own*/) {
            if (/*capture group that contain address is exist*/) {
                game.selectCardFromOwn(Integer.parseInt(captured.get(1)), /*Selected section name*/);
                // TODO print "card selected"
            } else {
                game.selectCardFromOwn(Integer.parseInt(captured.get(1)), /*Selected section name*/);
                // TODO print "card selected"
            }
        } else if (/*from opponent*/) {
            if (/*capture group that contain address is exist*/) {
                game.selectCardFromOpponent(Integer.parseInt(captured.get(1)), /*Selected section name*/);
                // TODO print "card selected"
            } else {
                game.selectCardFromOpponent(Integer.parseInt(captured.get(1)), /*Selected section name*/);
                // TODO print "card selected"
            }
        }
    }

    private static void deselectCard(Game game, ArrayList<String> captured) {
        // check selected card is not noll
        game.setSelectedCard(null);
        // TODO print "card deselected"
    }

    private static void summon(Game game) {
        CardSection cardSection = game.getSelectedCard();
        if (cardSection.getCard() != null) {

            if (cardSection instanceof HandSection &&
                    cardSection.getCard() instanceof Monster &&
                    ((Monster) cardSection.getCard()).getCardType() != CardType.RITUAL) {

                if (game.getWhoseTurnItIs().getBoard().isMonsterSectionFull()) {

                    if (game.getWhoseTurnItIs().isCanSummon()) {

                        if (((Monster) cardSection.getCard()).getLevel() < 5) {
                            game.getWhoseTurnItIs().getBoard().putOnMonstersSection(cardSection, MonsterStatus.OFFENSIVE_OCCUPIED);
                        } else {

                            if (((Monster) cardSection.getCard()).getLevel() < 8) {

                                if (game.getWhoseTurnItIs().getBoard().getNumberOfMonsters() > 0) {
                                    // select one card to tribute by player\
                                    // int tributeCard = ViewIn.scanner
                                    // remove it
                                    // game.getWhoseTurnItIs().getBoard().removeMonster(tributeCard);
                                    // summon selected card
                                } else //error

                            } else {

                                if (game.getWhoseTurnItIs().getBoard().getNumberOfMonsters() > 1) {
                                    // select two card to tribute by player(loop for two time or more, input number by player )
                                    // int tributeCard = ViewIn.scanner
                                    // remove it
                                    // game.getWhoseTurnItIs().getBoard().removeMonster(tributeCard);
                                    // summon selected card
                                } else //error
                            }
                        }

                    } else //error

                } else // error

            } else //error

        } else //error
    }
}
