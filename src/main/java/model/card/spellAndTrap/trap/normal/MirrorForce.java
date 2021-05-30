package model.card.spellAndTrap.trap.normal;

import model.card.monster.Monster;
import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.trap.Trap;

public class MirrorForce extends Trap {
    public MirrorForce(String name, String description, int price) {
        super(name, Icon.NORMAL, description, Status.UNLIMITED, price);
    }

    public void applyEffect() {
//        if the opponent announces an attack(command attack)
//        get monsters from opponent Board
//        remove all monster that is in offensive occupied status
    }
}
