package model.card.spellAndTrap.spell;

import model.card.spellAndTrap.Icon;

public class SpellAbsorption extends Spell{
    public SpellAbsorption(String name, String description, int price) {

        super(name, Icon.NORMAL, description, Status.UNLIMITED, price);

    }



}
