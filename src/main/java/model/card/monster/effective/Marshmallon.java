package model.card.monster.effective;

import model.card.monster.CardType;
import model.card.monster.Monster;

public class Marshmallon extends Monster {
    public Marshmallon(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
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

    public void applyEffect(Player opponent, CardStatus cardStatus) {
        if (cardStatus.equal("DEFENCE_HIDDEN"), cardStatus.eqaul("DEFENCE_OCCUPIED")){
            opponent.subtractToLifePoint(1000);
        }
    }
}
