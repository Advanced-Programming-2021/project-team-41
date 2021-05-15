package model.card.monster.effective;

import model.card.monster.CardType;
import model.card.monster.Monster;

public class ExploderDragon extends Monster {
    public ExploderDragon(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
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

    public void applyEffect(Player opponent, Monater theMonsterThatAttacked) {
        opponent.getBoard().removeFromMonsters(theMonsterThatAttacked);
        opponent.getBoard().putOnGraveYard(theMonsterThatAttacked);
//        Dont call calculate damage function in controller after apply Effect
    }
}
