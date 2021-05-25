package model.card.spellAndTrap.spell;

import model.card.spellAndTrap.Icon;

public class DarkHole extends Spell{
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
