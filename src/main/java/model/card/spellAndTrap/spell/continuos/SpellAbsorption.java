package model.card.spellAndTrap.spell.continuos;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

public class SpellAbsorption extends Spell {
    public SpellAbsorption(String name, String description, int price) {

        super(name, Icon.CONTINUOUS, description, Status.UNLIMITED, price);

    }



}
