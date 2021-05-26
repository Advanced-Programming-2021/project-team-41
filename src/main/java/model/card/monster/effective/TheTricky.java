package model.card.monster.effective;

import model.card.monster.CardType;
import model.card.monster.Monster;

public class TheTricky extends Monster {
    public TheTricky(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
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
}
