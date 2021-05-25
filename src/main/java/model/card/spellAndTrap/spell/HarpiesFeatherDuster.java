package model.card.spellAndTrap.spell;

import model.card.spellAndTrap.Icon;

public class HarpiesFeatherDuster extends Spell {
    public HarpiesFeatherDuster(String name, String description, int price) {

        super(name, Icon.NORMAL, description, Status.LIMITED, price);

    }

    public void applyEffect(Player opponent) {
        opponent.getBoard().removeAllSpells();
    }
}
