package model.card.spellAndTrap.trap.normal;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.trap.Trap;

public class MindCrush extends Trap {
    public MindCrush(String name, String description, int price) {
        super(name, Icon.NORMAL, description, Status.UNLIMITED, price);
    }

    public void applyEffect() {
//        announce a card
//        if the card exists in opponent hand, discard all card like that
//        else mind crush owner must discard a random card
    }
}
