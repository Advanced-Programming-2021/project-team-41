package model.card.spellAndTrap.spell.normal;

import model.card.monster.Monster;
import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

public class Raigeki extends Spell {
    public Raigeki(String name, String description, int price) {
        super(name, Icon.NORMAL, description, Status.LIMITED, price);
    }

    public void applyEffect(Player opponent) {
        Board opponentBoard = opponent.getBoard();
        for (Monster monster : opponentBoard.getMonsters()) {
            opponentBoard.removeFromMonsters(monster);
            opponentBoard.putOnGraveYard(monster);
        }
    }
}
