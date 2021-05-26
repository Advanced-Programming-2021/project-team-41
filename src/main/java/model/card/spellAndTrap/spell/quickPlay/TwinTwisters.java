package model.card.spellAndTrap.spell.quickPlay;

import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

public class TwinTwisters extends Spell {
    public TwinTwisters(String name, String description, int price) {

        super(name, Icon.QUICK_PLAY, description, Status.UNLIMITED, price);

    }

//    public void applyEffect(Player owner, Player opponent) {
//        select card from hand and remove that
//        select spell or trap card from opponent or owner board and destroy it, two time maximum
//        for(int i = 0; i<2; 1++){
//        asking user to destroying spell or trap card:
//        if dont want, break
//        else destroy selected card
//
//        notice that check the selected card be spell or trap card
//        }
//    }
}
