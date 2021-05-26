package model.card.spellAndTrap.spell;

import model.card.Type;
import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.SpellAndTrap;
import model.card.spellAndTrap.Status;

public abstract class Spell extends SpellAndTrap {
    public Spell(String name, Icon icon, String description, Status status, int price) {
        setType(Type.SPELL);
        setName(name);
        setIcon(icon);
        setDescription(description);
        setStatus(status);
        setPrice(price);
    }
}
