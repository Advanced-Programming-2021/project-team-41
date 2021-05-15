package model.card.monster.effective;

import model.card.monster.CardType;
import model.card.monster.Monster;

public class TexChanger extends Monster {
    private boolean isApply = false;

    public TexChanger(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
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

    //    after be attacked, check the isApply
//    if it is false :
    public void applyEffect() {
//        after negate attack:
//         Special Summon 1 Cyberse Normal Monster from your
//         hand, Deck, or GY.
        setApply(true);
    }

    public void disableApply() {
//setApply(false);
    }

    public boolean isApply() {
        return isApply;
    }

    public void setApply(boolean apply) {
        isApply = apply;
    }
}
