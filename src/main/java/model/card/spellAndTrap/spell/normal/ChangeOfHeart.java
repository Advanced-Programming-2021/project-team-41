package model.card.spellAndTrap.spell.normal;

import model.card.Card;
import model.card.monster.Monster;
import model.card.spellAndTrap.Icon;
import model.card.spellAndTrap.Status;
import model.card.spellAndTrap.spell.Spell;

import java.util.ArrayList;

public class ChangeOfHeart extends Spell {
    public ChangeOfHeart(String name, String description, int price) {
        super(name, Icon.NORMAL, description, Status.LIMITED, price);
    }

//    public void applyEffect(Player owner, Player opponent) {
////        select monster from opponent(call select function in game controller)
//        Monster selectedMonster;
////        get the status of the monster card from the user
//        CardStatus selectedCardStatus;
//        Board ownerBoard = owner.getBoard();
//        Board opponentBoard = opponent.getBoard();
//        opponent.removeFromMonsters(selectedMonster);
//        owner.putOnMonsterSection(selectedMonster, selectedCardStatus);
////        add disableEffect function to arrayList of function that call after the end of the turn
//        disApplyingEffectAtTheEndOfTheTurn.add(disableEffect(owner, opponent, selectedMonster))
//    }
//
//    public void disableEffect(Player owner, Player opponent, Monster monsterThatIsUnderControl) {
//        Board ownerBoard = owner.getBoard();
//        Board opponentBoard = opponent.getBoard();
//        ownerBoard.removeFromMonster(monsterThatIsUnderControl);
////        ask the opponent for status of monster that was under control of ChangeOfHeart owner.
//        CardStatus cardStatus ;
//        opponentBoard.putOnMonsterSection(monsterThatIsUnderControl, cardStatus);
//    }
}
