package model.card.monster.effective;

import model.card.monster.CardType;
import model.card.monster.Monster;

import java.util.ArrayList;

public class TheCalculator extends Monster {
    public TheCalculator(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
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

    public void applyEffect(Player owner) {
        int totalLevelsOfMonsters = 0;
        int i = 0;
        ArrayList<Monster> monsters = owner.getBoard().getMonsters();
        for (CardStatus monsterStatus : owner.getBoard().getMonstersStatus()) {
            if (!monsterStatus.equals("DEFENCE_HIDDEN")) {
                totalLevelsOfMonsters += monsters.get(i).getLevel();
            }
            i++;
        }

    }
}
