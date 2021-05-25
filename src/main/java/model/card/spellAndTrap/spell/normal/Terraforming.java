package model.card.spellAndTrap.spell.normal;

import model.card.Card;
import model.card.Type;
import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.SpellAndTrap;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

import java.util.ArrayList;

public class Terraforming extends Spell {
    public Terraforming(String name, String description, int price) {

        super(name, Icon.NORMAL, description, Status.LIMITED, price);

    }

//    public void applyEffect(Player owner) {
////        search in player deck and show the field spell cards
//        ArrayList<Spell> fieldCards = new ArrayList<>();
//        for (Card card : owner.getBoard().getHand()){
//            if (card.getType() == Type.SPELL) {
//                if (((Spell)card).getIcon() == Icon.FIELD){
//                    fieldCards.add((Spell) card);
//                }
//            }
//        }
//
////        show the array list with (index + 1) in the view
//
////        select one of those with call selectFunction in Game controller
//
////        put this selected card in hand( selected card property Exists in the game controller)
//    }
}
