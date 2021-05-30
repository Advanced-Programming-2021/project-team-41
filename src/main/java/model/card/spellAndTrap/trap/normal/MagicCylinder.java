package model.card.spellAndTrap.trap.normal;

import model.card.monster.Monster;
import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.trap.Trap;

public class MagicCylinder extends Trap {
    public MagicCylinder(String name, String description, int price) {
        super(name, Icon.NORMAL, description, Status.UNLIMITED, price);
    }

    public void applyEffect(Player opponent, Monster theMonsterThatAttacked) {
//        if the opponent announces an attack(command attack)
//        call attack a monster to another monster from game controller and pass the monster as two input
    }
}
