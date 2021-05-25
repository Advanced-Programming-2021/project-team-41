package model.card.spellAndTrap.spell.continuos;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

public class SupplySquad extends Spell {
    public SupplySquad(String name, String description, int price) {

        super(name, Icon.CONTINUOUS, description, Status.UNLIMITED, price);

    }

    public void applyEffect() {

    }

    public void disableEffect() {

    }
}
