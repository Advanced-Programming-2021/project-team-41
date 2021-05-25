package model.card.spellAndTrap.spell;

import model.card.spellAndTrap.Icon;

public class SupplySquad extends Spell{
    public SupplySquad(String name, String description, int price) {

        super(name, Icon.CONTINUOUS, description, Status.UNLIMITED, price);

    }

    public void applyEffect() {

    }

    public void disableEffect() {

    }
}
