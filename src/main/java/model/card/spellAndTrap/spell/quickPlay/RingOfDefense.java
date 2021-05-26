package model.card.spellAndTrap.spell.quickPlay;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

public class RingOfDefense extends Spell {
    public RingOfDefense(String name, String description, int price) {

        super(name, Icon.QUICK_PLAY, description, Status.UNLIMITED, price);

    }


}
