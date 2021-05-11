package model.card.monster.effective;

import model.card.monster.CardType;
import model.card.monster.Monster;

public class YomiShip extends Monster {
    public YomiShip(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
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

//     after destroy yomi ship, remove the card that attacked
    public void applyEffect(Player playerWhoAttacked, Monster theCardThatAttacked) {
        playerWhoAttacked.getBoard().removeFromMonsters(theCardThatAttacked);
    }
}
