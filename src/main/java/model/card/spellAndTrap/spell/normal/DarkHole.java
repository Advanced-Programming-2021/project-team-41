package model.card.spellAndTrap.spell.normal;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

public class DarkHole extends Spell {
    public DarkHole(String name, String description, int price) {

        super(name, Icon.NORMAL, description, Status.UNLIMITED, price);

    }

    public void applyEffect(Player owner, Player opponent) {
        Board ownerBoard = owner.getBoard();
        Board opponentBoard = opponent.getBoard();

        ownerBoard.removeAllMonster();
        opponentBoard.removeAllMonster();
    }
}
