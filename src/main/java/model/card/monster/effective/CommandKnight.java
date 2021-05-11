package model.card.monster.effective;

import model.card.monster.CardType;
import model.card.monster.Monster;

public class CommandKnight extends Monster {
    public CommandKnight(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
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

    //    after checking that is it face up , if it was face up:
//    public void applyEffect(Player owner, Player opponent) {
//        Board ownerBoard = owner.gerBoard();
//        for (int i = 1; i < 7; i++) {
//            Monster monsterOnBoard = ownerBoard.getMonster(i);
//            if (monsterOnBoard != null && monsterOnBoard != this) {
//                monsterOnBoard.addToAttack(400);
//            }
//        }
//    }
}
