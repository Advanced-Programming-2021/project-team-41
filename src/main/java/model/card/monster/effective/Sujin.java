package model.card.monster.effective;

import model.card.Card;
import model.card.monster.CardType;
import model.card.monster.Monster;

public class Sujin extends Monster {
    //   notice : reset to true after coming out of grave
    private int attackCardAttackValue;
    private boolean isEffectApplied = false;

    public Sujin(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
        setName(name);
        setLevel(level);
        setAttribute(attribute);
        setMonsterType(monsterType);
        setCardType(CardType.EFFECT);
        setAttack(attack);
        setDefence(defence);
        setDescription(description);
        setPrice(price);
    }

    public void applyEffect(Player playerWhoAttacked, Monster theCardThatAttacked) {
        theCardThatAttacked.subtractFromAttack(theCardThatAttacked.getAttack());
        setEffectApplied(true);
        setAttackCardAttackValue(theCardThatAttacked.getAttack());
//        after call this function, add disable function to arraylist in effect manager
    }

//    check the apply status before apply in controller
    public boolean isEffectApplied() {
        return isEffectApplied;
    }

    public int getAttackCardAttackValue() {
        return attackCardAttackValue;
    }

    public void setAttackCardAttackValue(int attackCardAttackValue) {
        this.attackCardAttackValue = attackCardAttackValue;
    }

    public void setEffectApplied(boolean effectApplied) {
        isEffectApplied = effectApplied;
    }

    //    after the end of the turn :
    public void disableEffect(Monster theCardThatAttacked) {
        theCardThatAttacked.addToAttack(getAttackCardAttackValue());
    }
}
