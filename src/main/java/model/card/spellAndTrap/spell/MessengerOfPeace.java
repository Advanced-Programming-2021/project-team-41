package model.card.spellAndTrap.spell;

import model.card.spellAndTrap.Icon;

public class MessengerOfPeace extends Spell{
    public MessengerOfPeace(String name, String description, int price) {

        super(name, Icon.CONTINUOUS, description, Status.UNLIMITED, price);

    }

//during standby phase in each turn, destroy this card or spend 100 LP

    public void applyEffect(Player opponent) {
        for (Monster monster : opponent.getBoard().getMonasters()) {
            monster.setCanAttack(false);
        }
    }
}
