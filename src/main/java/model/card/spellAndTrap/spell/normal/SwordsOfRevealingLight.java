package model.card.spellAndTrap.spell.normal;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.spell.Spell;

public class SwordsOfRevealingLight extends Spell {
    public int numberOfTurnThatHasBeenInGame = 0;

    public SwordsOfRevealingLight(String name, String description, int price) {

        super(name, Icon.NORMAL, description, Status.UNLIMITED, price);

    }

    public void applyEffect(Player opponent) {
        for (Monster monster : opponentBoard.getMonsters()) {
            monster.setCanAttack(false);
        }
        setNumberOfTurnThatHasBeenInGame(getNumberOfTurnThatHasBeenInGame() + 1);
        if (numberOfTurnThatHasBeenInGame == 3) {
//            add disableEffect(opponent) to Effct judge
        }
    }

    public void disableEffect(Player opponent) {
        Board opponentBoard = opponent.getBoard();
        for (Monster monster : opponentBoard.getMonsters()) {
            monster.setCanAttack(true);
        }
        opponentBoard.removeFromSpells(this);
        opponentBoard.putOnGraveYard(this);
    }

    public int getNumberOfTurnThatHasBeenInGame() {
        return numberOfTurnThatHasBeenInGame;
    }

    public void setNumberOfTurnThatHasBeenInGame(int numberOfTurnThatHasBeenInGame) {
        this.numberOfTurnThatHasBeenInGame = numberOfTurnThatHasBeenInGame;
    }
}
