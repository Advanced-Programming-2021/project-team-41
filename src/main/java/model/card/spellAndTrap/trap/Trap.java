package model.card.spellAndTrap.trap;

import model.card.Type;
import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.SpellAndTrap;
import model.card.spellAndTrap.Status;

public abstract class Trap extends SpellAndTrap {
    public Trap(String name, Icon icon, String description, Status status, int price) {
        setType(Type.TRAP);
        setName(name);
        setIcon(icon);
        setDescription(description);
        setStatus(status);
        setPrice(price);
    }
}
