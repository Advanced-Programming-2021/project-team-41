package model.card.monster.effective;

import model.card.Card;
import model.card.monster.CardType;
import model.card.monster.Monster;

public class ManEaterBug extends Monster {
    public ManEaterBug(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
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

    //    FLIP: Target 1 monster on the field, after that
    public void applyEffect(Player opponent, Monster selectedCard) {
        opponent.getBoard().removeFromMonsters(selectedCard);
    }
}
