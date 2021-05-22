package model.card.spellAndTrap.spell;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;

public class PotOfGreed extends Spell{
    public PotOfGreed(String name, String description, int price) {
        super(name, Icon.NORMAL, description, Status.LIMITED, price);
    }

    public void applyEffect(Player owner) {
//        double call drawCardFunction for owner
    }
}
