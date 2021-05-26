package model.card.spellAndTrap.spell.normal;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

public class MonsterReborn extends Spell {
    public MonsterReborn(String name, String description, int price) {
        super(name, Icon.NORMAL, description, Status.LIMITED, price);
    }

    public void applyEffect(Game game) {
//        call special summon from game controller, then
//        special summon from card owner grave yard orr opponent grave yard

    }
}
