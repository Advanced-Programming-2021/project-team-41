package model.card.spellAndTrap.spell.quickPlay;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

public class MysticalSpaceTyphoon extends Spell {
    public MysticalSpaceTyphoon(String name, String description, int price) {

        super(name, Icon.QUICK_PLAY, description, Status.UNLIMITED, price);

    }

//    public void applyEffect(Player owner, Player opponent) {
//      select spell or trap card from opponent or owner board and destroy it
//
//    }
}
