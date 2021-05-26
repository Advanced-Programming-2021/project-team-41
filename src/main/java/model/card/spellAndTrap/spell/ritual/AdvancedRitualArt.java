package model.card.spellAndTrap.spell.ritual;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

public class AdvancedRitualArt extends Spell {
    public AdvancedRitualArt(String name, String description, int price) {

        super(name, Icon.RITUAL, description, Status.UNLIMITED, price);

    }

    public void applyEffect() {
//        select cards from deck that sum of its level equals with ritual monster level
//        check the equality of level and sum of levels
//        ritual summon(removing cards and putting in grave and asking the card status and then summon)
    }
}
